JAVAC       := javac
JAVAFLAGS   :=
TARGETS     += ${patsubst %.java,  %.class, ${wildcard *.java}}

.SUFFIXES: .class .java

%.class: %.java
	${JAVAC} ${JAVAFLAGS} $<

.PHONY: build clean

build: ${TARGETS}

clean:
	${RM} ${TARGETS}
