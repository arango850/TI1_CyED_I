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

	public void agregarPaciente(String nombre, String edad, String enfermedad,String id) {
		// TODO Auto-generated method stub
			persona = new Persona(nombre, edad, enfermedad,id);
			queue.add(persona);
			crearBase(persona.getNombre(),persona.getEdad(),persona.getEnfermedad(),persona.getId());
			System.out.println(queue.toString());
	}

	public void agregarPacientePrioritario(String nombre, String edad, String enfermedad,String id) {
		// TODO Auto-generated method stub
		persona = new Persona(nombre, edad, enfermedad,id);
		queueP.add(persona);
		crearBaseP(persona.getNombre(),persona.getEdad(),persona.getEnfermedad(),persona.getId());
		System.out.println(queueP.toString());
	}
	
	private void crearBaseP(String nombre, String edad, String enfermedad, String id) {
		// TODO Auto-generated method stub
		try {
			File file = new File("src\\listP.txt");
			String output = nombre + " "+ edad+ " "+ enfermedad+ " "+id+" ";
			if(!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(output);
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void crearBase(String nombre, String edad, String enfermadad,String id) {
		try {
		File file = new File("src\\test.txt");
		String output = nombre + " "+ edad+ " "+ enfermadad+ " "+id+" ";
		
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

	public void agregarPacienteCarga(String nombre, String edad, String enfermedad,String id) {
		// TODO Auto-generated method stub
		persona = new Persona(nombre, edad, enfermedad,id);
		queue.add(persona);
		
	}

	
		
}
	
	
	
	
	

