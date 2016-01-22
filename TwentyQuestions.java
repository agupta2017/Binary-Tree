import java.util.Scanner;

public class TwentyQuestions
{
	private BinaryTree<String> root;
	
	public TwentyQuestions()
	{
		root = new BinaryTree("Is it alive?");
		root.setRight(new BinaryTree("Chicken"));
		root.setLeft(new BinaryTree("Computer"));
	}
	
	public void userInterface()
	{
		playGame();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Do you want to play again?" + " Answer with Y or N");
		String answer = keyboard.next();
		if(answer.equals("Y"))
		{
			userInterface();
		}
		else
		{
			System.out.println("Fine! Go be a sore loser. I suppose you don't want to have fun");
		}
	}
	
	public void playGame()
	{
		BinaryTree<String> current = root;
		Scanner keyboard = new Scanner(System.in).useDelimiter("\\s*\n\\s*");
		while(!current.isLeaf())
		{
			System.out.println(current.value() + ". Answer with Y or N");
			String answer = (keyboard.next());
			if(answer.equals("Y"))
			{
				current = current.right();
			}
			else
			{
				current = current.left();
			}
		}
		System.out.println("Is your object " + current.value());
		String answer = (keyboard.next());
		if(answer.equals("Y"))
		{
			System.out.println("HA...You simpletons are no match for my fabulous intelligence");
		}
		else
		{
			System.out.println("What is your object?");
			String object = keyboard.next();
			System.out.println("Provide a question to differentiate " + object + " from " + current.value());
			answer = keyboard.next();
			String oldObject = current.value();
			current.setValue(answer);
			System.out.println(answer + " Answer with Y or N for your chosen object");
			answer = keyboard.next();
			if(answer.equals("Y"))
			{
				current.setRight(new BinaryTree(object));
				current.setLeft(new BinaryTree(oldObject));
			}
			else
			{
				current.setLeft(new BinaryTree(object));
				current.setRight(new BinaryTree(oldObject));
			}
		}
	}
}
