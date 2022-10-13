package main;

import java.util.Scanner;

import model.Persona;
import structures.Queue;

public class Main {

	private static Scanner scanner;
	private static Persona persona;
	
	public Main() {
		scanner = new Scanner(System.in);
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
		System.out.println("Digite el nombre de la persona");
		String nombre = scanner.nextLine();	
		String nombre1 = scanner.nextLine();
		System.out.println("Digite la edad de la persona");
		String edad = scanner.nextLine();
		System.out.println("Digite la enfermedad");
		String enfermedad= scanner.nextLine();
		persona = new Persona(0,nombre1,edad,enfermedad);
		Queue<Persona> stack = new Queue(1);
		stack.add(persona);
		System.out.println(stack.peek().getNombre());
	}

	private static void setMain(Main main) {
		// TODO Auto-generated method stub
		
	}

}
