@ECHO OFF
cls
javac *.java
start rmiregistry
@cmd /k "java Server"
