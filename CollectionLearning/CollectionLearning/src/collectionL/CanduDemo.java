package collectionL;

import java.util.*;
import java.util.stream.Collectors;

public class CanduDemo {
	public static void main(String[] args) {
		List<Candy> candies=new ArrayList<>();
		candies.add(new Candy("Chocolate",8));
		candies.add(new Candy("Purfi",6));
		candies.add(new Candy("Candy cane",7));
		candies.add(new Candy("Waffel",5));
		
		System.out.println("ALL CANDIES");
		candies.forEach(System.out::println);
		
		List<Candy> sortedCandies=candies.stream()
				.sorted(Comparator.comparingInt(c -> c.sweetness))
				.collect(Collectors.toList());
		System.out.println("/n Candies are sorted by sweetness");
		sortedCandies.forEach(System.out::println);
		
		List<Candy> sweetCandies = candies.stream()
                .filter(c -> c.sweetness > 6)
                .collect(Collectors.toList());
		
		System.out.println("\nCandies with sweetness > 6:");
        sweetCandies.forEach(System.out::println);
		
	}
}
