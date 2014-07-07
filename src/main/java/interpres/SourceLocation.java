package interpres;

public class SourceLocation {
  private String fileName;
  private int lineNumber;

  public static SourceLocation UNKNOWN_SOURCE = new SourceLocation(null, -1);
  public static SourceLocation NATIVE_METHOD = new SourceLocation(null, -2);

  /**
   * Constructs a new SourceLocation.
   *
   * @param fileName the fil ename of this SourceLocation
   * @param lineNumber the line number of this SourceLocation
   */
  public SourceLocation(String fileName, int lineNumber) {
    this.fileName = fileName;
    this.lineNumber = lineNumber;
  }

  /** 
   * Returns the file name property of this SourceLocation object.
   *
   * @return file name property of this object
   */
  public String getFileName() {
    return this.fileName;
  }

  /** 
   * Returns the line number property of this SourceLocation object.
   *
   * @return line number property of this object
   */
  public int getLineNumber() {
    return this.lineNumber;
  }
}

