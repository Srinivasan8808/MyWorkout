package collectionL;

import java.util.*;
import java.util.stream.Collectors;



class Student {
    String name;
    String dept;
    Student(String n, String d)
    {
    	name = n;
    	dept = d; 
    }
    public String toString() 
    {
    	return name + " (" + dept + ")"; 
    }
}

public class GroupingExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", "CS"),
            new Student("Bob", "IT"),
            new Student("Charlie", "CS"),
            new Student("David", "IT"),
            new Student("Eva", "ECE")
        );

        Map<String, List<Student>> grouped = students.stream()
            .collect(Collectors.groupingBy(s -> s.dept));

        grouped.forEach((dept, list) -> {
            System.out.println(dept + ": " + list);
        });
        
        List<String> words = Arrays.asList("apple", "bat", "ball", "cat", "dog", "elephant");

        Map<Integer, List<String>> groupedByLength = words.stream()
            .collect(Collectors.groupingBy(String::length));

        groupedByLength.forEach((length, list) -> 
            System.out.println("Length " + length + " -> " + list));
    }
}
