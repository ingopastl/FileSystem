package pratica3;

import java.util.Arrays;

public class Execute {

	public static void main(String[] args) {
		FileManager f = new FileManager();
		f.root.getReferences().add(new Directory("users"));
		((Directory)f.root.getReferences().get(0)).getReferences().add(new File("readme.txt"));

		f.runCommand("pwd");
		f.runCommand("cd /users");
		f.runCommand("pwd");
		f.runCommand("cd /");
		f.runCommand("pwd");
		
		System.out.println(f.accessObject("users/readme.txt"));
		
		System.out.println();
		System.out.println();
		f.runCommand("mkdir /users/newdir");
	}

}
