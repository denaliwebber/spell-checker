public class Trie implements Trees
{
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
		int level;
		int length = item.length();
		int index;
		int upperOrLower;

		Node curr = root;

		for (level = 0; level < length; level++)
		{
			index = item.charAt(level) - 'a';
			if (index == -58)
                index = 26;
			if (curr.children[index] == null)
				curr.children[index] = new Node();
			curr = curr.children[index];
		}

		curr.isEndOfWord = true;
	}

	public String find(String item)
	{
		StringBuilder suggestion = new StringBuilder();
		int level;
		int length = item.length();
		int index;
		Node prev = null;
		Node curr = root;

		for(level=0; level < length; level++)
		{
			index = item.charAt(level)-'a';
			if (index == -58)
                index = 26;
            if (curr.children[index] == null)
            {
            	if (curr.isEndOfWord)
            		return suggestion.toString();
            	else
            		return findWord(curr, suggestion);
            }
            if((level==(length-1)) && curr.isEndOfWord)
            	return suggestion.toString();
            if (index == 26)
            	suggestion.append((char)39);
            else
            	suggestion.append((char)(index+97));
            curr = curr.children[index];
		}
		if (curr != null && curr.isEndOfWord)
			return item;
		return findWord(curr, suggestion);
	}

	private String findWord(Node curr, StringBuilder suggestion)
	{
		boolean isWord = false;
		int index;

		while(!isWord)
		{
			index = getChild(curr);
			if (index == 26)
                suggestion.append((char)39);
			else
            	suggestion.append((char)(index+97));
			curr = curr.children[index];
			isWord = curr.isEndOfWord;
		}
		return suggestion.toString();
	}
	//getChild returns index of char to append to suggestion
	private int getChild(Node curr)
	{
		for (int i=0; i<27; i++)
		{
			if (curr.children[i]!=null)
				return i;
		}
		return -1;
	}
}