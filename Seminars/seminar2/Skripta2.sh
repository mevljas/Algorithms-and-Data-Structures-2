#!/bin/bash

#Skripti kot prvi argument podate pot do direktorija, ki vsebuje vhodne datoteke.
#Skripta bo za vsako vhodno datoteko ustvarila izhodno datoteko v podanem direktoriju.

javac Seminar2.java

for file in "$1"/*.IN; do
    java Seminar2 "$file"
done

exit 0
