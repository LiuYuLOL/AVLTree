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
	 * Gets the root Node of the AVLTree
	 * @return root - the root Node of the AVLTree
	 */
	public Node getRoot() {
		return this.root;
	}

	/**
	 * Creates a new Node that contains an integer, data, and 
	 * inserts it into the AVL tree. 
	 * @param data - int value to be stored in the new Node object
	 * @throws NodeAlreadyExistsException - if the tree contains a node 
	 * that already has an int value equal to data
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

	/**
	 * Performs a pre-order traversal of the AVLTree and prints out
	 * the data of each Node
	 * @param current - the visited Node in the AVLTree
	 */
	public void preOrder(Node current) {
		if (current == null) {
			System.out.print("null ");
		} else {
			System.out.print(current.getData() + " ");
			preOrder(current.getLeftChild());
			preOrder(current.getRightChild());
		}
	}

	/**
	 * Performs an in-order traversal of the AVLTree and prints out
	 * the data of each Node
	 * @param current - the visited Node in the AVLTree
	 */
	public void inOrder(Node current) {
		if (current == null) {
			System.out.print("null ");
		} else {
			inOrder(current.getLeftChild());
			System.out.print(current.getData() + " ");
			inOrder(current.getRightChild());
		}
	}

	/**
	 * Performs a post-order traversal of the AVLTree and prints out
	 * the data of each Node
	 * @param current - the visited Node in the AVLTree
	 */
	public void postOrder(Node current) {
		if (current == null) {
			System.out.print("null ");
		} else {
			postOrder(current.getLeftChild());
			postOrder(current.getRightChild());
			System.out.print(current.getData() + " ");
		}
	}
}
