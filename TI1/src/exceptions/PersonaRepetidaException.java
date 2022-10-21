package exceptions;

public class PersonaRepetidaException extends RuntimeException{

	public PersonaRepetidaException(String id) {
		super("El paciente que intenta ingresar se encuentra repetido, el id es "+id);
	}
}