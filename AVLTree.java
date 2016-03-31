/**
 * Implementation of AVL tree data structure that holds Node ojbects 
 * that stores an integer as their data.
 * @author Isaac Mast
 */
public class AVLTree {

	// declare instance variables
	private Node root;

	/**
	 * Constructs an empty AVL tree.
	 */
	public AVLTree() {
		this.root = null;
	}

	/**
	 * Constructs an AVL tree, setting root to a new Node that contains
	 * the int value, data
	 * @param data - the int value to be stored in the AVLtree's root node
	 */
	public AVLTree(int data) {
		this.root = new Node(data);
	}

	/**
	 * Creates a new Node that contains an integer, data, and 
	 * inserts it into the AVL tree. 
	 * @param data - int value to be stored in the new Node object
	 */
	public void insert(int data) throws NodeAlreadyExistsException {
		try {
			Node newNode = new Node(data);
			Node current = root;
			if (root == null) {
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
	 * Finds a Node in the AVL tree that contains the integer, data
	 * @return true if a Node is found in the AVL tree that contains
	 * the int value, data
	 * @return false if a Node is not found in the AVL tree that
	 * contains the int value, data
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
