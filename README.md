Para cargar el programa primero se debe tener instalado JAVA y JAVA FX junto con Apache MAVEN.

Primero hay que ir a la carpeta raíz del programa y abrir un powershell, luego hay que ejecutar los comandos:
1. $env:JAVA_HOME = "C:\Users\Judarelo\.jdks\openjdk-26.0.2"
2. mvn javafx:run

Luego de eso se ejecuta el programa y se inicia la interfaz:
1. Dar click en solicitar saludo
2. Ingresar nombre, edad y si la hora es PM o AM
3. El sistema te saludara y dara espacio a un botón para volver a solicitar el saludo
