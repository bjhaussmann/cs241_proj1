/**
 * 
 */
package cs241_proj1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import StackAndQueuePackage.*;

/**
 * @author bjhau
 *
 */
public class BinaryTree <T> implements BinaryTreeInterface <T> {

	private BinaryNode <T> root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	public BinaryTree (T root)
	{
		this.root = new BinaryNode<>(root);
	}
	
	public BinaryTree(T root, BinaryTree<T> left, BinaryTree<T> right)
	{
		privateSetTree(root, left, right);
	}
	
	public void setTree (T root)
	{
		this.root =  new BinaryNode<>(root);
	}
	
	public void setTree(T root, BinaryTreeInterface<T> left, BinaryTreeInterface<T> right)
	{
		privateSetTree(root, (BinaryTree <T>) left, (BinaryTree<T>) right);
	}
	
	private void privateSetTree(T root, BinaryTree<T> left, BinaryTree<T> right)
	{
		this.root = new BinaryNode<> (root);
		
		if ((left != null) && !left.isEmpty())
			this.root.setLeftChild(left.root.copy());
		if ((right != null) && !right.isEmpty())
		{
			if(right != left)
				this.root.setRightChild(right.root);
			else
				this.root.setRightChild(right.root.copy());
		}
		if ((left != null) && (left != this))
			left.clear();
		if ((right != null) && (right != this))
			right.clear();
	}

	@Override
	public T getRootData() {
		if (isEmpty())
			throw new EmptyTreeException();
		else
			return root.getData();
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
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;
		
	}
	
	protected void setRootData(T root)
	{
		this.root.setData(root);
	}
	
	protected void setRootNode(BinaryNode<T> root)
	{
		this.root = root;
	}
	
	protected BinaryNode <T> getRootNode()
	{
		return root;
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getLevelorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
