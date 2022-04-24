@ECHO OFF
cls
javac *.java
start rmiregistry
@cmd /k "java RMIServer"