import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

class TestData {
	private List<Integer> A;
	private int S;

	public TestData(List<Integer> A, int S) {
		this.A = A;
		this.S = S;
	}

	public List<Integer> getNumbers() {
		return A;
	}

	public int getS() {
		return S;
	}
}

public class TestCases {

	public static TestData case1() {
		List<Integer> A = List.of(1, 4, 6);
		int S = 2;
		return new TestData(A, S);
	}

	public static TestData case2() {
		List<Integer> A = List.of(1, -4, 6);
		int S = 7;
		return new TestData(A, S);
	}

	public static TestData case3() {
		List<Integer> A = List.of(1, 4, -6, 2, 2, 0, 1);
		int S = 5;
		return new TestData(A, S);
	}

	public static TestData case4() {
		// Not robust!
		try (BufferedReader br = new BufferedReader(new FileReader("testcaseL.txt"))) {
			String Astr = br.readLine().trim();
			Astr = Astr.substring(3, Astr.length() - 1);
			String[] Alst = Astr.split(",");
			int[] AA = Arrays.stream(Alst).mapToInt(Integer::parseInt).toArray();
			List<Integer> A = new ArrayList<>();
			for (int a : AA) 
				A.add(a);

			br.readLine();
			
			String Sstr = br.readLine().trim();
			int S = Integer.parseInt(Sstr.substring(3, Sstr.length()));

			return new TestData(A, S);
		}
		catch (IOException ioe) {
			System.err.println("An IOException occured: " + ioe.getMessage());
		}
		return null;
	}
}
