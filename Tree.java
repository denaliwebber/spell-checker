public class Tree
{
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

	private Node root=null;

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
		if(node.left==null && node.right==null)
			return node.data;

		if (item.equals(node.data))
			return node.data;

		else if(item.compareTo(node.data)<0)
			return find(item, node.left);

		else
			return find(item, node.right);
	}

	public void print()
	{
		print(root);
	}

	private void print(Node root)
	{
		if (root != null)
		{
			print(root.left);
			System.out.println(root.data);
			print(root.right);
		}
	}
}