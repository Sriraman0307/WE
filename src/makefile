JFLAGS = -g
JC = javac
JVM = java
src = src/
cls = ../bin/

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) *.java -d $(cls)

CLASSES = \
		trajectories.java
		Dynamics.java
		weightedEnsemble.java\
		simulation.java

MAIN = simulation
		 
default: classes

classes: $(CLASSES:.java=.class)
		
run: $(MAIN).class 
	cd $(cls); $(JVM) $(MAIN)

clean:
	$(RM) $(cls)*.class