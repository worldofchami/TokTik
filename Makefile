JCOMP=javac

.SUFFIXES: ./src/.java ./bin/.class

.java.class:
	$(JCOMP) ./src/$.java

CLASSES=\
	./bin/Account.class\
	./bin/Post.class\
	./bin/TokTik.class

default: classes

classes: $(CLASSES:.java=./bin/.class)

clean:
	$(rm) ./bin/*.class