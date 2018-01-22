/**
 * 
 */
package cs241_proj1;

/**
 * @author bjhau
 *
 */
public interface TreeInterface <T> {

	public T getRootData();
	public int getHeight();
	public int getNumberOfNodes();
	public boolean isEmpty();
	public void clear();
}
