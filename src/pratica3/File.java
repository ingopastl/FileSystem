package pratica3;

public class File extends SystemObject{
	private String name;

	public File(String name) {
		super();
		this.name = name;
	}
	
	public File(String name, Directory parent) {
		super();
		this.name = name;
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
