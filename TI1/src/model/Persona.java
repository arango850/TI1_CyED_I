package model;

public class Persona {

	
	
	private String nombre;
	private String edad;
	private String enfermedad;
	
	private Persona derecha;
	private Persona izquierda;
	
	public Persona( String nombre, String edad, String enfermedad) {
		super();
		
		this.nombre = nombre;
		this.edad = edad;
		this.enfermedad = enfermedad;
	}
	
	public Persona() {
		
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

	public Persona getDerecha() {
		return derecha;
	}

	public void setDerecha(Persona derecha) {
		this.derecha = derecha;
	}

	public Persona getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Persona izquierda) {
		this.izquierda = izquierda;
	}

	
	
	
	
	
}
