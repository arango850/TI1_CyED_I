package exceptions;

public class isFullExecption extends RuntimeException {

	public isFullExecption() {
		super("La fila está llena");
	}
}