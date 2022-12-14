package model;

import exceptions.PersonaRepetidaException;

public class Persona {

	
	
	private String nombre;
	private String edad;
	private String enfermedad;
	private String id;
	
	private Persona derecha;
	private Persona izquierda;
	
	public Persona( String nombre, String edad, String enfermedad,String id) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.enfermedad = enfermedad;
		this.id=id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void insert(String nombre, String edad, String enfermedad, String id) {
		// TODO Auto-generated method stub
		if(id.compareTo(this.id)<0) {
			if(this.izquierda==null) {
				this.izquierda= new Persona(nombre, edad, enfermedad, id);
			
			}else {
				this.izquierda.insert(nombre, edad, enfermedad, id);
			}
		}else if(id.compareTo(this.id)>0) {
			if(this.derecha==null) {
				this.derecha= new Persona(nombre, edad, enfermedad, id);
				
				
			}else {
				this.derecha.insert(nombre,edad,enfermedad, id);
			}
		}else {
			throw new PersonaRepetidaException(id);
		}
	}

	
	
	
	
	
}
