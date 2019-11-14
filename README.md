Program: Spell-Checker using tree data structures trie and binary search tree.
Programmer: Denali Webber

Directory can include a configuration file to specify which data structure to implement, otherwise default is trie. Include an input file with words to be spell checked which will write out to an output file with the suggested or original word.

How to compile: javac CS245A1.java
How to run: java CS245A1 input.txt output.txt

Completed extra credit:
Reads english.0 directly from GitHub

Efficiency analysis: Trie is faster and more efficient than the tree data structure. The running time for trie is O(m), where m is the length of the word being searched for or inserted; however, the running time for the tree data structure is O(n). This is because as you move down the prefix tree you are checking each letter (worst case the length of the word) until the word is inserted or found (or not found and a suggestion is returned), but for the tree data structure finding or inserting the word is dependent on the size of the data set, in worst case you are inserting or finding the word (or returning a suggestion) at the end of the data set which would take n time.
