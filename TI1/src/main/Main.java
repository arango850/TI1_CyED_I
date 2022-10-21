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
	
	public Main() {
		scanner = new Scanner(System.in);
		laboratorio = new Laboratorio();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setMain(new Main());
		Main.menu();
	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido al administrador de laboratorio\n"
				+ "Seleccione una opcci�n\n"
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
				"(1) S�\n"+
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
		System.out.println("�Qu� acci�n desea hacer?\n"+
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
				}
	}

	private static void buscarPacienteB() {
		// TODO Auto-generated method stub
		
	}

	private static void eliminarPacienteB() {
		// TODO Auto-generated method stub
		
	}

	private static void agregarPacienteB() {
		// TODO Auto-generated method stub
		System.out.println("Digite el nombre del paciente");
		String nombre = scanner.nextLine();
		System.out.println("Digite la edad del paciente");
		String edad = scanner.nextLine();
		System.out.println("Digite la enfermedad del paciente");
		String enfermedad = scanner.nextLine();
		System.out.println("Digite la identificaci�n");
		String id = scanner.nextLine();
		int edadInt = Integer.parseInt(edad);
		if(edadInt > 70) {
			laboratorio.agregarPacientePrioritarioB(nombre,edad,enfermedad,id);
			continuee2();
			System.out.println("El paciente fue ingresado como prioritario por la edad");
		} else if(enfermedad.equalsIgnoreCase("Diabetes")|| enfermedad.equalsIgnoreCase("Cancer") || enfermedad.equalsIgnoreCase("Hipertensi�n") || enfermedad.equalsIgnoreCase("Asma")|| enfermedad.equalsIgnoreCase("EPOC")) {
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
		"(1) S�\n"+
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
		System.out.println("�Qu� acci�n desea hacer?\n"+
		"(1) Registrar una nuevo paciente\n"+
		"(2) Eliminar un paciente\n"+
		"(3) Buscar un paciente\n"+
		"(0) Salir");
		String option = scanner.nextLine();
		int option1  =Integer.parseInt(option);
		switch(option1) {
		case 1:
			agregarPaciente();
		break;
		case 2: 
			eliminarPaciente();
		break;
		case 3:
			buscarPaciente();
		break;
		case 0:
			menu();
		break;	
		}
	}

	private static void buscarPaciente() {
		// TODO Auto-generated method stub
		System.out.println("Digite el id del paciente buscado");
		String busca = scanner.nextLine();
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
		System.out.println("Digite la enfermedad del paciente");
		String enfermedad = scanner.nextLine();
		System.out.println("Digite la identificaci�n");
		String id = scanner.nextLine();
		int edadInt = Integer.parseInt(edad);
		if(edadInt > 70) {
			laboratorio.agregarPacientePrioritario(nombre,edad,enfermedad,id);
			continuee();
			System.out.println("El paciente fue ingresado como prioritario por la edad");
		} else if(enfermedad.equalsIgnoreCase("Diabetes")|| enfermedad.equalsIgnoreCase("Cancer") || enfermedad.equalsIgnoreCase("Hipertensi�n") || enfermedad.equalsIgnoreCase("Asma")|| enfermedad.equalsIgnoreCase("EPOC")) {
			laboratorio.agregarPacientePrioritario(nombre,edad,enfermedad,id);
			continuee();
		}else {
			laboratorio.agregarPaciente(nombre, edad, enfermedad,id);
			continuee();
		}
			
		
		
	}

	
	
	
	
	private static void setMain(Main main) {
		// TODO Auto-generated method stub
		
	}

}
