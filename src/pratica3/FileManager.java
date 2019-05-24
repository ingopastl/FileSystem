package pratica3;

public class FileManager {
	
	public Directory root = new Directory("/");
	public SystemObject pwd = root;
	
	public String accessObject(String path) {
		String [] aux = path.split("/");
		SystemObject current = root;
		for (int i = 0; i < aux.length; i++) {
			if (aux[i].equals("")) {
				continue;
			}
			if (i < aux.length - 1 && current instanceof File) {
				System.err.println(aux[i] + " is not a directory");
				break;
			}
			current = ((Directory)current).getChild(aux[i]);
		}
		
		return current.toString();
	}
}
