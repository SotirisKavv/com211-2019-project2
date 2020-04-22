package searchTrees.prquadTree;

public class PRQuadTree {
	
	private PRQuadNode root;
	
	public PRQuadTree(int minH, int minW, int maxH, int maxW) {
		this.root = new PRQuadNode(minW, minH, maxW, maxH, null);
	}
	
	public void insert(int a, int b) {
		insert(a, b, root);
	}
	
	private void insert(int a, int b, PRQuadNode node) {
		if (node.getType() == NodeType.EMPTY) {
			node.setPoint(new Point(a,b)); 
			node.setType(NodeType.LEAF);
		    return; 
		}
		
		if (node.getType() == NodeType.LEAF) {
			if (node.getPoint().getX()==a && node.getPoint().getY()==b)
				return;
			else {
				this.split(node);
			}		
		}
		
		if (node.getType() == NodeType.ROOT) {
			insert(a, b, this.getTreeToInsert(a, b, node));
		}
		
		
	}
	
	public void split(PRQuadNode node) {
		
		Point oldPoint = node.getPoint();
		node.setPoint(null);
		node.setType(NodeType.ROOT);
		
		float halfHeight = node.getMaxy() / 2;
		float halfWidth = node.getMaxx() / 2;
		int minWidth = node.getMinx();
		int minHeight = node.getMiny();
		int maxWidth = node.getMaxx();
		int maxHeight = node.getMaxy();
		
		node.setNE(new PRQuadNode((int) halfHeight, minWidth, maxHeight, (int) halfWidth, node));
		node.setSE(new PRQuadNode(minHeight, (int) halfWidth, (int) halfHeight, maxWidth, node));
		node.setNW(new PRQuadNode((int) halfHeight, (int) halfWidth, maxHeight, maxWidth, node));
		node.setSW(new PRQuadNode(minHeight, minWidth, (int) halfHeight, (int) halfWidth, node));
		
		insert(oldPoint.getX(), oldPoint.getY(), node);
	}
	
	public PRQuadNode getRoot() {
		return root;
	}

	public void setRoot(PRQuadNode root) {
		this.root = root;
	}
	
	public PRQuadNode getTreeToInsert(int a, int b, PRQuadNode node) {
		
		float middleH = (node.getMaxy() + node.getMiny()) /2;
		float middleW = (node.getMaxx() + node.getMinx()) /2;
		
		if (a >= middleW/2)
			return (b >= middleH/2)? node.getNE() : node.getSE();
		else
			return (b >= middleH/2)? node.getNW() : node.getSW();
	}
}
