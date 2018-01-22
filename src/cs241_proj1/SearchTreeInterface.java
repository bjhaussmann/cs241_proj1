/**
 * 
 */
package cs241_proj1;

/**
 * @author bjhau
 *
 */
public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T> {

	public T add(T newEntry);

	public boolean contains(T entry);

	public T getEntry(T entry);

	public T remove(T entry);
}
