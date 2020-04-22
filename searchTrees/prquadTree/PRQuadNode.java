package searchTrees.prquadTree;

public class PRQuadNode {
	
	private PRQuadNode SW, SE, NW, NE;
	private int minx, miny, maxx, maxy;
	private Point point;
	private PRQuadNode node;
	private NodeType type = NodeType.EMPTY;
	
	public PRQuadNode(int minx, int miny, int maxx, int maxy, PRQuadNode node) {
		this.minx = minx;
		this.miny = miny;
		this.maxx = maxx;
		this.maxy = maxy;
		this.node = node;
	}
	
	public PRQuadNode() {
		this.point = null;
	}

	public PRQuadNode(Point point) {
		this.point = point;
	}

	public boolean isEqual(PRQuadNode node) {
		return (this.point.getX() == node.point.getX()) && (this.point.getY() == node.point.getY());
	}

	public Point getPoint() {
		return point;
	}
	
	public void setPoint(Point point) {
		this.point = point;
	}

	public NodeType getType() {
		return type;
	}

	public void setType(NodeType type) {
		this.type = type;
	}
	
	
	public int getMinx() { return minx; }
	  
	public void setMinx(int minx) { this.minx = minx; }
	  
	public int getMiny() { return miny; }
	  
	public void setMiny(int miny) { this.miny = miny; }
	  
	public int getMaxx() { return maxx; }
	  
	public void setMaxx(int maxx) { this.maxx = maxx; }
	  
	public int getMaxy() { return maxy; }
	  
	public void setMaxy(int maxy) { this.maxy = maxy; }
	  
	public PRQuadNode getNode() { return node; }
	  
	public void setNode(PRQuadNode node) { this.node = node; }
	 
	public PRQuadNode getSW() { return SW; }
	  
	  public void setSW(PRQuadNode sW) { SW = sW; }
	  
	  public PRQuadNode getSE() { return SE; }
	  
	  public void setSE(PRQuadNode sE) { SE = sE; }
	  
	  public PRQuadNode getNW() { return NW; }
	  
	  public void setNW(PRQuadNode nW) { NW = nW; }
	  
	  public PRQuadNode getNE() { return NE; }
	  
	  public void setNE(PRQuadNode nE) { NE = nE; }
	 
	
	
}
