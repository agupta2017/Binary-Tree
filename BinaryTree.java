import java.util.Iterator;
import java.lang.Iterable;
public class BinaryTree<E> implements Iterable
{
	protected E value;
	protected BinaryTree<E> left;
	protected BinaryTree<E> right;
	
	public BinaryTree(E v, BinaryTree<E> l, BinaryTree<E> r)
	{
		value = v;
		left = l;
		right = r;
	}
	public BinaryTree(E v)
	{
		value = v;
		left = null;
		right = null;
	}
	public BinaryTree()
	{
		value = null;
		left = null;
		right = null;
	}
	
	
	
	public BinaryTree<E> left()
	{
		return left;
	}
	public BinaryTree<E> right()
	{
		return right;
	}
	public E value()
	{
		return value;
	}
	
	
	
	public void setLeft(BinaryTree<E> node)
	{
		left = node;
	}
	public void setRight(BinaryTree<E> node)
	{
		right = node;
	}
	public void setValue(E val)
	{
		value = val;
	}
	
	
	
	public boolean isLeaf()
	{
		if(left == null && right == null)
		{
			return true;
		}
		return false;
	}
	
	public Iterator<E> iterator()
	{
		return inOrderIterator();
	}
	public Iterator<E> inOrderIterator()
	{
		return new InOrderIterator(this);
	}
	public Iterator<E> preOrderIterator()
	{
		return new PreOrderIterator(this);
	}
	public Iterator<E> postOrderIterator()
	{
		return new PostOrderIterator(this);
	}
	
	
	public int size()
	{
		if(isLeaf())
		{
			return 1;
		}
		return 1 + left.size() + right.size();
	}
	public int height()
	{
		if(isLeaf())
		{
			return 0;
		}
		int leftH = left.height()+1;
		int rightH = right.height()+1;
		if(leftH > rightH)
		{
			return leftH;
		}
		return rightH;
	}
	public boolean isFull()
	{
		if(isLeaf())
		{
			return true;
		}
		if(right == null || left == null)
		{
			return false;
		}
		if((left.height() == right.height()) && (left.isFull() && right.isFull()))
		{
			return true;
		}
		return false;
	}
	public boolean isBalanced()
	{
		if(isLeaf())
		{
			return true;
		}
		if(right == null)
		{
			return left.isLeaf();
		}
		if(left == null)
		{
			return right.isLeaf();
		}
		if(Math.abs(right.height() - left.height()) > 1)
		{
			return false;
		}
		return right.isBalanced() && left.isBalanced();
	}
	public boolean isComplete()
	{
		if(isLeaf())
		{
			return true;
		}
		if(right == null)
		{
			return left.isLeaf();
		}
		if(left == null)
		{
			return false;
		}
		if(left.height() - right.height() ==1)
		{
			return left.isComplete() && right.isFull();
		}
		if(left.height() == right.height())
		{
			return left.isFull() && right.isComplete();
		}
		return false;
	}
	public String toString()
	{
		if(isLeaf() == true)
		{
			return value.toString();
		}
		if(right == null)
		{
			return value + "(" + left.toString() + ")";
		}
		if(left == null)
		{
			return value + "(" + right.toString() + ")";
		}
		return value + "(" + left.toString() + ", " + right.toString() + ")";
	}
}
