package pratica3;

import java.util.Arrays;
import java.util.Scanner;

public class Execute {

	public static void main(String[] args) {
		FileManager f = new FileManager();
	
		f.runCommand("mkdir users");
//		f.runCommand("mkdir /users/newdir");
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print("(" + f.getPwd().name + ")˜input command: ");
			String comm = s.nextLine();
			try {
				f.runCommand(comm);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
	}

}
