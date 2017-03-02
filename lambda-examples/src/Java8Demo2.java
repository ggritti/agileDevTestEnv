
// This program contains some examples of Java 8 constructs.  Three of the most
// important higher-order functions to understand are map, filter, and reduce.

import java.util.*;
import java.util.stream.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Java8Demo2 {
	public static void main(String[] args) {
		listExample();
//		arraysExample();
//		rangeExample();
//		primesExample();
//		funnyExample();
	}

	// some Java 8 examples using a list of strings
	public static void listExample() {
		//Create an ArrayList
		List<String> words = new ArrayList<String>();
		words.add("mac");
		words.add("and");
		words.add("cheese");
		
		// old fashioned way to print the words
		for (int i = 0; i < words.size(); i++){
			System.out.println(words.get(i) + " ");
		}
		System.out.println();
		
		// Java 5 introduced the foreach loop and Iterable<T> interface
		for (String s : words) {
			System.out.println(s + " ");
		}
		System.out.println();
		
		// Java 8 has a forEach method as part of the Iterable<T> interface
		// The expression is known as a "lambda" (an anonymous function)
		words.stream().forEach(n -> System.out.println(n + " "));
		System.out.println();
		
		// but in Java 8, why use a lambda when you can refer directly to the
		// appropriate function?
		words.stream().forEach(System.out::print);
		System.out.println();
		
		// this isn't correct, you'll complain, because we want to have spaces
		// attached to the output...no problem, introduce a call on map to
		// transform the data before it is printed
		words.stream().map(n -> n + " ").forEach(System.out::print);
		System.out.println();
		
		// obviously these chains of calls can get long, so the convention is
		// to split them across lines after the call on "stream":
	}

}