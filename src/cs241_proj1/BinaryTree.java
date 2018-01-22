/**
 * 
 */
package cs241_proj1;

/**
 * @author bjhau
 *
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {

	private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T root) {
		this.root = new BinaryNode<>(root);
	}

	public BinaryTree(T root, BinaryTree<T> left, BinaryTree<T> right) {
		privateSetTree(root, left, right);
	}

	@Override
	public void clear() {
		root = null;

	}

	@Override
	public int getHeight() {
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	@Override
	public T getRootData() {
		if (isEmpty())
			return null;
		else
			return root.getData();
	}

	protected BinaryNode<T> getRootNode() {
		return root;
	}

	public String inorderTraverse() {
		return inorderTraverse(root);
	}

	private String inorderTraverse(BinaryNode<T> node) {
		String result = "";
		if (node != null) {
			result += inorderTraverse(node.getLeftChild());
			result += node.getData() + " ";
			result += inorderTraverse(node.getRightChild());
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	public String postorderTraverse() {
		return postorderTraverse(root);
	}

	private String postorderTraverse(BinaryNode<T> node) {
		String result = "";
		if (node != null) {
			result += postorderTraverse(node.getLeftChild());
			result += postorderTraverse(node.getRightChild());
			result += node.getData() + " ";
		}
		return result;
	}

	public String preorderTraverse() {
		return preorderTraverse(root);
	}

	private String preorderTraverse(BinaryNode<T> node) {
		String result = "";
		if (node != null) {
			result += node.getData() + " ";
			result += preorderTraverse(node.getLeftChild());
			result += preorderTraverse(node.getRightChild());
		}
		return result;
	}

	private void privateSetTree(T root, BinaryTree<T> left, BinaryTree<T> right) {
		this.root = new BinaryNode<>(root);

		if ((left != null) && !left.isEmpty())
			this.root.setLeftChild(left.root.copy());
		if ((right != null) && !right.isEmpty()) {
			if (right != left)
				this.root.setRightChild(right.root);
			else
				this.root.setRightChild(right.root.copy());
		}
		if ((left != null) && (left != this))
			left.clear();
		if ((right != null) && (right != this))
			right.clear();
	}

	protected void setRootData(T root) {
		this.root.setData(root);
	}

	protected void setRootNode(BinaryNode<T> root) {
		this.root = root;
	}

	public void setTree(T root) {
		this.root = new BinaryNode<>(root);
	}

	public void setTree(T root, BinaryTreeInterface<T> left, BinaryTreeInterface<T> right) {
		privateSetTree(root, (BinaryTree<T>) left, (BinaryTree<T>) right);
	}
}
