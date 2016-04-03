public class AVLTreeAutoTest extends AVLTreeTest {

	public AVLTreeAutoTest() {
		super();
	}

	public static void main(String[] args) throws NodeAlreadyExistsException {
		AVLTreeAutoTest test = new AVLTreeAutoTest();
		AVLTree tree = new AVLTree();

		int[] values = {10, 7, 13, 2, 5, 16, 3, 11, 6, 8, 12};

		// test insert()
		try {
			print(TESTING_INSERT, true);
			for (int i: values) {
				print(INSERTING + i + ELLIPSIS, false);
				tree.insert(i);
			}
		} catch (Exception e) {
			print(e.toString(), true);
		}

		}
	}
}
