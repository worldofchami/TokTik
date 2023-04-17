JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java

$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=Post.class Account.class BinaryTreeNode.class BinaryTree.class BTQueueNode.class BTQueue.class BinarySearchTree.class TokTik.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

run: $(CLASS_FILES)
	java -cp bin TokTik