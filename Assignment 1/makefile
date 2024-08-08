# Makefile for Flex, Bison, and GCC

# Compiler and flags
CC = gcc
FLEX = flex
BISON = bison

# Directories
FLEX_LIB_DIR = /opt/homebrew/opt/flex/lib

# Target: Default target
all: a.out

# Target: Build example6
a.out: y.tab.c lex.yy.c
	$(CC) y.tab.c lex.yy.c -L$(FLEX_LIB_DIR) -lfl

# Target: Generate example6.tab.c and lex.yy.c from the specified files
y.tab.c: $(y)
	$(BISON) -o y.tab.c -d $(y)

lex.yy.c: $(l)
	$(FLEX) $(l)

# Target: Run the example6
run: a.out
	./a.out

# Target: Clean generated files
clean:
	rm -f y.tab.c y.tab.h lex.yy.c a.out

.PHONY: all run clean
