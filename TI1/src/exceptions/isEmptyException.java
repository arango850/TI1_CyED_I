package exceptions;

public class isEmptyException extends RuntimeException {

	public isEmptyException() {
		super("La fila est� vac�a");
	}
}