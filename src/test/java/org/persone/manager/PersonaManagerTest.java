package org.persone.manager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonaManagerTest {

	private PersonaManager pm;
	
	@BeforeEach
	void init() {
		
		pm = new PersonaManager();
		
		Persona p1 = new Persona("Giorgio", 25);
		Persona p2 = new Persona("Chiara", 12);
		Persona p3 = new Persona("Flavio", 55);
		Persona p4 = new Persona("Flavio", 78);
		
		pm.addPersona(p1);
		pm.addPersona(p2);
		pm.addPersona(p3);
		pm.addPersona(p4);
	}
	
	@Test
	@DisplayName("Testo l'inserimento di una persona senza errori")
	void insertTest() {
		
		Persona p = new Persona("Francesca", 150);
		
		assertDoesNotThrow(() -> pm.addPersona(p));
	}
	
	@Test
	@DisplayName("Test la ricerca di persone dato il nome")
	void searchForPersonaByName() {
		
		String name1 = "giorgio";
		String name2 = "FLAVIO";
		
		List<Persona> personeName1 = Arrays.asList(new Persona[] {
			new Persona("Giorgio", 25)
		});
		List<Persona> personeName2 = Arrays.asList(new Persona[] {
				new Persona("Flavio", 78),
			new Persona("Flavio", 55)
			
		});
		
		List<Persona> searchName1 = pm.findPersoneByName(name1);
		List<Persona> searchName2 = pm.findPersoneByName(name2);
		
		assertIterableEquals(personeName1, searchName1);
		assertIterableEquals(personeName2, searchName2);
	}
	
	@Test
	@DisplayName("Testo l'inserimento di una persona con nome non validi")
	void insertIllegalNamePersona() {
		
		Persona p1 = new Persona("", 10);
		Persona p2 = new Persona("   ", 10);
		Persona p3 = new Persona("\n", 10);
		
		assertThrows(
			IllegalArgumentException.class,
			() -> pm.addPersona(p1)
		);
		assertThrows(
			IllegalArgumentException.class,
			() -> pm.addPersona(p2)
		);
		assertThrows(
			IllegalArgumentException.class,
			() -> pm.addPersona(p3)
		);
	}
	
	@Test
	@DisplayName("Testo l'inserimento di una persona con eta non valide")
	void insertIllegalEtaPersona() {
		
		Persona p1 = new Persona("Piero", -1);
		Persona p2 = new Persona("Piero", -10);
		Persona p3 = new Persona("Piero", -555);
		
		assertThrows(
			IllegalArgumentException.class,
			() -> pm.addPersona(p1)
		);
		assertThrows(
			IllegalArgumentException.class,
			() -> pm.addPersona(p2)
		);
		assertThrows(
			IllegalArgumentException.class,
			() -> pm.addPersona(p3)
		);
	}
}
