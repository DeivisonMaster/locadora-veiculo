package jpql;

public class ServidorIndisponivelException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ServidorIndisponivelException(String msg, Throwable causa) {
		super(msg, causa);
	}
	
	public ServidorIndisponivelException(String msg) {
		super(msg);
	}
}
