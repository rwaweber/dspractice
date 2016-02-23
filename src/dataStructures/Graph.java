package dataStructures;

import java.util.ArrayList;

/**
 * A simple, generic, bidirectional graph that uses named nodes as primary identifiers
 * supports insertion, connection, retrieval and removal
 * @author rwaweber
 *
 * @param <T> 
 */
public class Graph<T> {
	ArrayList<Node<T>> network;
	boolean connected;

	//	empty constructor
	public Graph() {
		this.connected = false;
		this.network = new ArrayList<Node<T>>();
	}
	// 	adding an existing lsit of nodes to the graph
	public Graph(ArrayList<Node<T>> nodes){
		this.network = nodes;
	}
	//	inserting an island node into a graph
	public boolean insert(Node<T> insertingNode) {
		//		does this node exist in the graph?
		//		NOTE: Nodes must be added with unique names
		for(int i=0; i<this.network.size(); i++){
			if(this.network.get(i).name == insertingNode.name){
				return false;
			}
		}
		this.network.add(insertingNode);
		return true;
	}
	//	inserting a node and connecting it to an existing node
	public boolean insert(Node<T> existingNode, Node<T> insertingNode) {
		//		does this node exist in the graph?
		//		NOTE: Nodes must be added with unique names
		for(int i=0; i<this.network.size(); i++){
			if(this.network.get(i).name == insertingNode.name){
				return false;
			}
		}
		this.network.add(insertingNode);
		this.connect(existingNode, insertingNode);
		return true;
	}
	// 	connecting an existing node to another existing node
	public boolean connect(Node<T> existingNode, Node<T> insertingNode){
		//			by default graphs are empty
		if (this.connected == false){
			this.connected = true;
		}
		//		cannot connect a node to itself
		if(existingNode.name == insertingNode.name){
			return false;
		}
		//		connect insertingNode to existing node in the graph
		for(int i=0; i<this.network.size(); i++){
			if(this.network.get(i).name == insertingNode.name){
				Node<T> nodeInGraph = this.network.get(i);
				nodeInGraph.neighbors.add(existingNode);
				existingNode.neighbors.add(nodeInGraph);
				return true;
			}
		}
		//		otherwise, connection most likely failed
		return false;
	}
	//	pull a node out from the graph by it's name in O(n) time
	public Node<T> retrieve(String nameOfNode){
		for(int i=0; i<this.network.size(); i++){
			if(this.network.get(i).name == nameOfNode){
				return this.network.get(i);
			}
		}
		return null;	
	}
	//	remove a node from the graph in O(n^m) time
	public boolean remove(String nameOfNode){
		for(int i=0; i<this.network.size(); i++){
			Node<T> topLevelNode = this.network.get(i);
			for (int j=0; j<topLevelNode.neighbors.size(); j++){
				Node<T> interimNode = topLevelNode.neighbors.get(j);
				if(interimNode.name == nameOfNode){
					this.network.remove(i);
				}
//				ensuring that it existed in the network in the first place
				if(topLevelNode.name == nameOfNode){
					this.network.remove(i);
					return true;
				}
			}
		}
		return false;	
	}
	
	//	remove a node from the graph in O(n^m) time
	public boolean remove(Node<T> removeNode){
		for(int i=0; i<this.network.size(); i++){
			Node<T> topLevelNode = this.network.get(i);
			for (int j=0; j<topLevelNode.neighbors.size(); j++){
				Node<T> interimNode = topLevelNode.neighbors.get(j);
				if(interimNode.name == removeNode.name){
					this.network.remove(i);
				}
//				ensuring that it existed in the network in the first place
				if(topLevelNode.name == removeNode.name){
					this.network.remove(i);
					return true;
				}
			}
		}
		return false;	
	}

	//	return a text representation of the graph, not unlike prolog :)
	public String toString(){
		//		mutable string in java
		StringBuilder s = new StringBuilder();
		//		for every node in the network
		for(int i=0; i<this.network.size(); i++){
			Node<T> topLevelNode = this.network.get(i);
			s.append("Node "+ topLevelNode.name+":\n");
			//			for every neighbor of that node
			for (int j=0; j<topLevelNode.neighbors.size(); j++){
				Node<T> interimNode = topLevelNode.neighbors.get(j);
				s.append("\t Is connected to "+interimNode.name+"\n");
			}
		}
		return s.toString();
	}
}
