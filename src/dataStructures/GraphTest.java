/**
 * 
 */
package dataStructures;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author demos
 *
 */
public class GraphTest {
	
	Graph<String> g = new Graph<String>();

	/**
	 * Test method for {@link dataStructures.Graph#Graph(java.util.ArrayList)}.
	 */
	@Test
	public void testGraphArrayListOfNodeOfT() {
		Node<String> n1 = new Node<String>("001", "tangerine");
		Node<String> n2 = new Node<String>("002", "tomato");
		Node<String> n3 = new Node<String>("003", "orange");
		ArrayList<Node<String>> l1 = new ArrayList<Node<String>>();
		l1.add(n1);
		l1.add(n2);
		l1.add(n3);
		Graph<String> g2 = new Graph<String>(l1);
		assertEquals(g2.network.size(), 3);
	}

	/**
	 * Test method for {@link dataStructures.Graph#insert(dataStructures.Node)}.
	 */
	@Test
	public void testInsertNodeOfT() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link dataStructures.Graph#insert(dataStructures.Node, dataStructures.Node)}.
	 */
	@Test
	public void testInsertNodeOfTNodeOfT() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link dataStructures.Graph#connect(dataStructures.Node, dataStructures.Node)}.
	 */
	@Test
	public void testConnect() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link dataStructures.Graph#retrieve(java.lang.String)}.
	 */
	@Test
	public void testRetrieve() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link dataStructures.Graph#remove(java.lang.String)}.
	 */
	@Test
	public void testRemoveString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link dataStructures.Graph#remove(dataStructures.Node)}.
	 */
	@Test
	public void testRemoveNodeOfT() {
		fail("Not yet implemented");
	}

}
