package pratica3;

import java.util.Arrays;

public class SystemObject {

	protected String name;
	protected Directory parent = null;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String r = null;
		if (this instanceof Directory) {
			Directory aux = (Directory) this;
			r = "name: " + name + "\n" + Arrays.toString(aux.getReferences().toArray());
		} else if (this instanceof File) {
			File aux = (File) this;
			r = aux.getName();
		} else r = "";
		
		return r;
	}
	
	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public Directory getParent() {
		return parent;
	}

}
