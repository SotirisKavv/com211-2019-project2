package searchTrees.kdTree;

public class KDNode {
		
	private int X;
	private int Y;
	
	private KDNode rightChild, leftChild;
	
	public KDNode() {
		this.X = 0;
		this.Y = 0;
		this.rightChild = null;
		this.leftChild = null;
	}
	
	public KDNode(int x, int y) {
		this.X = x;
		this.Y = y;
		this.rightChild = null;
		this.leftChild = null;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public KDNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(KDNode rightChild) {
		this.rightChild = rightChild;
	}

	public KDNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(KDNode leftChild) {
		this.leftChild = leftChild;
	}
	
	public boolean isEqual(KDNode kdnode) {
		return (this.X == kdnode.getX()) && (this.Y == kdnode.getY());
	}
	
}
