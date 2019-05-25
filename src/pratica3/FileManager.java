package pratica3;

public class FileManager {

	public Directory root = new Directory("/");
	public SystemObject pwd = root;

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
		} else if (commands[0].equals("pwd")) {
			System.out.println(pwd);
		} else if (commands[0].equals("touch")) {

		} else if (commands[0].equals("mkdir")) {
			commandMkdir(commands);
		} else if (commands[0].equals("rmdir")) {

		} else if (commands[0].equals("rm")) {

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
	
	private void commandMkdir(String [] commands) {
		int i;
		for (i = commands[1].length() - 1; i > 0 && commands[1].charAt(i) != '/'; i--) {
			
		}
		String c = "";
		for (int j = 0; j < i; j++) {
			c += commands[1].charAt(j);
		}
		String dirname = "";
		for (int j = i + 1; j < commands[1].length(); j++) {
			dirname += commands[1].charAt(j);
		}
		Directory current = (Directory) accessObject(c);
		
		current.newDirectory(dirname);
		System.out.println(current);
	}
}
