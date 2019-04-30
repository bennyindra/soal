package app.soal.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import app.soal.model.Edge;
import app.soal.model.Vertices;

public class FindingOptimalPath {

	List<LinkedHashSet<Vertices>> list = new ArrayList<>();
	public FindingOptimalPath(List<Edge> edges) {
		for (Edge edge : edges) {
			LinkedHashSet <Vertices> resVer = new LinkedHashSet<>();
			Set<Edge> exceptions = new HashSet<>();
			loop(edges, edge, resVer,exceptions);
			exceptions.add(edge);
			list.add(resVer);
		}
	}
	
	public void printAll() {
		for (LinkedHashSet<Vertices> set : list) {
			int i = 0;
			for (Vertices vertices : set) {
				System.out.print(vertices.getCode()+"->");
				i+=vertices.getWeight();
			}
			System.out.println(" = "+i);
		}
	}
	
	public void printMaxSum() {
		Collections.sort(list, new Comparator<LinkedHashSet<Vertices>>() {
	        @Override
	        public int compare(LinkedHashSet<Vertices> h1, LinkedHashSet<Vertices> h2) {
	        	int i = 0;
	        	for (Vertices vertices : h1) {
					i+=vertices.getWeight();
				}
	        	int x = 0;
	        	for (Vertices vertices : h2) {

					x+=vertices.getWeight();
				}
				return i<x?i:x;
	        }
	    });
		
		int i = 0;
		for (Vertices vertices : list.get(0)) {
			System.out.print(vertices.getCode()+"->");
			i+=vertices.getWeight();
		}
		System.out.println(" = "+i);
	}
	
	public int getMaxSum() {
		Collections.sort(list, new Comparator<LinkedHashSet<Vertices>>() {
	        @Override
	        public int compare(LinkedHashSet<Vertices> h1, LinkedHashSet<Vertices> h2) {
	        	int i = 0;
	        	for (Vertices vertices : h1) {
					i+=vertices.getWeight();
				}
	        	int x = 0;
	        	for (Vertices vertices : h2) {

					x+=vertices.getWeight();
				}
				return i<x?i:x;
	        }
	    });
		int i = 0;
		for (Vertices vertices : list.get(0)) {
			i+=vertices.getWeight();
		}
		return i;
	}
	
	private List<Edge> getNextEdge(List<Edge> edges, Edge edge, Set<Edge> exceptions) {
		List<Edge> results = new ArrayList<>();
		for (Edge e : edges) {
			if (e.getSource().equals(edge.getDest()) && !exceptions.contains(e)) {
				results.add(e);
			}
		}
		return results;
	}
	
	private void loop(List<Edge> edges,Edge e,LinkedHashSet<Vertices> resVer,Set<Edge> exceptions) {
		resVer.add(e!=null?e.getSource():null);
		resVer.add(e!=null?e.getDest():null);
		
		List<Edge> list = getNextEdge(edges, e, exceptions);
		for (Edge edge : list) {
			if (edge.getDest()!=null&& !resVer.contains(edge.getDest())) {
				loop(edges, edge, resVer, exceptions);
			}
		}
	}
	
}
