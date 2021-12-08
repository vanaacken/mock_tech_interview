JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		config.java \
		infection.java \
		pandemic.java \
		printGrid.java 

default: classes

classes: $(CLASSES:.java=.class)

run: default
		java pandemic 30 100 2 3 "[<4,7>,<4,8>,<5,8>,<6,8>,<1,1>,<1,2>,<1,3>,<2,1>,<2,2>,<4,3>,<3,3>,<7,8>]"

clean:
		$(RM) *.class

re: clean default