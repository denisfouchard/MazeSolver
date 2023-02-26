##########################################
#
#  Denis Fouchard - Télécom Paris - 2022
#  INF103 - Programmation Objet
#
##########################################

#
# Nom du programme 
#
PROG = Main
EXEC = ../MazeSolver

#
# Fichiers sources .java
#

SOURCES = $(shell find . -name "*.java")

#
# Compilateur Java
#
JC = javac

#
# Options du compilateur Java
#
JFLAGS = -g -d

RM = rm


##########################################
#
# Regles de construction/destruction des .class et de l'executable
#
 
all: 
	$(JC) $(JFLAGS) . $(SOURCES)
	jar cvfm $(EXEC).jar manifest.mf */*.class
	clean


clean:
#remove all .class files in all subdirectories
	$(RM) -f */*.class
  
tar:
	tar cvf ${PROG}.tar.gz ${SOURCES}


###########################################
#
# Regles implicites
#

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java


