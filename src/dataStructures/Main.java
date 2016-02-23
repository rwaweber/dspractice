package dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

public class Main {
	public static void print(String x){
		System.out.println(x);
	}
    public static void main(String[] args){
	Node<String> n1 = new Node<String>("Bob", "Construction");
	Node<String> n2 = new Node<String>("Jill", "Engineer");
	Node<String> n3 = new Node<String>("Jan", "Opthamologist");
	Node<String> n4 = new Node<String>("un", "one");
	Node<String> n5 = new Node<String>("du", "two");
	Node<String> n6 = new Node<String>("trois", "three");
	Graph<String> g1 = new Graph<String>();	
	g1.insert(n1);
	g1.insert(n1,n2);
	g1.insert(n1, n3);
	g1.insert(n2, n4);
	g1.insert(n2, n5);
	g1.remove("du");
	g1.insert(n2, n6);
	g1.connect(n4, n5);

	Node<Integer> n01 = new Node<Integer>("whoop", 1);
	Node<Integer> n02 = new Node<Integer>("fank", 2);
	Node<Integer> n03 = new Node<Integer>("fink", 3);
	Node<Integer> n04 = new Node<Integer>("eins", 4);
	Node<Integer> n05 = new Node<Integer>("zwei", 5);
	Node<Integer> n06 = new Node<Integer>("drei", 6);
	Graph<Integer> g2 = new Graph<Integer>();	
	g1.insert(n1);
	g1.insert(n1,n2);
	g1.insert(n1, n3);
	g1.insert(n2, n4);
	g1.insert(n2, n5);
	g1.remove("du");
	g1.insert(n2, n6);
	g1.connect(n4, n5);
		
	System.out.println(g1.toString());
	g2.insert(n01);
	g2.insert(n01, n02);
	g2.insert(n01, n03);
	g2.insert(n01, n04);
	g2.insert(n02, n05);
	g2.insert(n02, n06);
//	find all nodes, whose elements are less than three and sum them
	int sum = g2.network.stream().filter(b -> b.element < 3).mapToInt(b -> b.element).sum();

//	find all nodes, who have greater than 1 neighbors
	List<Node<Integer>> ll2 = g2.network.stream().filter(b -> b.neighbors.size() > 1).collect(Collectors.toList());
       
	print(Integer.toString(23));
	print("Graph Representation");
	print(g2.toString());
	print("Sum of all Values in g2 that are greater than 3: " + sum);
	print("The number of nodes who have fewer than 3 neighbors " + ll2.size());

	print("performance testing!");
	long startTime = System.nanoTime();
	Graph<Integer> g3 = new Graph<Integer>();
	Node<Integer> rnode1 = new Node<Integer>("0", 0);

	for (int i=0; i< 10000; ++i){
		if (g3.network.size() < 1) {
			Node<Integer> n_0 = new Node<Integer>("0", 0);
			g3.insert(n_0);
			Node<Integer> randomNode = g3.retrieve("0");
			rnode1 = randomNode;
		} else {
			Node<Integer> n_1 = new Node<Integer>(Integer.toString(i), i);
			g3.insert(rnode1, n_1);
			rnode1 = n_1;
		}
	}
	long endTime = System.nanoTime();

	long duration = (endTime - startTime)/1000000;
    	print("finished execution in "+duration+" milliseconds");
	print(g3.toString());
    }
}
