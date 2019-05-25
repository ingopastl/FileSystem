package pratica3;

import java.util.ArrayList;
import java.util.List;

public class Directory extends SystemObject{
	
	private List<SystemObject> references;
	
	public Directory(String name) {
		super();
		this.name = name;
		references = new ArrayList<>();
	}
	
	public Directory(String name, Directory parent) {
		super();
		this.name = name;
		references = new ArrayList<>();
		this.parent = parent;
	}

	public List<SystemObject> getReferences() {
		return references;
	}
	
	public SystemObject getChild(String name) {
		SystemObject r = null;
		for (SystemObject systemObject : references) {
			if (systemObject.getName().equals(name)) {
				r = systemObject;
			}
		}
		return r;
	}

	public void newDirectory(String name) {
		references.add(new Directory(name, this));
	}
	
	public void newFile(String name) {
		references.add(new File(name, this));
	}
}
