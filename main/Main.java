package main;

import java.util.Random;

import searchTrees.kdTree.*;
import searchTrees.prquadTree.QuadTree;

public class Main {
	
	public final static int k = 2;
	public final static int keys = 100;
	public final static double n = Math.pow(k, 16);
	public final static int[] m = {1000, 10000, 30000, 50000, 70000, 100000};
	
	public static void main(String[] args) {
		
		int sucSearch=0, failSearch=0;
		TaskManager tm = new TaskManager();
				
		System.out.println("In KD Tree:");
		for(int i = 0 ; i < m.length; i++) {
			
			KDTree kd = new KDTree(k);
			int[][] temp = tm.arrayGenerator(m[i], k, (int)n);
			int[][] test = testArray(keys, temp);
			
			tm.initializeKDTree(m[i], kd, temp);
			
			for (int j = 0; j < test.length; j++ ) {
				if (kd.search(test[j][0], test[j][1])) {
					sucSearch += KDTree.comparisons;
				} else {
					failSearch += KDTree.comparisons;
				}
				KDTree.comparisons = 0;
			}
			
			float sucRatio = (float) sucSearch / (float) keys;
			float failRatio = (float) failSearch / (float) keys;
			
			System.out.println("\t#elements: "+m[i]+
					"\n\t\t#comparisons when succesful ratio: "+sucRatio+
					"\n\t\t#comparisons when failed ratio: "+failRatio);
			System.out.println("");
			
			failSearch=0;	sucSearch=0;
		}
		
		System.out.println("In PR QuadTree:");
		for(int i = 0 ; i < m.length; i++) {
			
			int[][] temp = tm.arrayGenerator(m[i], k, (int)n);
			int[][] test = testArray(keys, temp);
			
			QuadTree quad = new QuadTree(0, (int) n, 0, (int) n);
			
			tm.initializeQuadTree(m[i], quad, temp);
			
			for (int j = 0; j < test.length; j++ ) {
				if (quad.search(test[j][0], test[j][1])) {
					sucSearch += QuadTree.comparisons;
				} else {
					failSearch += QuadTree.comparisons;
				}
				QuadTree.comparisons = 0;
			}
			
			float sucRatio = (float) sucSearch / (float) keys;
			float failRatio = (float) failSearch / (float) keys;
			
			System.out.println("\t#elements: "+m[i]+
					"\n\t\t#comparisons when succesful ratio: "+sucRatio+
					"\n\t\t#comparisons when failed ratio: "+failRatio);
			System.out.println("");
			failSearch=0;	sucSearch=0;
		}		
		
	}
	
	public static int[][] testArray(int keys, int[][] array){
		int[][] values = new int[2*keys][k];
		for(int i=0; i<keys; i++) {
			values[i] = array[(new Random()).nextInt(array.length-1)];
		}
		for (int i=keys; i<2*keys; i++) {
			for (int j=0; j<k; j++)
			values[i][j]= (new Random()).nextInt((int) n);
		}
		return values;
	}
	
	public static void testSearch(QuadTree tree) {
		
		if(tree.search(40, 45))
			System.out.println("Found");
		else
			System.out.println("Not Found");
		
		if(tree.search(80,90))
			System.out.println("Found");
		else
			System.out.println("Not Found");
		
		if(tree.search(100,67))
			System.out.println("Found");
		else
			System.out.println("Not Found");
	}

}
