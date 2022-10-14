package main;

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
				+ "Seleccione una opcción\n"
				+ "(1) Continuar\n"
				+ "(0) Salir\n");
		int option = scanner.nextInt();
		switch(option){
		case 1:
			continuee();
		break;
		case 0:
			System.out.println("Goodbye");
			System.exit(0);
		break;	
		}
	}

	private static void continuee() {
		// TODO Auto-generated method stub
		System.out.println("¿Qué acción desea hacer?\n"+
		"(1) Registrar una nuevo paciente\n"+
		"(2) Eliminar un paciente\n"+
		"(3) Buscar un paciente\n"+
		"(0) Salir\n");
		int option = scanner.nextInt();
		switch(option) {
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
		System.out.println("Opccion buscar");
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
		
		laboratorio.agregarPaciente(nombre,edad,enfermedad);
		continuee();
	}

	private static void setMain(Main main) {
		// TODO Auto-generated method stub
		
	}

}
