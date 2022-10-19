package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import structures.Queue;

public class Laboratorio {

	private Persona persona;
	private Queue queue;
	private Queue queueP;
	
	
	public Laboratorio() {
		queue = new Queue(100);
		queueP = new Queue(100);
	}

	public void agregarPaciente(String nombre, String edad, String enfermedad) {
		// TODO Auto-generated method stub
			persona = new Persona(nombre, edad, enfermedad);
			queue.add(persona);
			crearBase(persona.getNombre(),persona.getEdad(),persona.getEnfermedad());
			System.out.println(queue.toString());
	}

	public void agregarPacientePrioritario(String nombre, String edad, String enfermedad) {
		// TODO Auto-generated method stub
		persona = new Persona(nombre, edad, enfermedad);
		queueP.add(persona);
	}
	
	public void crearBase(String nombre, String edad, String enfermadad) {
		try {
		File file = new File("src\\test.txt");
		String output = nombre + " "+ edad+ " "+ enfermadad+ " ";
		
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(output);
		bw.close();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	public void agregarPacienteCarga(String nombre, String edad, String enfermedad) {
		// TODO Auto-generated method stub
		persona = new Persona(nombre, edad, enfermedad);
		queueP.add(persona);
		System.out.println(queue.toString());
	}
		
}
	
	
	
	
	

