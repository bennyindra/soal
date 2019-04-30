package app.soal.model;

import java.util.List;

public class Edge {
	private Vertices dest, source;

	public Edge(Vertices source, Vertices dest) {
		this.source = source;
		this.dest = dest;
	}

	public Vertices getDest() {
		return dest;
	}

	public void setDest(Vertices dest) {
		this.dest = dest;
	}

	public Vertices getSource() {
		return source;
	}

	public void setSource(Vertices source) {
		this.source = source;
	}

	public Edge checkDestinationInList(List<Edge> edges) {
		if (dest!=null) {
			for (Edge edge : edges) {
				if (edge.getSource().equals(getDest())) {
					return edge;
				}
			}
		} 
		return null;
	}
}
