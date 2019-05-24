package pratica3;

import java.util.Arrays;

public class Execute {

	public static void main(String[] args) {
		FileManager f = new FileManager();
		f.root.getReferences().add(new Directory("users"));
		((Directory)f.root.getReferences().get(0)).getReferences().add(new File("readme.txt"));
		System.out.println(Arrays.toString("/henriqu/heh/easda/t.txt".split("/")));
		
		System.out.println(f.accessObject("/users"));
	}

}
