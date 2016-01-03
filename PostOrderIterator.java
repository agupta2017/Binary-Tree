//left
//root
//right
import java.util.Iterator;

public class PostOrderIterator<E> implements Iterator<E>
{
	private BinaryTree tree;
	private Vector<E> vector;
	
	public PostOrderIterator(BinaryTree t)
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
			populateVector(t.right());
			vector.offer((E)t.value());
		}
		else if(t.right() == null)
		{
			populateVector(t.left());
			vector.offer((E)t.value());
		}
		else
		{
			populateVector(t.left());
			populateVector(t.right());
			vector.offer((E)t.value());
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
