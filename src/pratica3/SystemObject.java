package pratica3;

import java.util.Arrays;

public class SystemObject {

	protected String name;
	
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
			r = Arrays.toString(aux.getReferences().toArray());
		} else if (this instanceof File) {
			File aux = (File) this;
			r = aux.getName();
		} else r = "";
		
		return r;
	}
}
