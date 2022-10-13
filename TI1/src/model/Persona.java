package model;

public class Persona {

	private int turno;
	
	private String nombre;
	private String edad;
	private String enfermedad;
	
	public Persona(int turno, String nombre, String edad, String enfermedad) {
		super();
		this.turno = turno;
		this.nombre = nombre;
		this.edad = edad;
		this.enfermedad = enfermedad;
	}
	
	public Persona() {
		
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	
	
	
	
}
