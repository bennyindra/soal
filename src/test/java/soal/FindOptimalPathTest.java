package soal;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.soal.function.FindingOptimalPath;
import app.soal.model.Edge;
import app.soal.model.Vertices;

public class FindOptimalPathTest {
	
	private final ByteArrayOutputStream outcontent = new ByteArrayOutputStream();
	private final PrintStream original = System.out;

	private Vertices a;
	private Vertices b;
	private Vertices c;
	private Vertices d;
	private List<Edge> recursiveEdges;
	private List<Edge> normalEdges;
	
	private String resultRecursive = "A->B->C->D-> = 10B->C->D->A-> = 10A->C->D-> = 8C->D->A->B-> = 10D->A->B->C-> = 10";
	private String resultMaxSum = "A->B->C->D-> = 10";
	
	@Before
	public void before(){
		System.setOut(new PrintStream(outcontent));
		
		a = new Vertices(1, "A");
		b = new Vertices(2, "B");
		c = new Vertices(2, "C");
		d = new Vertices(5, "D");
		
		recursiveEdges = Arrays.asList(new Edge(a, b), new Edge(b, c), new Edge(a, c), new Edge(c, d),new Edge(d, a));
		normalEdges = Arrays.asList(new Edge(a, b), new Edge(b, c), new Edge(a, c), new Edge(c, d));
		
		
	}
	
	
	@After
	public void after() {
		System.setOut(original);
	}
	
	@Test
	public void testLoopback() {
		FindingOptimalPath findingOptimalPath = new FindingOptimalPath(recursiveEdges);
		assertEquals(10, findingOptimalPath.getMaxSum());
	}
	
	@Test
	public void testNormal() {
		FindingOptimalPath findingOptimalPath = new FindingOptimalPath(normalEdges);
		assertEquals(10, findingOptimalPath.getMaxSum());
	}
	
	@Test
	public void testPrintAll() {
		FindingOptimalPath findingOptimalPath = new FindingOptimalPath(recursiveEdges);
		findingOptimalPath.printAll();
		assertEquals(resultRecursive, outcontent.toString());
	}
	
	@Test
	public void testPrintMaxSum() {
		FindingOptimalPath findingOptimalPath = new FindingOptimalPath(recursiveEdges);
		findingOptimalPath.printMaxSum();
		assertEquals(resultMaxSum, outcontent.toString());
	}
}
