#!/bin/bash

#Skripti kot prvi argument podate pot do vhodne datoteke.
#Ustvarila bo izhodno datoteko v direktoriju vhodne datoteke.

javac Seminar2.java
java Seminar2 "$1"

exit 0
