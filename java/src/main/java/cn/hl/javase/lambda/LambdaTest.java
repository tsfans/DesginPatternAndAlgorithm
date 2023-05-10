package cn.hl.javase.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JButton;

/**
 * @author HULIN
 */
public class LambdaTest {

	/**
	 * 用lambda表达式实现Runnable
	 */
	public static void runnableImpl() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Before java8,too much code for too little to do!");
			}
		}).start();
		
		new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
	}
	
	/**
	 * 使用Java 8 lambda表达式进行事件处理
	 */
	public static void actionListener() {
		new JButton("show").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Event handling without lambda expression is boring");
			}
		});
		new JButton("show").addActionListener(e -> System.out.println("Lambda expressioon is good!"));
		
	}
	
	/**
	 * 实现comparator
	 */
	public static void compare() {
		Integer[] array = {2,5,1,8,1,33,2,6,-3,0,1};
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
		Collections.sort(list, (a,b) -> a-b);
		for(Integer i:list) {
			System.out.println(i);
		}
	}
	
	/**
	 * 使用lambda表达式对列表进行迭代
	 */
	public static void foreach() {
		List<String> list = new ArrayList<String>(Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API"));
		for(String str:list) {
			System.out.println(str);
		}
		list.forEach(System.out::println);
	}
	
	/**
	 * 使用lambda表达式和函数式接口Predicate
	 */
	public static void predicate() {
		List<String> languages = new ArrayList<String>(Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp"));
		System.out.println("Languages which starts with J :");
	    filter(languages, (str)->str.startsWith("J"));
	 
	    System.out.println("Languages which ends with a ");
	    filter(languages, (str)->str.endsWith("a"));
	 
	    System.out.println("Print all languages :");
	    filter(languages, (str)->true);
	 
	    System.out.println("Print no language : ");
	    filter(languages, (str)->false);
	 
	    System.out.println("Print language whose length greater than 4:");
	    filter(languages, (str)->str.length() > 4);
	    Predicate<String> startWithJ = str -> str.startsWith("J");
	    Predicate<String> fourLetterLong = str -> str.length()==4;
	    languages.stream().filter(startWithJ.and(fourLetterLong)).forEach(name -> System.out.println("nName, which starts with 'J' and four letter long is :"+name));
	    
	}
	public static void filter(List<String> names,Predicate<String> condition) {
//		for(String name:names) {
//			if(condition.test(name)) {
//				System.out.println(name+" ");
//			}
//		}
		names.stream().filter(name -> condition.test(name)).forEach(System.out::println);
	}
	
	/**
	 * Java 8中使用lambda表达式的Map和Reduce示例
	 */
	public static void map() {
		// 不使用lambda表达式为每个订单加上12%的税
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for(Integer cost:costBeforeTax) {
			double price = cost + .12*cost;
			System.out.println("price:"+price);
		}
		// 使用lambda表达式
		List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
		costBeforeTax2.stream().map(cost -> cost+.12*cost).forEach(System.out::println);
	}
	
	public static void reduce() {
		// 不使用lambda表达式为每个订单加上12%的税
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for(Integer cost:costBeforeTax) {
			double price = cost + .12*cost;
			total = total + price;
		}
		System.out.println("total:"+total);
		// 使用lambda表达式
		List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
		double bill = costBeforeTax2.stream().map(cost -> cost+.12*cost).reduce((sum, cost) -> sum+cost).get();
		System.out.println("bill:"+bill);
	}
	
	/**
	 * 通过过滤创建一个String列表
	 */
	public static void strList() {
		List<String> strs = new ArrayList<String>(Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp"));
		List<String> filterStr = strs.stream().filter(s -> s.length()>4).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strs, filterStr);
	}
	
	/**
	 * 对列表的每个元素应用函数
	 */
	public static void funOnList() {
		// 将字符串换成大写并用逗号链接起来
		List<String> G8 = Arrays.asList("China","USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		String g8 = G8.stream().map(s -> s.toLowerCase()).collect(Collectors.joining(", "));
		System.out.println(g8);
	}
	
	/**
	 * 复制不同的值，创建一个子列表
	 */
	public static void distinct() {
		// 用所有不同的数字创建一个正方形列表
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		String distinct = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList()).stream().map(i -> i+"").collect(Collectors.joining(", "));
		System.out.printf("Original List : %s, filtered list : %s %n", numbers, distinct);
	}
	
	/**
	 * 计算集合元素的最大值、最小值、总和以及平均值
	 */
	public static void summary() {
		//获取数字的个数、最小值、最大值、总和以及平均值
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics statistics = primes.stream().mapToInt(i -> i).summaryStatistics();
		System.out.println("Highest prime number in List : " + statistics.getMax());
		System.out.println("Lowest prime number in List : " + statistics.getMin());
		System.out.println("Sum of all prime numbers : " + statistics.getSum());
		System.out.println("Average of all prime numbers : " + statistics.getAverage());
	}
	
	public static void main(String[] args) {
		summary();
	}
}
