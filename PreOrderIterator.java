//left
//root
//right
import java.util.Iterator;

public class PreOrderIterator<E> implements Iterator<E>
{
	private BinaryTree tree;
	private Vector<E> vector;
	
	public PreOrderIterator(BinaryTree t)
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
			vector.offer((E)t.value);
		}
		else if(t.left() == null)
		{
			vector.offer((E)t.value());
			populateVector(t.right());
		}
		else if(t.right() == null)
		{
			vector.offer((E)t.value());
			populateVector(t.left());
		}
		else
		{
			vector.offer((E)t.value());
			populateVector(t.left());
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
