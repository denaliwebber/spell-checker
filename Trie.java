//prefix tree implementing Trees interface
public class Trie implements Trees
{
	/* Node that stores an array of children representing 26 letters of 
	the alphabet and the apostrophe symbol, and a flag to check if this Node is
	the end of a word */
	private class Node
	{
		private Node [] children = new Node[27];
		boolean isEndOfWord;

		public Node()
		{
			isEndOfWord=false;

			for (int i = 0; i < 27; i++)
				children[i] = null;
		}
	}

	private Node root = new Node();

	public void insert(String item)
	{
		int i;
		int length = item.length();
		int index;
		int upperOrLower;
		Node curr = root;

		//loops through each letter in given item
		for (i = 0; i < length; i++)
		{
			index = getIndex(item.charAt(i));
            //if there isn't already a Node at that letter index, create one
			if (curr.children[index] == null)
				curr.children[index] = new Node();

			//update curr to the node residing at the given character index
			curr = curr.children[index];
		}

		curr.isEndOfWord = true;
	}

	public String find(String item)
	{
		//suggestion will be the word returned if item is not found
		StringBuilder suggestion = new StringBuilder();
		int i;
		int length = item.length();
		int index;
		Node prev = null;
		Node curr = root;

		//loop through each character of item
		for(i=0; i < length; i++)
		{
			index = getIndex(item.charAt(i));

			/* if there is no Node at calculated index, then word is not found
			return suggestion if it is a word, else find a suitable word to return*/
            if (curr.children[index] == null)
            {
            	if (curr.isEndOfWord)
            		return suggestion.toString();
            	else
            		return findWord(curr, suggestion);
            }

            appendChar(suggestion, index);

            //update curr to the node residing at the given character index
            curr = curr.children[index];
		}

		//if curr isn't null and is the end of a word then item found, and return it!
		if (curr != null && curr.isEndOfWord)
			return item;
		//else return a suggestion
		return findWord(curr, suggestion);
	}

	private String findWord(Node curr, StringBuilder suggestion)
	{
		boolean isWord = false;
		int index;

		//repeat loop until a valid word is found
		while(!isWord)
		{
			index = getChild(curr);
			appendChar(suggestion, index);
			//update curr to the node residing at the given character index
			curr = curr.children[index];
			isWord = curr.isEndOfWord;
		}

		//return suggestion which is now a valid word from english.0
		return suggestion.toString();
	}

	//getChild returns a valid index of a char to append to the suggestion
	private int getChild(Node curr)
	{
		//loops through curr's children until it finds one that isn't null
		for (int i=0; i<27; i++)
		{
			if (curr.children[i]!=null)
				return i;
		}
		return -1;
	}

	private int getIndex(char c)
	{
		int index;
		//calculates index for the character based on ascii table
		index = c - 'a';

		//if index=-58, then character is an apostrophe so override with correct index
		if (index == -58)
            index = 26;

        return index;
	}

	private void appendChar(StringBuilder suggestion, int index)
	{
		//if index is an apostrophe append an apostrophe which is ascii 39 type casted as a char
        if (index == 26)
           	suggestion.append((char)39);

        /*append the index plus ascii value 97 type casted as a char to get
        each valid character of the item */
        else
           	suggestion.append((char)(index+97));
	}
}