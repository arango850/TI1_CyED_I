package exceptions;

public class isFullExceptionStack extends RuntimeException {

	public isFullExceptionStack() {
		super("El stqack está lleno");
	}
}