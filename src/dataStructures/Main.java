package dataStructures;

public class Main {
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
		System.out.println(g1.toString());
	}
}
