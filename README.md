# Interpres
Interpres is a LISP that allows programmers to create their own language DSL, targeted at any platform. A programmer may for example decide to implemented an `if` and `while`function, that compile to the JVM.

To make this possible, Interpres programs output a sequence of assembly instructions. Consider the following example for an imaginary assembly language:

```clojure
; The language DSL. Defines + and print-int
(interpres/define @print-int (interpres/lambda (int)
  (interpres/list int (asm.call @"putint") (asm.call @"puteol"))))

(interpres/define @+ (lambda (first-integer second-integer)
  (interpres/list (asm.loadl first-integer) (asm.loadl second-integer) (asm.call @"add"))))

(define @asm/loadl (lambda (literal) (interpres/string/conat @"LOADL " literal)))
(define @asm/call (lambda (address) (interpres/string/concat @"CALL " address)))

; An actual program, using the above definitions
(print-int (+ 1 2)) ; => ["LOADL 1", "LOADL 2", "CALL add", "CALL putint", "CALL puteol"]
```

Please head over to [interpres-imperative](https://github.com/thomasbrus/interpres-imperative) to get a more complete specific idea of what is possible.

## Features
* Defining functions and values using `define`
* Lambda functions with default arguments
* Lexical scope with `bind`
* Let-in expressions
* Backtrace with line numbers and filename
* Quoting and unquoting (*code as data*)
* [Builtin functions](https://github.com/thomasbrus/interpres/tree/master/src/main/java/interpres/language/definitions/interpres) to work with lists, symbols, strings, characters and integers
* Requiring of files relative to current file

## Usage instructions
Download the latest release from [thomasbrus/interpres/releases](https://github.com/thomasbrus/interpres/releases). Place the JAR in your classpath and execute the following command:

`java interpres.App my-dsl.interpres`

Seee [examples/language](examples/language) for a few examples. Some more interesting examples are available at [thomasbrus/interpres-imperative](https://github.com/thomasbrus/interpres/commits/master?page=3)

## Development
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
    $ mvn exec:java -Dexec.mainClass="interpres.App" my-program.interpres

An alternative way is using `mvn package`. This will not produce as much debugging output and it does not hang for a few seconds each time.

    $ mvn package
    $ java -classpath target/interpres-<version>.jar interpres.App my-program.interpres

## License

See [LICENSE.txt](LICENSE.txt).
