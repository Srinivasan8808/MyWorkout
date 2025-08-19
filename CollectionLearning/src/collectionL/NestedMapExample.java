package collectionL;
import java.util.*;

public class NestedMapExample {
	public static void main(String[] args) {
		Map<String,Map<String,Integer>> studentMarks= new HashMap<>();
		Map<String,Integer> mathMarks = new HashMap<>();
		mathMarks.put("john", 90);
		mathMarks.put("Alice", 85);
		
		Map<String,Integer> scienceMarks = new HashMap<>();
		scienceMarks.put("john", 92);
		scienceMarks.put("Alice", 88);
		
		studentMarks.put("Math", mathMarks);
		studentMarks.put("science", scienceMarks);
		
		System.out.println(studentMarks);
		
	}
}
