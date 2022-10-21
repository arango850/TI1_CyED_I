package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.Laboratorio;
import model.Persona;
import structures.Queue;

public class Main {

	private static Scanner scanner;
	private static Laboratorio laboratorio;
	private static Persona persona;
	
	public Main() {
		scanner = new Scanner(System.in);
		laboratorio = new Laboratorio();
		persona = new Persona();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setMain(new Main());
		Main.menu();
	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido al administrador de laboratorio\n"
				+ "Seleccione una opcción\n"
				+ "(1) Continuar\n"
				+ "(0) Salir");
		String option = scanner.nextLine();
		int option1 = Integer.parseInt(option);
		switch(option1){
		case 1:
			sestructura();
		break;
		case 0:
			System.out.println("Goodbye");
			System.exit(0);
		break;	
		}
	}
	
	
	
	private static void sestructura() {
		// TODO Auto-generated method stub
		System.out.println("Seleccione el tipo de estructura a usar\n"+
		"(1) Filas y Pilas\n"+
		"(2) Arbol binario");
		String option = scanner.nextLine();
		int option1 = Integer.parseInt(option);
		switch(option1) {
		case 1:
			menu2();
		break;
		case 2:
			menu3();
		break;	
		}
	}
	
	

	private static void menu3() {
		// TODO Auto-generated method stub
		System.out.println("Desea agregar los datos registrados anteriormente\n"+
				"(1) Sí\n"+
				"(0) No");
		String option = scanner.nextLine();
		int option1 = Integer.parseInt(option);
		switch(option1) {
		case 1:
			lecturaDatosB();
			lecturaDatosPrioritariosB();
			continuee2();
		break;
		case 0:
			continuee2();
		break;	
		}
	}
	
	private static void continuee2() {
		// TODO Auto-generated method stub
		System.out.println("¿Qué acción desea hacer?\n"+
				"(1) Registrar una nuevo paciente\n"+
				"(2) Eliminar un paciente\n"+
				"(3) Buscar un paciente\n"+
				"(0) Salir");
				String option = scanner.nextLine();
				int option1  =Integer.parseInt(option);
				switch(option1) {
				case 1:
					agregarPacienteB();
				break;
				case 2:
					eliminarPacienteB();
				break;
				case 3:
					buscarPacienteB();
				break;
				case 0:
					menu();
				}
	}

	private static void buscarPacienteB() {
		// TODO Auto-generated method stub
		System.out.println("Digita el id del paciente");
		String name= scanner.nextLine();
		persona = laboratorio.searchTrigger(name);
		if(persona==null) {
			System.out.println("El paciente no existe");
		}else {
			System.out.println(persona.getNombre());
			System.out.println(persona.getEdad());
			System.out.println(persona.getEnfermedad());
			System.out.println(persona.getId());
		}
		continuee2();
	}

	private static void eliminarPacienteB() {
		// TODO Auto-generated method stub
		System.out.println("Digite el id");
		String name= scanner.nextLine();
		laboratorio.triggerDelete(name);
		System.out.println("Ha sido eliminado");
		continuee2();
	}

	private static void agregarPacienteB() {
		// TODO Auto-generated method stub
		System.out.println("Digite el nombre del paciente");
		String nombre = scanner.nextLine();
		System.out.println("Digite la edad del paciente");
		String edad = scanner.nextLine();
		System.out.println("Digite la enfermedad del paciente, en caso de presentar una enfermedad de base, digite (No)");
		String enfermedad = scanner.nextLine();
		System.out.println("Digite la identificación");
		String id = scanner.nextLine();
		int edadInt = Integer.parseInt(edad);
		if(edadInt > 70) {
			laboratorio.agregarPacientePrioritarioB(nombre,edad,enfermedad,id);
			continuee2();
			System.out.println("El paciente fue ingresado como prioritario por la edad");
		} else if(enfermedad.equalsIgnoreCase("Diabetes")|| enfermedad.equalsIgnoreCase("Cancer") || enfermedad.equalsIgnoreCase("Hipertensión") || enfermedad.equalsIgnoreCase("Asma")|| enfermedad.equalsIgnoreCase("EPOC")) {
			laboratorio.agregarPacientePrioritarioB(nombre,edad,enfermedad,id);
			continuee2();
		}else {
			laboratorio.agregarPacienteB(nombre, edad, enfermedad,id);
			continuee2();
		}
	}

	private static void lecturaDatosPrioritariosB() {
		// TODO Auto-generated method stub
		try {
			File doc = new File("src\\\\listP.txt");
			BufferedReader obj = new BufferedReader(new FileReader(doc));
			String strng;
			String e1 = null;
			while ((strng = obj.readLine())!=null) {
				 e1 = strng;
			}System.out.println(e1);
			ArrayList<String> division = new ArrayList<String>(Arrays.asList(e1.split(" ")));
			for(int i = 0; i<division.size(); i+=4){
				laboratorio.agregarPacienteCargaBP(division.get(i),division.get(i+1),division.get(i+2),division.get(i+3));
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static void lecturaDatosB() {
		// TODO Auto-generated method stub
		try {
			File doc = new File("src\\test.txt");
			BufferedReader obj = new BufferedReader(new FileReader(doc));
			String strng;
			String e1 = null;
			while ((strng = obj.readLine())!=null) {
				 e1 = strng;
			}System.out.println(e1);
			ArrayList<String> division = new ArrayList<String>(Arrays.asList(e1.split(" ")));
			for(int i = 0; i<division.size(); i+=4){
				laboratorio.agregarPacienteCargaB(division.get(i),division.get(i+1),division.get(i+2),division.get(i+3));
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

	private static void menu2() {
		// TODO Auto-generated method stub
		System.out.println("Desea agregar los datos registrados anteriormente\n"+
		"(1) Sí\n"+
		"(0) No");
		String option = scanner.nextLine();
		int option1 = Integer.parseInt(option);
		switch(option1) {
		case 1:
			lecturaDatos();
			lecturaDatosPrioritarios();
			continuee();
		break;
		case 0:
			continuee();
		break;	
		}
	}

	private static void lecturaDatosPrioritarios() {
		// TODO Auto-generated method stub
		try {
			File doc = new File("src\\listP.txt");
			BufferedReader obj = new BufferedReader(new FileReader(doc));
			String strng;
			String e1 = null;
			while ((strng = obj.readLine())!=null) {
				 e1 = strng;
			}System.out.println(e1);
			ArrayList<String> division = new ArrayList<String>(Arrays.asList(e1.split(" ")));
			for(int i = 0; i<division.size(); i+=4){
				laboratorio.agregarPacienteCargaP(division.get(i),division.get(i+1),division.get(i+2),division.get(i+3));
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static void lecturaDatos()  {
		// TODO Auto-generated method stub
		try {
		File doc = new File("src\\test.txt");
		BufferedReader obj = new BufferedReader(new FileReader(doc));
		String strng;
		String e1 = null;
		while ((strng = obj.readLine())!=null) {
			 e1 = strng;
		}System.out.println(e1);
		ArrayList<String> division = new ArrayList<String>(Arrays.asList(e1.split(" ")));
		for(int i = 0; i<division.size(); i+=4){
			laboratorio.agregarPacienteCarga(division.get(i),division.get(i+1),division.get(i+2),division.get(i+3));
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	private static void continuee() {
		// TODO Auto-generated method stub
		System.out.println("¿Qué acción desea hacer?\n"+
		"(1) Registrar una nuevo paciente\n"+
		"(2) Buscar un paciente\n"+
		"(0) Salir");
		String option = scanner.nextLine();
		int option1  =Integer.parseInt(option);
		switch(option1) {
		case 1:
			agregarPaciente();
		break;
		case 3: 
			eliminarPaciente();
		break;
		case 2:
			buscarPaciente();
		break;
		case 0:
			menu();
		break;	
		}
	}

	private static void buscarPaciente() {
		// TODO Auto-generated method stub
		System.out.println("¿El paciente fue ingresado como prioritario\n"+
		"(1) Sí\n"+
		"(0) No");
		String option = scanner.nextLine();
		int option1 = Integer.parseInt(option);
		switch(option1) {
		case 1:
			buscarPrioritario();
		break;
		case 0:
			buscarGeneral();
		break;	
		}
		
	}

	private static void buscarGeneral() {
		// TODO Auto-generated method stub
		System.out.println("Digite el id del paciente buscado");
		String busca = scanner.nextLine();
		Persona per = laboratorio.buscar(busca);
		System.out.println(per.getNombre());
		System.out.println(per.getEdad());
		System.out.println(per.getEnfermedad());
		System.out.println(per.getId());
		continuee();
	}

	private static void buscarPrioritario() {
		// TODO Auto-generated method stub
		System.out.println("Digite el id del paciente buscado");
		String busca = scanner.nextLine();
		Persona per = laboratorio.buscarP(busca);
		System.out.println(per.getNombre());
		System.out.println(per.getEdad());
		System.out.println(per.getEnfermedad());
		System.out.println(per.getId());
		continuee();
	}

	private static void eliminarPaciente() {
		// TODO Auto-generated method stub
		System.out.println("Opccion eliminar");
		continuee();
	}

	private static void agregarPaciente() {
		// TODO Auto-generated method stub
		System.out.println("Digite el nombre del paciente");
		String nombre = scanner.nextLine();
		System.out.println("Digite la edad del paciente");
		String edad = scanner.nextLine();
		System.out.println("Digite la enfermedad del paciente,en caso de presentar una enfermedad de base, digite (No)");
		String enfermedad = scanner.nextLine();
		System.out.println("Digite la identificación");
		String id = scanner.nextLine();
		int edadInt = Integer.parseInt(edad);
		if(edadInt > 70) {
			laboratorio.agregarPacientePrioritario(nombre,edad,enfermedad,id);
			System.out.println("El paciente fue ingresado como prioritario por la edad");
			continuee();
			
		} else if(enfermedad.equalsIgnoreCase("Diabetes")|| enfermedad.equalsIgnoreCase("Cancer") || enfermedad.equalsIgnoreCase("Hipertensión") || enfermedad.equalsIgnoreCase("Asma")|| enfermedad.equalsIgnoreCase("EPOC")) {
			laboratorio.agregarPacientePrioritario(nombre,edad,enfermedad,id);
			System.out.println("El paciente fue ingresado como prioritario por la enfermedad de base que padece");
			continuee();
		}else {
			laboratorio.agregarPaciente(nombre, edad, enfermedad,id);
			System.out.println("El paciente fue ingresado como general");
			continuee();
		}
			
		
		
	}

	
	
	
	
	private static void setMain(Main main) {
		// TODO Auto-generated method stub
		
	}

}
