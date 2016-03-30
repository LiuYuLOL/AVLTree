public class NodeAlreadyExistsException extends Exception {

	// declare instance variables
	private int data;

	public NodeAlreadyExistsException() {

	}

	public NodeAlreadyExistsException(int data) {
		this.data = data;
	}

	public String toString() {
		return "A Node containing " + this.data + " already exists";
	}
}
