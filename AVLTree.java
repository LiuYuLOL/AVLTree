/**
 * Implementation of AVL tree data structure that holds Node ojbects 
 * that stores an integer as its data.
 * @author Isaac Mast
 */
public class AVLTree {

	//Declare instance variables
	private Node root;

	/**
	 * Constructs an empty AVL tree.
	 */
	public AVLTree() {
		this.root = null;
	}

	/**
	 * Constructs an AVL tree by creating a new Node object, newNode, 
	 * and setting it as the tree's root node.
	 * @param data the integer to be stored in the AVL tree's root node
	 */
	public AVLTree(int data) {
		this.root = new Node(data);
	}

	/**
	 * Creates a new Node object that contains an integer, data, and 
	 * inserts it into the AVL tree. 
	 * @param data integer to be stored in the new Node object
	 */
	public void insert(int data) throws NodeAlreadyExistsException {
		try {
			Node newNode = new Node(data);
			Node current = root;
			if (current == null) {
				root = newNode;
			}
			while (current != null) {
				if (data < current.getData()) {
					current = current.getLeftChild();
				} else if (data > current.getData()) {
					current = current.getRightChild();
				} else {
					throw new NodeAlreadyExistsException(data);
				}
			}
			current = newNode;
		} catch (NodeAlreadyExistsException e) {
			System.out.println(e + "\n");
		}
	}

	/**
	 * Finds a Node object in the AVL tree that contains the integer, 
	 * data.
	 * @return True if a Node object is found in the AVL tree that 
	 * contains the integer, data
	 * @return False if a Node object is not found in the AVL tree 
	 * that contains the integer, data
	 */
	public boolean find(int data) {
		Node current = root;
		if (current.getData() == data) {
			return true;
		}
		while (current.getData() != data && current != null) {
			if (data < current.data) {
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
		}
		return false;
	}
}
