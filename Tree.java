//BST implementation implementing the Trees interface
public class Tree implements Trees
{	
	//Node to store string and pointer to the left and right
	private class Node
	{
		protected String data;
		protected Node left;
		protected Node right;

		public Node(String item)
		{	
			data = item;
			left = null;
			right = null;
		}
	}

	private Node root = null;

	public void insert(String item)
	{
		root = insert(item, root);
	}

	private Node insert(String item, Node node)
	{
		if (node == null)
			node = new Node(item);
		
		else if (item.compareTo(node.data)<0)
		{
			node.left = insert(item, node.left);
		}

		else
		{
			node.right=insert(item, node.right);
		}

		return node;
	}

	public String find(String item)
	{
		return find(item, root);
	}

	private String find(String item, Node node)
	{
		//if leaf node, item not found, return this node as a suggestion
		if(node.left==null && node.right==null)
			return node.data;

		//if word would be to the left, but there is no node.left, return this node as a suggestion
		if((item.compareTo(node.data)<0) && node.left==null)
			return node.data;

		//if word would be to the right, but there is no node.right, return this node as a suggestion
		if((item.compareTo(node.data)>0) && node.right==null)
			return node.data;

		//if word equals node return node
		if (item.equals(node.data))
			return node.data;

		//traverse recursively down tree until found or not found
		else if(item.compareTo(node.data)<0)
			return find(item, node.left);

		else
			return find(item, node.right);
	}
}