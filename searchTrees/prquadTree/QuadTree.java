package searchTrees.prquadTree;

public class QuadTree {
	
	//Member Variables
	private QuadNode root;	//root from where the tree starts
	public static int  comparisons = 0;	//number of comparisons executed while searching for an element
	
	
	//Constructor	-->Setting the limits (Max-Min Horizontal/ Max-Min Vertical)
	public QuadTree(int minx, int maxx, int miny, int maxy) {
		this.root = new QuadNode(minx, maxx, miny, maxy);			
	}
	
	/**
	 * This Method is used publicly from other classes to insert a new point 
	 * with coordinates (a,b) to the data structure
	 * @param a Abcissa
	 * @param b Ordinate
	 */
	public void insert(int a, int b) {
		Point p = new Point(a, b);
		this.insert(p, root);
	}
	
	/**
	 * This Method is used publicly from other classes to insert a new point p 
	 * to the data structure, starting from the current tree's root. First, it 
	 * checks the root's type:
	 * 1. if it is EMPTY, the method initializes the root's point.
	 * 2. if it is LEAF, it checks if the point that is already there is the 
	 * 	same with the point to be inserted. Otherwise, it splits the current node,
	 * 	then it re-inserts the old point found in the node earlier and finally it 
	 * 	inserts the point p to the right sub-tree.
	 * 3. if it is ROOT, the method continues to the right sub-tree depending on 
	 * 	the coordinates
	 * @param p: point to  be inserted
	 * @param node: node to start from
	 */
	public void insert(Point p, QuadNode node) {
		switch(node.getType()) {
			case EMPTY:
				node.setPoint(p);
				node.setType(NodeType.LEAF);
				break;
			case LEAF:
				if (!node.getPoint().isEqual(p)) {
					this.split(node);
					this.insert(p, node);
				}
				break;
			case ROOT:
				this.insert(p, this.getOrientation(p, node));
				break;
			default:
				System.out.println("Error");
		}
	}
	
	/**
	 * This Method is used to "split" the node. First it neutralizes it, storing its 
	 * point-value at a temporary variable, by setting it to null and its type to ROOT.
	 * Then it computes the half of the height and the width and finally initializes the new 
	 * trees (SouthWest, NorthWest, SouthEast, NorthEast) according to the min/max/half values.
	 * @param node: node to be split
	 */
	public void split(QuadNode node) {
		
		Point oldPoint = node.getPoint();
		
		node.setPoint(null);
		node.setType(NodeType.ROOT);
		
		int halfWidth = (node.getMaxx() + node.getMinx())/2;
		int halfHeigth = (node.getMaxy() + node.getMiny())/2;
		
		node.setNE(new QuadNode(halfWidth, node.getMaxx(), halfHeigth, node.getMaxy()));
		node.setSW(new QuadNode(node.getMinx(), halfWidth, node.getMiny(), halfHeigth));
		node.setNW(new QuadNode(node.getMinx(), halfWidth, halfHeigth, node.getMaxy()));
		node.setSE(new QuadNode(halfWidth, node.getMaxx(), node.getMiny(), halfHeigth));
		
		this.insert(oldPoint, node);
	}
	
	/**
	 * This Method returns the tree to continue the insertion, based on the point's p 
	 * coordinates
	 * @param p: point based on which the right tree is returned
	 * @param node: the node from which we get the trees
	 * @return the right tree (SouthWest/ NorthWest/ SouthEast/ NorthEast)
	 */
	public QuadNode getOrientation(Point p, QuadNode node) {
		
		int halfWidth = (node.getMaxx() + node.getMinx())/2;
		int halfHeigth = (node.getMaxy() + node.getMiny())/2;
		
		if (p.getX()>=halfWidth)
			return (p.getY()>= halfHeigth)? node.getNE(): node.getSE();
		else
			return (p.getY()>= halfHeigth)? node.getNW(): node.getSW();
	}
	
	/**
	 * This method is used publicly from other classes to search for a point
	 * with coordinates (a,b) in a quadTree structure
	 * @param a Abcissa
	 * @param b Ordinate
	 * @return true if the element is found/ otherwise false
	 */
	public boolean search(int a, int b) {
		Point p = new Point(a, b);
		return this.search(p, root);
	}
	
	/**
	 * This method is used to search for a point p starting from a QuadTree root.
	 * Each time we look at a bigger depth, "comparisons" static variable is augmented 
	 * by 1.
	 * @param p: point we look for
	 * @param node: node we start the search from
	 * @return true if found/ otherwise false
	 */
	public boolean search(Point p, QuadNode node) {
		if (node==null) 
			return false;
		
		if (node.getPoint()!=null && node.getPoint().isEqual(p))
			return true;
		
		int halfWidth = (node.getMaxx() + node.getMinx())/2;
		int halfHeigth = (node.getMaxy() + node.getMiny())/2;
		
		comparisons++;
		if (p.getX()>=halfWidth)
			return (p.getY()>= halfHeigth)? search(p,node.getNE()): search(p,node.getSE());
		else
			return (p.getY()>= halfHeigth)? search(p,node.getNW()): search(p, node.getSW());
	}
}
