/**
 * 
 */
package cs241_proj1;

import java.util.Scanner;

/**
 * @author bjhau
 *
 */
public class Main {

	/**
	 * @param args
	 */
	static Scanner in = new Scanner(System.in);
	static String str = null;
	static String [] strArray;
	static BinarySearchTree <Integer> tree = new BinarySearchTree<Integer>();
	
	public static void main(String[] args) {
		start();
		System.out.println(tree.postorderTraverse());
		in.close();
	}

	private static void start ()
	{
		System.out.println("Please enter the initial sequence of values: ");
		str = in.nextLine();
		strArray = str.split("\\s+");
		
		try
		{
		for (int i = 0; i < strArray.length; i++)
		{
			tree.add(Integer.parseInt(strArray[i]));
		}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid character entered. Ensure all numbers are integers seperated by spaces.");
			start();
		}
	}
}
