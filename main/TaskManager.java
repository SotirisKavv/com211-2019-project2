package main;

import java.util.Random;

import searchTrees.kdTree.KDTree;
import searchTrees.prquadTree.QuadTree;

public class TaskManager {
	
	public int[][] arrayGenerator(int size, int depth, int upperLimit){
		int[][] temp = new int[size][depth]; 
		
		for (int j = 0; j < size; j++) {
			for (int l = 0; l < depth; l++) {
				temp[j][l] = (new Random()).nextInt(upperLimit)+1;
			}
		}
		return temp;
	}
	
	public void initializeKDTree(int elements, KDTree tree, int[][] temp) {
		for (int j = 0; j < elements; j++) {
			tree.insert(temp[j][0], temp[j][1]);
		}
	}
	
	public void initializeQuadTree(int elements, QuadTree tree, int[][] temp) {
 		for (int j = 0; j < elements; j++) {
			tree.insert(temp[j][0], temp[j][1]);
		}
	}
}
