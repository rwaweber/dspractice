package dataStructures;

import java.util.ArrayList;

public class Node<T> {
	String name;
	T element;
	ArrayList<Node<T>> neighbors;

	public Node(String name, T internal) {
		this.name = name;
		this.element = internal;
		this.neighbors = new ArrayList<Node<T>>();
	}
}
