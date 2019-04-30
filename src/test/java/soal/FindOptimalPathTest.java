package soal;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import app.soal.function.FindingOptimalPath;
import app.soal.model.Edge;
import app.soal.model.Vertices;

public class FindOptimalPathTest {

	Vertices a = new Vertices(1, "A");
	Vertices b = new Vertices(2, "B");
	Vertices c = new Vertices(2, "C");
	Vertices d = new Vertices(5, "D");
	List<Edge> edges = Arrays.asList(new Edge(a, b), new Edge(b, c), new Edge(a, c), new Edge(c, d),
			new Edge(d, a));
	List<Edge> edges2 = Arrays.asList(new Edge(a, b), new Edge(b, c), new Edge(a, c), new Edge(c, d));
	@Test
	public void loopback() {
		FindingOptimalPath findingOptimalPath = new FindingOptimalPath(edges);
		assertEquals(10, findingOptimalPath.getMaxSum());
	}
	
	@Test
	public void normal() {
		FindingOptimalPath findingOptimalPath = new FindingOptimalPath(edges2);
		assertEquals(10, findingOptimalPath.getMaxSum());
	}
	
	@Test
	public void printAll() {
		FindingOptimalPath findingOptimalPath = new FindingOptimalPath(edges);
		findingOptimalPath.printAll();
	}
	
	@Test
	public void printMaxSum() {
		FindingOptimalPath findingOptimalPath = new FindingOptimalPath(edges);
		findingOptimalPath.printMaxSum();
	
	}
}
