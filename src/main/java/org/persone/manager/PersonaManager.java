package org.persone.manager;

import java.util.ArrayList;
import java.util.List;

public class PersonaManager {

	private List<Persona> persone;
	
	public PersonaManager() {
		
		persone = new ArrayList<>();
	}
	
	public void addPersona(Persona p) {
		
		String name = p.getName();
		int eta = p.getEta();
		
		if (name.isBlank() || eta < 0) {
			
			throw new IllegalArgumentException(
				"Il nome non puo' essere vuoto, "
				+ "l'eta non puo' essere negativa"
			);
		}
		
		persone.add(p);
	}
	
	public List<Persona> findPersoneByName(String name) {
		
		name = name.toLowerCase();
		
		List<Persona> personeName = new ArrayList<>();
		for (Persona p : persone) {
			
			if (p.getName().toLowerCase().equals(name)) {
				
				personeName.add(p);
			}
		}
		
		return personeName;
	}
	
	@Override
	public String toString() {
		
		return "Persona Manager:\n" + persone;
	}
}
