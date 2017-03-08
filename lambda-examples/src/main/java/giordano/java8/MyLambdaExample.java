package giordano.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyLambdaExample {

	public static void main(String[] args) {

		// applyFilter();
		// applyFunctionsToList();
		// applyTaxesRates();
		createStringFilteredList();
	}

	/**
	 * Applying filter to a list
	 */
	public static void applyFilter() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		System.out.println("Languages which starts with J :");
		filter(languages, (str) -> ((String) str).startsWith("J"));
		System.out.println("Languages which ends with a ");
		filter(languages, (str) -> ((String) str).endsWith("a"));
		System.out.println("Print all languages :");
		filter(languages, (str) -> true);
		System.out.println("Print no language : ");
		filter(languages, (str) -> false);
		System.out.println("Print language whose length greater than 4:");
		filter(languages, (str) -> ((String) str).length() > 4);
	}

	/**
	 * Convert String to Uppercase and join them using comma
	 */
	public static void applyFunctionsToList() {
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(G7Countries);
	}

	/**
	 * Applying 20% VAT on each purchase with lambda expressions:
	 */
	public static void applyTaxesRates() {
		double VAT = .12;
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		costBeforeTax.stream().map((cost) -> cost + cost * VAT).forEach(System.out::println);
	}

	/**
	 * Create a List with String more than 2 characters
	 */
	public static void createStringFilteredList() {
		List<String> strList = Arrays.asList("abc", " ", "bctestd", " ", "defg", "jk");
		List<String> filtered = strList.stream().filter((x) -> x.length() > 2 && x.contains("test"))
				.collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
	}

	/**
	 * Filter utilities
	 * 
	 * @param names
	 * @param condition
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void filter(List names, Predicate condition) {
		names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
			System.out.println(name + " ");
		});

	}

}