/**
 * 
 */
package cs241_proj1;

/**
 * @author bjhau
 *
 */
public class BinaryNode <T> {

	private T data;
	private BinaryNode <T> leftChild;
	private BinaryNode<T> rightChild;
	
	public BinaryNode()
	{
		this(null);
	}
	
	public BinaryNode(T data)
	{
		this (data, null, null);
	}
	
	public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild)
	{
		data = this.data;
		leftChild = this.leftChild;
		rightChild = this.rightChild;
	}
	
	public T getData()
	{
		return data;
	}
	
	public void setData(T data)
	{
		this.data = data;
	}
	
	public BinaryNode <T> getLeftChild()
	{
		return leftChild;
	}
	
	public void setLeftChild(BinaryNode<T> leftChild)
	{
		this.leftChild=leftChild;
	}
	
	public boolean hasLeftChild()
	{
		return leftChild != null;
	}
	
	public boolean isLeaf()
	{
		return (leftChild == null) && (rightChild == null);
	}
	public BinaryNode <T> getRightChild()
	{
		return rightChild;
	}
	
	public void setRightChild(BinaryNode<T> rightChild)
	{
		this.rightChild = rightChild;
	}
	
	public boolean hasRightChild()
	{
		return rightChild != null;
	}
	
	public int getNumberOfNodes()
	{
		
	}
	
	public int getHeight()
	{
		
	}
	
	public BinaryNode<T> copy()
	{
		
	}
	
	
}
