#!/bin/bash
#Pre: Debe ejecutarse en la carpeta "src"
#Pre: Solamente es valido para clases que contengan la funcion "main"

javac -g $1.java && java $1
