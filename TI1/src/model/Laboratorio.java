package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


import structures.Queue;
import structures.Stack;

public class Laboratorio {

	private Persona persona;
	private Queue<Persona> queue;
	private Queue<Persona> queueP;
	private Stack<Persona> stack;
	private Stack<Persona> stack2;
	
	private Persona personaRaiz;
	private int numPersonas;
	
	
	
	public Laboratorio() {
		queue = new Queue(100);
		queueP = new Queue(100);
		stack = new Stack(100);
		stack2= new Stack(100);
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

	

	public void agregarPacienteCargaP(String string, String string2, String string3, String string4) {
		// TODO Auto-generated method stub
		persona = new Persona(string, string2, string3,string4);
		queueP.add(persona);
		
	}

	public void agregarPacienteCargaB(String string, String string2, String string3, String string4) {
		// TODO Auto-generated method stub
		if(personaRaiz==null) {
			personaRaiz= new Persona(string, string2, string3, string4);
			numPersonas++;
		}else {
			personaRaiz.insert(string, string2, string3, string4);
			numPersonas++;
		}
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public void agregarPacienteCargaBP(String string, String string2, String string3, String string4) {
		// TODO Auto-generated method stub
		if(personaRaiz==null) {
			personaRaiz= new Persona(string, string2, string3, string4);
			numPersonas++;
		}else {
			personaRaiz.insert(string, string2, string3, string4);
			numPersonas++;
		}
	}

	public void agregarPacientePrioritarioB(String nombre, String edad, String enfermedad, String id) {
		// TODO Auto-generated method stub
		if(personaRaiz==null) {
			personaRaiz= new Persona(nombre, edad, enfermedad, id);
			numPersonas++;
			crearBaseP(nombre, edad, enfermedad, id);
		}else {
			personaRaiz.insert(nombre, edad, enfermedad, id);
			numPersonas++;
			crearBaseP(nombre, edad, enfermedad, id);
		}
	}

	public void agregarPacienteB(String nombre, String edad, String enfermedad, String id) {
		// TODO Auto-generated method stub
		if(personaRaiz==null) {
			personaRaiz= new Persona(nombre, edad, enfermedad, id);
			numPersonas++;
			crearBase(nombre, edad, enfermedad, id);
		}else {
			personaRaiz.insert(nombre, edad, enfermedad, id);
			numPersonas++;
			crearBase(nombre, edad, enfermedad, id);
		}	
	}

	public Persona searchTrigger(String name) {
		// TODO Auto-generated method stub
		return search(personaRaiz, name);
	}

	private Persona search(Persona node, String name) {
		// TODO Auto-generated method stub
		if(node==null) {
			return null;
		}
		if(name.equals(node.getId())) {
			return node;
			
		}
		
		if(name.compareTo(node.getId())<0) {
			return search(node.getIzquierda(), name);
		}else {
			return search(node.getDerecha(), name);
		}
	}

	public void triggerDelete(String name) {
		// TODO Auto-generated method stub
		if (personaRaiz != null){
			personaRaiz = delete(personaRaiz, name);
		}
	}

	private Persona delete(Persona current, String name) {
		// TODO Auto-generated method stub
		if (current.getId().equals(name)){
			if (current.getIzquierda() == null && 
					current.getDerecha() == null){
				return null;
			} else if (current.getIzquierda() != null && 
					current.getDerecha() != null) {
				Persona succesor = getMin(current.getDerecha());
				Persona newRightTree = delete(current.getDerecha(), succesor.getId());
				
				succesor.setIzquierda(current.getIzquierda());
				succesor.setDerecha(newRightTree);
				
				return succesor;
			} else if (current.getIzquierda() != null) {
				return current.getIzquierda();
			} else {
				return current.getDerecha();
			}
			
		} else if (name.compareTo(current.getId())<0){
			Persona newLeftTree = delete(current.getIzquierda(), name);
			current.setIzquierda(newLeftTree);
		} else {
			Persona newRightTree = delete(current.getDerecha(), name);
			current.setDerecha(newRightTree);
		}
		
		return current;
	}

	public Persona getMin(Persona current){
		if (current.getIzquierda() == null) {
			return current;
		} else {
			return getMin(current.getIzquierda());
		}
	}
	
	public Persona buscar(String id) {
		Persona aux = null;	
		for(int i =0; i< queue.getSize(); i++) {
				if(queue.peek().getId().equals(id)) {
					aux = queue.peek();
				}else{
					if(queue.getLast()==0) {
						break;
					}else {
						stack.push(queue.peek());
						queue.pool();
					}
					
				}	
		}	
	return aux;
			}

	public Persona buscarP(String busca) {
		// TODO Auto-generated method stub
		Persona aux = null;	
		for(int i =0; i< queueP.getSize(); i++) {
				if(queueP.peek().getId().equals(busca)) {
					aux = queueP.peek();
				}else{
					if(queueP.getLast()==0) {
						break;
					}else {
						stack.push(queueP.peek());
						queueP.pool();
					}
					
				}	
		}	
	return aux;
	}
		
}
