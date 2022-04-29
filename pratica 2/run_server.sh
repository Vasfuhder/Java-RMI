#!/bin/sh
clear
killall -9 rmiregistry
javac *.java
rmiregistry &
sleep 1s
java RMIServer
