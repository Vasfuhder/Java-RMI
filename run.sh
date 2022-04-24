#!/bin/sh
killall -9 rmiregistry
javac *.java
rmiregistry &
gnome-terminal --tab -- java HelloServer
