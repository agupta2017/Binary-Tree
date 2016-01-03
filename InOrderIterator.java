//left
//root
//right
import java.util.Iterator;

public class InOrderIterator<E> implements Iterator<E>
{
	private BinaryTree tree;
	private Queue<E> vector;
	
	public InOrderIterator(BinaryTree t)
	{
		tree = t;
		vector = new LinkedList<E>();
		populateVector(tree);
	}
	
	@SuppressWarnings("unchecked")
	private void populateVector(BinaryTree t)
	{
		if(t.isLeaf())
		{
			vector.offer((E)t.value());
		}
		else if(t.left() == null)
		{
			vector.offer((E)t.value());
			populateVector(t.right());
		}
		else if(t.right() == null)
		{
			populateVector(t.left());
			vector.offer((E)t.value());
		}
		else
		{
			populateVector(t.left());
			vector.offer((E)t.value());
			populateVector(t.right());
		}
	}
	public boolean hasNext()
	{
		return !vector.isEmpty();
	}
	public E next()
	{
		if(vector.isEmpty())
		{
			throw new IndexOutOfBoundsException("You have reached the end already");
		}
		return vector.poll();
	}
}
