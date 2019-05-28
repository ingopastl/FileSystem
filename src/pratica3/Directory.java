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

	public Directory newDirectory(String name) {
		Directory d = new Directory(name, this);
		references.add(d);
		return d;
	}
	
	public File newFile(String name) {
		File f = new File(name, this);
		references.add(f);
		return f;
	}
}
