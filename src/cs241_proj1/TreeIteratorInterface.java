/**
 * 
 */
package cs241_proj1;

import java.util.Iterator;

/**
 * @author bjhau
 *
 */
public interface TreeIteratorInterface <T>{

	public Iterator<T> getPreorderIterator();
	public Iterator<T> getPostorderIterator();
	public Iterator<T> getInorderIterator();
	public Iterator<T> getLevelorderIterator();
}
