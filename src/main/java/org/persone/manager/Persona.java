package org.persone.manager;

public class Persona {

	private String name;
	private int eta;
	
	public Persona(String name, int eta) {
		
		setName(name);
		setEta(eta);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	@Override
	public String toString() {
		
		return getName() + ": " + getEta();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Persona))
			return false;
		
		Persona p = (Persona) obj;
		
		return getName().equals(p.getName())
				&& getEta() == p.getEta();
	}
}
