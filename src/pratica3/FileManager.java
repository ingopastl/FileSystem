package pratica3;

public class FileManager {

	public Directory root = new Directory("/");
	public SystemObject pwd = root;
	private DiskManager mDisk = new DiskManager(12);

	public SystemObject accessObject(String path) {
		String[] aux = path.split("/");
		SystemObject current = null;

		if (path.equals("/")) {
			current = root;
		} else {
			if (aux[0].equals("")) {
				current = accessViaAbsolutePath(path);
			} else {
				current = accessViaRelativePath(path);
			}
		}

		return current;
	}

	public void runCommand(String command) {
		String[] commands = command.split(" ");
		if (commands[0].equals("cd")) {
			pwd = accessObject(commands[1]);
			if (pwd == null) {
				System.err.println("cd failed, pwd back to root");
				pwd = root;
			}
		} else if (commands[0].equals("pwd")) {
			System.out.println(pwd);
			
			
		} else if (commands[0].equals("touch")) {
			if (mDisk.getFreeSpaces() >= 3) {
				commandoTouch(commands);
				SystemObject aux = accessObject(commands[1]);
				mDisk.allocateFile((File)aux, 3);
			} else {
				System.err.println("File does not fit in disk");
			}
			System.out.println(mDisk);
			
			
		} else if (commands[0].equals("mkdir")) {
			if (mDisk.getFreeSpaces() >= 1) {
				commandMkdir(commands);
				SystemObject aux = accessObject(commands[1]);
				mDisk.allocateDirectory((Directory)aux);
			} else {
				System.err.println("Directory does not fit in disk");
			}
			System.out.println(mDisk);
		} else if (commands[0].equals("rmdir")) {
			SystemObject aux = accessObject(commands[1]);
			if (aux instanceof Directory) {
				aux.parent.getReferences().remove(aux);
				System.out.println("Directory " + aux.name + " deleted");
				mDisk.deallocate(aux);
				System.out.println(mDisk);
			} else {
				System.err.println(aux.name + " is not a directory");
			}
		} else if (commands[0].equals("rm")) {
			SystemObject aux = accessObject(commands[1]);
			if (aux instanceof File) {
				aux.parent.getReferences().remove(aux);
				System.out.println("File " + aux.name + " deleted");
				mDisk.deallocate(aux);
				System.out.println(mDisk);
			}
		} else {
			System.out.println(accessObject(command));
		}
	}

	private SystemObject accessViaAbsolutePath(String path) {
		String[] aux = path.split("/");
		SystemObject current = root;
		for (int i = 1; i < aux.length; i++) {
			if (i < aux.length - 1 && current instanceof File) {
				System.err.println(aux[i] + " is not a directory");
				break;
			}
			current = ((Directory) current).getChild(aux[i]);
		}
		return current;
	}

	private SystemObject accessViaRelativePath(String path) {
		SystemObject current = pwd;
		String[] aux = path.split("/");
		for (int i = 0; i < aux.length; i++) {
			if (i < aux.length - 1 && current instanceof File) {
				System.err.println(aux[i] + " is not a directory");
				break;
			}
			current = ((Directory) current).getChild(aux[i]);
		}
		return current;
	}

	public SystemObject getPwd() {
		return pwd;
	}

	public void setPwd(SystemObject pwd) {
		this.pwd = pwd;
	}

	private void commandMkdir(String[] commands) {
		int i;
		for (i = commands[1].length() - 1; i > 0 && commands[1].charAt(i) != '/'; i--) {

		}
		String c = "";
		for (int j = 0; j < i; j++) {
			c += commands[1].charAt(j);
		}
		String dirname = "";
		for (int j = i; j < commands[1].length(); j++) {
			dirname += commands[1].charAt(j);
		}
		Directory current = (Directory) accessObject(c);

		current.newDirectory(dirname);
		System.out.println(current);
	}

	private void commandoTouch(String[] commands) {
		int i;
		for (i = commands[1].length() - 1; i > 0 && commands[1].charAt(i) != '/'; i--) {

		}
		String c = "";
		for (int j = 0; j < i; j++) {
			c += commands[1].charAt(j);
		}
		String fileName = "";
		for (int j = i; j < commands[1].length(); j++) {
			fileName += commands[1].charAt(j);
		}
		Directory current = (Directory) accessObject(c);

		current.newFile(fileName);
		System.out.println(current);
	}
}
