/**
 * 
 */
package cs241_proj1;

/**
 * @author bjhau
 *
 */
public class BinarySearchTree <T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {
	public BinarySearchTree()
	{
		super();
	}
	
	public BinarySearchTree(T rootEntry)
	{
		super();
		setRootNode(new BinaryNode <T>(rootEntry));
	}
	
	public void setTree(T rootData)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}

	@Override
	public T getEntry(T entry) {
		return findEntry (getRootNode(), entry);
	}

	private T findEntry (BinaryNode<T> rootNode, T entry)
	{
		T result = null;
		if(rootNode != null)
		{
			T rootEntry = rootNode.getData();
			if (entry.equals(rootEntry))
				result = rootEntry;
			else if (entry.compareTo(rootEntry) < 0)
				result = findEntry(rootNode.getLeftChild(), entry);
			else
				result = findEntry(rootNode.getRightChild(), entry);
		}
		return result;
	}
	
	@Override
	public T add(T newEntry) {
		T result = null;
		if(isEmpty())
			setRootNode(new BinaryNode<>(newEntry));
		else
			result = addEntry(getRootNode(), newEntry);
		return result;
	}

	private T addEntry(BinaryNode<T> rootNode, T newEntry)
	{
		assert rootNode != null;
		T result = null;
		int comparison = newEntry.compareTo(rootNode.getData());
		
		if (comparison == 0)
		{
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}
		else if(comparison < 0)
		{
			if( rootNode.hasLeftChild())
				result = addEntry(rootNode.getLeftChild(), newEntry);
			else 
				rootNode.setLeftChild(new BinaryNode <>(newEntry));
		}
		else 
		{
			assert comparison > 0;
			if (rootNode.hasRightChild())
				result = addEntry(rootNode.getRightChild(), newEntry);
			else
				rootNode.setRightChild(new BinaryNode<>(newEntry));
		}
		return result;
	}
	
	@Override
	public T remove(T entry) {
		T oldEntry = null;
		BinaryNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
		setRootNode(newRoot);
		return oldEntry;
	}
	
	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry, T oldEntry)
	{
		if (rootNode != null)
		{
			T rootData = rootNode.getData();
			int comparison = entry.compareTo(rootData);
			
			if (comparison == 0)
			{
				oldEntry = rootData;
				rootNode = removeFromRoot(rootNode);
			}
			else if (comparison < 0)
			{
				BinaryNode<T> leftChild = rootNode.getLeftChild();
				BinaryNode<T> subtreeRoot = removeEntry(leftChild, entry, oldEntry);
				rootNode.setLeftChild(subtreeRoot);
			}
			else
			{
				BinaryNode<T> rightChild = rootNode.getRightChild();
				rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
			}
		}
		return rootNode;
	}

	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {
		if (rootNode.hasLeftChild() && rootNode.hasRightChild())
		{
			BinaryNode <T> leftSubtreeRoot = rootNode.getLeftChild();
			BinaryNode <T> largestNode = findLargest(leftSubtreeRoot);
			
			rootNode.setData(largestNode.getData());
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		}
		else if (rootNode.hasRightChild())
			rootNode = rootNode.getRightChild();
		else rootNode = rootNode.getLeftChild();
		return rootNode;
	}

	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
		if (rootNode.hasRightChild())
		{
			BinaryNode <T> rightChild = rootNode.getRightChild();
			rightChild = removeLargest(rightChild);
			rootNode.setRightChild(rightChild);
		}
		else
			rootNode = rootNode.getLeftChild();
		return rootNode;
	}

	private BinaryNode<T> findLargest(BinaryNode<T> rootNode) {
		if ( rootNode.hasRightChild())
			rootNode = findLargest(rootNode.getRightChild());
		return rootNode;
	}

	public int findPredecessor(int num) {
		int count = 0;
		String[] strArray = this.inorderTraverse().split("\\s+");
		return privatePredecessor(num, strArray, count);
	}

	private int privatePredecessor(int num, String[] strArray, int count) {
		int pred = num;
		if (Integer.parseInt(strArray[count]) == num)
			pred = Integer.parseInt(strArray[count - 1]);
		else if (count < strArray.length - 1)
			pred = privatePredecessor(num, strArray, count + 1);
		return pred;
	}

	public int findSuccessor(int num) {
		int count = 0;
		String[] strArray = this.inorderTraverse().split("\\s+");
		return privateSuccessor(num, strArray, count);
	}
	private int privateSuccessor(int num, String[] strArray, int count) {
		int succ = num;
		if (Integer.parseInt(strArray[count]) == num)
			succ = Integer.parseInt(strArray[count + 1]);
		else if (count < strArray.length - 1)
			succ = privateSuccessor(num, strArray, count + 1);
		return succ;
	}
}
