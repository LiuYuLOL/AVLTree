public class AVLTreeAutoTest extends AVLTreeTest {

	public AVLTreeAutoTest() {
		super();
	}

	public static void main(String[] args) throws NodeAlreadyExistsException {
		AVLTreeAutoTest test = new AVLTreeAutoTest();
		AVLTree tree = new AVLTree();

		int[] values = {10, 7, 13, 2, 5, 16, 3, 11, 6, 8, 12};

		try {
			print(test.TESTING_INSERT, true);
			for (int i: values) {
				print(test.INSERTING + i + test.ELLIPSIS, false);
				tree.insert(i);
			}
		} catch (Exception e) {
			test.print(e.toString(), true);
		}
	}
}
