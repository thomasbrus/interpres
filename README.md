# Interpres
Interpres is a LISP dialect that helps programmers write programs that **emit assembly
instructions for any platform**. This is accomplished by implementing every language feature in terms of a list
of assembly instructions. After an Interpres program is evaluated, its output can be run by the
interpreter of the target platform (JVM, LLVM, ...).

In order to not leave a programmer empty handed when getting started, a number of prelude
libraries targeted at different platforms are provided. These libraries implement a minimal set
of imperative programming constructs, such as `var`, `if`, `println`, as well as arithmetic
operations, and defining and invoking procedures.

## Example
The following example showcases a simple program in which two numbers are added together and
its resulted is printed to the screen. Even though this is an elementary example, much is
going on.

```clojure
; Standard library functions, for example defined in Prelude.TAM
(define asm.loadl (lambda [literal] ["LOADL " literal]))
(define asm.call (lambda [address] ["CALL " address]))

(define print-int (lambda [int] [int (asm.call "putint") (asm.call "puteol")]))
(define + (lambda [a b] [(asm.loadl a) (asm.loadl b) (asm.call "add")])) ;

; The actual program, which makes use of the Prelude targeted at TAM
(import Prelude.TAM)
(print-int (+ 1 2)) ; => ["LOADL 1", "LOADL 2", "CALL add", "CALL putint", "CALL puteol"]
```

First the meta-function `print-int` is defined. In order for this function to output the correct
set of assembly instructions, it will need to evaluate its first argument (`int`, which in turn
produces assembly instructions), and subsequently output the instructions which print an integer to
the screen. To accomplish this a helper function called `asm.call` is defined.

Next, another meta-function is defined, namely `+`. For the sake of the example, it is assumed
that both arguments are integer literals. Hence `asm.loadl x` is called. In Interpres, these
integers would have been replaced already at compile-time by their respective assembly instructions.

Finally, when the program is evaluated, the `print-int` instruction will produce a list of valid
assembly instructions. In this case, instructions for the
[Triangle virtual machine (TAM)](http://www.dcs.gla.ac.uk/~daw/books/PLPJ/software.html).
This specific program can be executed by using the TAM Interpreter.

## Advantages

- Freedom
  - Programs can be targeted at *any* platform without messing with the Interpres infrastructure.
  - Inherent extensibility of the language at meta level due to the LISP syntax.
- Power
  - Having a number of prelude libraries available allows the programmer to get started right away.
    By writing macros the language can be further extended and made even more powerful.
- Speed
  - Every language feature can be implemented in terms of low level assembly instructions.
  - Compiled programs take full advantage of the speed of its target platform.

## Building & Running
### Prerequisites
This project requires the following software to be installed:

  - [Maven](http://maven.apache.org)
  - JDK 1.8

To make sure that Maven uses the correct JDK version, alter the `JAVA_HOME` environment variable,
or place this in your `~/.mavenrc`:

    export JAVA_HOME=/Library/Java/JavaVirtualMachines/<jdk-version-1.8>/Contents/Home

Use `mvn --version` to verify that everything is setup correctly.

### Compilation
Using Maven, the project is compiled by issuing the `mvn compile` command. The project can
then be run by providing a programming written in Interpres and passing it to the main app:

    $ mvn compile
    $ mvn exec:java -Dexec.mainClass="interpres.App" < my-program.interpres

This command will produce a bunch of output, probably more than you'd hoped for. This can be
circumvented by first compiling the project into a JAR, and then running it using the regular `java`
command:

    $ mvn package
    $ java -classpath target/interpres-0.0.1.jar interpres.App < my-program.interpres

