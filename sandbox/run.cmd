REM Before you run this script, you should do "mvn clean install"
REM in this directory. You need to have Maven 3.3+ and JDK 8+ installed
REM on your machine.

java -cp "target/classes;target/eo-runtime.jar" org.eolang.phi.Main sandbox.app %*
pause
