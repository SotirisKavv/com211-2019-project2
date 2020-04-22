package searchTrees.kdTree;

public class KDTree {
	
	//Member Variables
	private int k;	//number of dimensions/numbers in nodes
	private KDNode root;	//tree's first Node
	public static int comparisons=0;
	
	
	//Constructor --> Setting the dimension
	public KDTree(int k) {
		root = null;
		this.k = k;
	}
	
	/**
	 * This method is used publicly from other classes for inserting 
	 * new points with coordinates (a,b) 
	 * @param a Abcissa
	 * @param b Ordinate
	 */
	public void insert(int a, int b) {
		insert(a, b, root, 0);
	}
	
	/**
	 * This Method is used for inserting new points with coordinates
	 * (a,b) based on the depth where we insert:
	 * if the depth we are at the moment is an even number, the insertion 
	 * is based on the X-Axis. Otherwise on the Y-Axis
	 * @param x	Abcissa
	 * @param y Ordinate
	 * @param kdnode Insertion Starting Node
	 * @param depth Current Depth
	 */
	private void insert(int x, int y, KDNode kdnode, int depth) {
		
		if (kdnode == null) {
			root = new KDNode(x, y);
			return;
		}
		
		if (depth % k == 0) {
			if(x > kdnode.getX()) {
				if (kdnode.getRightChild() == null)
					kdnode.setRightChild(new KDNode(x,y));
				else
					insert(x, y, kdnode.getRightChild(), depth+1);
			} else {
				if (kdnode.getLeftChild() == null)
					kdnode.setLeftChild(new KDNode(x,y));
				else
					insert(x, y, kdnode.getLeftChild(), depth+1);
			}
		} else {
			if(y > kdnode.getY()) {
				if (kdnode.getRightChild() == null)
					kdnode.setRightChild(new KDNode(x,y));
				else
					insert(x, y, kdnode.getRightChild(), depth+1);
			} else {
				if (kdnode.getLeftChild() == null)
					kdnode.setLeftChild(new KDNode(x,y));
				else
					insert(x, y, kdnode.getLeftChild(), depth+1);
			}
		}
			
	}
	
	/**
	 * This method is used for searching an element with coordinates (a,b)
	 * inside a KD Tree structure 
	 * @param a Abcissa
	 * @param b Ordinate
	 * @return true if found/otherwise false
	 */
	public boolean search(int a, int b) {
		return search(a, b, root, 0);
	}
	
	/**
	 * This method is used for searching an element with coordinates (a,b)
	 * inside a KD Tree structure, starting from kdnode and based on the depth
	 * we are at the moment. Each time we don't find the element we want at a 
	 * current depth, the number of "comparisons" is augmented by one.
	 * @param a Abcissa
	 * @param b Ordinate
	 * @param kdnode Current Node
	 * @param depth Current Depth
	 * @return true if found/otherwise false
	 */
	private boolean search(int x, int y, KDNode kdnode, int depth) {
		
		if (kdnode == null)
			return false;
		
		comparisons = depth;
		if (depth % k == 0) {
			if ((new KDNode(x,y)).isEqual(kdnode))
				return true;			
			if(x > kdnode.getX())
				return search(x, y, kdnode.getRightChild(), depth+1);
			else
				return search(x, y, kdnode.getLeftChild(), depth+1);
		} else {
			if ((new KDNode(x,y)).isEqual(kdnode))
				return true;			
			if(y > kdnode.getY())
				return search(x, y, kdnode.getRightChild(), depth+1);
			else
				return search(x, y, kdnode.getLeftChild(), depth+1);
		}
			
	}
	
}
