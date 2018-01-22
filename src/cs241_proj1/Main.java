/**
 * 
 */
package cs241_proj1;

import java.util.InputMismatchException;
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
	static String[] strArray;
	static BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

	public static void main(String[] args) {
		start();
		System.out.println("Preorder: " + tree.preorderTraverse());
		System.out.println("Inorder: " + tree.inorderTraverse());
		System.out.println("Postorder: " + tree.postorderTraverse());
		String select = "";

		while (select != "E") {

			System.out.print("Command? ");
			select = in.next(); // Pull in the letter of the command
			select = select.toUpperCase();
			int num = 0;
			if (select.equals("I") || select.equals("D") || select.equals("P") || select.equals("S")) {
				try {
					num = in.nextInt(); //Pull in the number of the commands that require it.
					in.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("Command must be followed by an integer!");
					in.nextLine();
					select = "B";
				}
			}
			switch (select) {
			// insert a value
			case "I":
				if (tree.add(num) != null)
					System.out.println(num + " already exists. Ignored.");
				else
					System.out.println("Inorder: " + tree.inorderTraverse());
				break;
			case "D": //delete
				if (tree.contains(num)) {
					tree.remove(num);
					System.out.println("Inorder: " + tree.inorderTraverse());
				} else
					System.out.println(num + "doesn't exist.");
				break;
			case "P": //predecessor
				if (tree.contains(num)) {
					int pred = tree.findPredecessor(num);
					if (num == pred) // number entered was the first in the traversal and has no predecessor.
						System.out.println("First number in traversal. No predecessor!");
					else
						System.out.println(pred);
				}
				break;
			case "S": //successor
				if (tree.contains(num)) {
					int succ = tree.findSuccessor(num);
					if (num == succ) //number entered was the last in the traversal and has no successor
						System.out.println("Last number in traversal. No successor!");
					else
						System.out.println(succ);
				}
				break;
			case "E": //exit
				System.exit(0);
				break;
			case "H": //help menu
				System.out.println("I Insert a value");
				System.out.println("D Delete a value");
				System.out.println("P Find predecessor");
				System.out.println("S Find successor");
				System.out.println("E Exit the program");
				System.out.println("H Display this message");
				break;
			case "B": // command was not followed by an integer when necessary
				break;
			default:
				System.out.println("Invalid selection! Press H for help.");
				in.nextLine();
				break;
			}
		}
		in.close();
	}
/**
 * Separate method so it can be run again if the conditions are not met.
 */
	private static void start() { 
		System.out.println("Please enter the initial sequence of values: ");
		str = in.nextLine();
		strArray = str.split("\\s+");

		try {
			for (int i = 0; i < strArray.length; i++) {
				tree.add(Integer.parseInt(strArray[i]));
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid character entered. Ensure all numbers are integers seperated by spaces.");
			start();
		}
	}
}
