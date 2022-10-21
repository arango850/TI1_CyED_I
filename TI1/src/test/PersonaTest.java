package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Persona;

class PersonaTest {

	Persona persona = new Persona();
	@Test
	void test() {
		String nombre = "Andres";
		String edad = "19";
		String enfermedad= "No";
		String id = "123456789";
		
		persona = new Persona(nombre,edad,enfermedad,id);
		assertEquals("Andres",persona.getNombre());
		assertEquals("19",persona.getEdad());
		assertEquals("No",persona.getEnfermedad());
		assertEquals("123456789",persona.getId());
	}

}
