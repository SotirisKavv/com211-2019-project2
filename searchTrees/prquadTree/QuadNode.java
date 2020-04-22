package searchTrees.prquadTree;

public class QuadNode {
	
	private Point point;
	private QuadNode NW, NE, SW, SE;
	private int minx, maxx, miny, maxy;
	private NodeType type = NodeType.EMPTY;
	
	public QuadNode(Point point) {
		this.point = point;
	}

	public QuadNode(int minx, int maxx, int miny, int maxy) {
		this.minx = minx;
		this.maxx = maxx;
		this.miny = miny;
		this.maxy = maxy;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public QuadNode getNW() {
		return NW;
	}

	public void setNW(QuadNode nW) {
		NW = nW;
	}

	public QuadNode getNE() {
		return NE;
	}

	public void setNE(QuadNode nE) {
		NE = nE;
	}

	public QuadNode getSW() {
		return SW;
	}

	public void setSW(QuadNode sW) {
		SW = sW;
	}

	public QuadNode getSE() {
		return SE;
	}

	public void setSE(QuadNode sE) {
		SE = sE;
	}

	public int getMinx() {
		return minx;
	}

	public void setMinx(int minx) {
		this.minx = minx;
	}

	public int getMaxx() {
		return maxx;
	}

	public void setMaxx(int maxx) {
		this.maxx = maxx;
	}

	public int getMiny() {
		return miny;
	}

	public void setMiny(int miny) {
		this.miny = miny;
	}

	public int getMaxy() {
		return maxy;
	}

	public void setMaxy(int maxy) {
		this.maxy = maxy;
	}

	public NodeType getType() {
		return type;
	}

	public void setType(NodeType type) {
		this.type = type;
	}
	
}
