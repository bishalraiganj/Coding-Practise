package Algorithms_Practise_14;

import java.util.Optional;

class Node{
	public int val;
	Node leftChild;
	Node rightChild;



	public Node(int val)
	{
		this.val = val;
	}

	public void setVal(int val)
	{
		this.val = val;
	}

	public Node getLeftChild()
	{
		return leftChild;
	}

	public Node getRightChild()
	{
		return rightChild;
	}


	public void setLeftChild(Node leftChild)
	{
		this.leftChild = leftChild;
	}

	public void setRightChild(Node rightChild)
	{
		this.rightChild  = rightChild;
	}



}



public class Binary_Search_Tree {



	private Node root;
	private int size = 0;
	private boolean lastDeletionStatus = false;



	public static void main(String... args)
	{

		Node root  = new Node(37);
		Node l2v28  = new Node(28);
		Node l2v41  = new Node(41);
		Node l3v19  = new Node(19);
		Node l3v29  = new Node(29);
		Node l3v39  = new Node(39);
		Node l3v42  = new Node(42);
		Node l4v15  = new Node(15);
		Node l4v20  = new Node(20);
		Node l4v38  = new Node(38);
		Node l4v43  = new Node(43);
		Node l5v21  = new Node(21);




		Binary_Search_Tree bst =  new Binary_Search_Tree(null);

		bst.insert(21);
		bst.insert(43);
		bst.insert(20);
		bst.insert(38);
		bst.insert(39);
		bst.insert(42);
		bst.insert(15);
		bst.insert(28);
		bst.insert(41);
		bst.insert(19);
		bst.insert(29);
		bst.insert(37);



		bst.inOrderTraversal();

		bst.delete(41);
		bst.inOrderTraversal();


	}







	public Binary_Search_Tree(Node root)
	{
		this.root = root;
		if(root != null) {
			size = computeSize(root);
		}
	}

	public static int computeSize(Node node)
	{
		if(node == null ) return 0;

		return 1 + computeSize(node.getLeftChild()) + computeSize(node.getRightChild());

	}

	public void insert(int data)
	{
		if( root!= null)
		{
			recursiveInsert(root, data);
		}
		else
		{
			root = new Node(data);
			size++;
		}

	}

	public void recursiveInsert(Node node, int data)
	{
		if(data >= node.val)
		{
			if(node.rightChild!=null)
			{
				recursiveInsert(node.rightChild, data);
			}
			else
			{
				node.setRightChild(new Node(data));
				size++;
			}
		}
		else
		{
			if(node.leftChild!=null)
			{
				recursiveInsert(node.leftChild,data);
			}
			else
			{
				node.setLeftChild(new Node(data));
				size++;
			}
		}
	}


	public Optional<Integer> delete(int data)
	{
		lastDeletionStatus = false;
		if(root != null)
		{
			root = recursiveDelete(root, data);
		}

		boolean status = lastDeletionStatus;

		if( status )
		{
			size--;
			return Optional.of(data);
		}
		return Optional.empty();

	}


	// it returns the replacement value
	public Node recursiveDelete(Node node , int data)
	{
		if(node==null)
		{
			return null;
		}
		//here, node is not equal to the value to delete so keep Binary Searching and setting with
		//the leftChild and rightChild's with the replacements
		if(    node.val != data  )
		{
			if(node.leftChild != null && data < node.val )
			{
				node.leftChild = recursiveDelete(node.leftChild, data);
			}
			else
			{
				if(node.rightChild != null && data >= node.val)
				{
					node.rightChild = recursiveDelete(node.rightChild, data);
				}
			}
		}

		// here , node's val matches data +
		if(node.val == data)
		{
			lastDeletionStatus = true;

			if (node.leftChild != null && node.rightChild != null)
			{

					node.setVal( getSmallest(node.rightChild).val); // When both child's exist selecting the
					//smallest node of the right sub tree of this matching node
				     node.setRightChild(deleteMin(node.rightChild));
					 return node; // not necessary as we are also returning node at the end
			}
		else
		{
				if (node.leftChild != null)
				{
					return node.leftChild;
				}
				else if (node.rightChild != null)
				{
					return node.rightChild;
				}
				else
				{
					return null;
				}
			}
		}

		//here , control comes means the for this node value did not match so return value of recursiveDelete()
		//should be this node , because it's previous parent's child's are   also being set by this recursiveDelete()
		//so since,


		return node;


	}


	public void inOrderTraversal()
	{
		if(root != null)
		{
			inOrderTraversal(root);
		}
	}



	//recursive compile time polymorphism overloaded version
	public void inOrderTraversal(Node node)
	{
		if(node != null) {
			if (node.leftChild != null) {
				inOrderTraversal(node.leftChild);
			}

			System.out.print(node.val + ", ");

			if (node.rightChild != null) {
				inOrderTraversal(node.rightChild);
			}
		}

	}



	public Node deleteMin(Node node)
	{
		if(node.leftChild == null)
		{
			return node.rightChild;
		}

		node.leftChild = deleteMin(node.leftChild);

		return node;

	}

	public Node getGreatest(Node node)
	{
		if(node.rightChild != null)
		{
			return getGreatest(node.rightChild);
		}

		return node;
	}


	public Node getSmallest(Node node)
	{
		if(node.leftChild != null)
		{
			return getSmallest(node.leftChild);
		}

		return node;
	}






}
