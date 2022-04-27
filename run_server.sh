#!/bin/sh
clear
killall -9 rmiregistry
javac *.java
rmiregistry &
java RMIServer
