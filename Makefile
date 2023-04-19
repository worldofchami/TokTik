JAVAC=/usr/bin/javac
JAVA=/usr/bin/java

.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=BinaryTreeNode.class \
	BTQueueNode.class BTQueue.class BinaryTree.class \
	BinarySearchTree.class Post.class Account.class TokTik.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

run: $(CLASS_FILES)
	$(JAVA) -cp bin TokTik