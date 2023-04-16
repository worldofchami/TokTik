JCOMP=javac

.SUFFIXES: .java .class

.java.class:
	$(JCOMP) $.java

CLASSES=\
	Account.java\
	Post.java\
	TokTik.java

default: classes

classes: $(CLASSES:.java=./bin/.class)

clean:
	$(rm) ./bin/*.class