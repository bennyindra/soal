package app.soal.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.soal.function.DataStoreAndLoad;
import app.soal.function.FindingOptimalPath;
import app.soal.model.Affiliate;
import app.soal.model.Bill;
import app.soal.model.BillSummary;
import app.soal.model.Edge;
import app.soal.model.Vertices;

public class Main {

	public static void main(String[] args) {
		if (args.length != 0 && args[0] != null) {
			if (args[0].equals("1")) {
				System.out.println(DataStoreAndLoad.store(DataStoreAndLoad.sampleDataArray()));
				System.out.println(DataStoreAndLoad.load(DataStoreAndLoad.store(DataStoreAndLoad.sampleDataArray())));
			} else if (args[0].equals("2")) {
				Vertices a = new Vertices(1, "A");
				Vertices b = new Vertices(2, "B");
				Vertices c = new Vertices(2, "C");
				Vertices d = new Vertices(5, "D");
				List<Edge> edges = Arrays.asList(new Edge(a, b), new Edge(b, c), new Edge(a, c), new Edge(c, d),
						new Edge(d, a));

				FindingOptimalPath findingOptimalPath = new FindingOptimalPath(edges);
				findingOptimalPath.printAll();
				findingOptimalPath.printMaxSum();
				System.out.println("max Sum = " + findingOptimalPath.getMaxSum());
			} else if (args[0].equals("3")) {
				Affiliate affiliate = null;
				try {
					affiliate = new Affiliate("BEN", new SimpleDateFormat("ddMMyyyy").parse("01012010"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<Bill> bills = new ArrayList<>();
				for (Double i = 10d; i < 150d; i+=10d) {
					Bill bill = new Bill(affiliate, i);
					bills.add(bill);
				}
				
				BillSummary billSummary = new BillSummary(bills);
				System.out.println(billSummary.netPrice());
			
			} else {
				System.out.println("wrong argument!!!, please put arguments '1' or '2' or '3' of test subject");
			}
		} else {
			System.out.println("wrong argument!!!, please put arguments '1' or '2' or '3' of test subject");
		}

	}

}
