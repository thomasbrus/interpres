package interpres;

public class TypeMismatchException extends RuntimeException {
  /**
   * Constructs a new TypeMismatchException.
   *
   * @param message the message of this TypeMismatchException
   */
  public TypeMismatchException(String message) {
    super(message);
  }
}

