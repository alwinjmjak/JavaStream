package com.gubs.java8.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author ALWINSHOBANRAJM
 *
 */
public class StreamSample
{

	public static void main(String[] args)
	{
		workingOfStreamDistinct();
		workingOfStreamFilter();
		workingOfStreamLimit();
		workingOfStreamPeek();
	}

	/**
	 * Stream is mainly used to do aggregate function.
	 * They can do operations on Collections, Arrays, I/O resources.
	 * Here we can see how stream can be used on Collections and Array.
	 */
	private static void workingOfStreamDistinct()
	{
		List<String> sampleList = new ArrayList<String>();
		sampleList.add("Dog");
		sampleList.add("Cat");
		sampleList.add("Baby");
		sampleList.add("Baby");
		sampleList.add("Aero");
		
		/**
		 * Stream always returns a Stream in order to provide input for 
		 * another stream operation i.e,intermediate operations to be performed.
		 */
		Stream<String> distinctValues = sampleList.stream().distinct();
		
		/**
		 * collect method of stream is the final outcome of the stream.
		 * Every method in Stream will return a Stream object 
		 * but Collect method will return the Collection object,or as an Array.
		 */
		List<String> outputValues = distinctValues.collect(Collectors.toList());
		
		Iterator<String> itr = outputValues.iterator();
		System.out.println("Stream Distinct");
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
	
	
	
	
	/**
	 * Stream filter used to limit the number of objects that is being added to the stream 
	 * by lamda expressions or using predicate 
	 */
	private static void workingOfStreamFilter()
	{
		List<String> sampleList = new ArrayList<String>();
		sampleList.add("Dog");
		sampleList.add("Cat");
		sampleList.add("Baby");
		sampleList.add("Baby");
		sampleList.add("Aero");
			
		/**
		 * filter function is used to filter the objects based on the predicate or the expression 
		 * Here I need the list which match only Dog
		 */
		Stream<String> distinctValues = sampleList.stream().filter(a -> a.equalsIgnoreCase("Dog"));
		
		List<String> outputValues = distinctValues.collect(Collectors.toList());
		
		Iterator<String> itr = outputValues.iterator();
		System.out.println("\nStream Filter");
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

	
	/**
	 * stream limit is used to limit the number of objects from the collection data
	 */
	private static void workingOfStreamLimit()
	{
		List<String> sampleList = new ArrayList<String>();
		sampleList.add("Dog");
		sampleList.add("Cat");
		sampleList.add("Baby");
		sampleList.add("Baby");
		sampleList.add("Aero");
		
		/**
		 * I have set the limit to 3 hence stream takes only the first three objects from 
		 * the list
		 */	
		Stream<String> distinctValues = sampleList.stream().limit(3);
		
		List<String> outputValues = distinctValues.collect(Collectors.toList());
		
		Iterator<String> itr = outputValues.iterator();
		System.out.println("\nStream Limit");
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
	

	/**
	 * stream peek is used to view the data which is streamed 
	 * Intermediate action uses the peek function 
	 */
	private static void workingOfStreamPeek()
	{
		List<String> sampleList = new ArrayList<String>();
		sampleList.add("Dog");
		sampleList.add("Cat");
		sampleList.add("Baby");
		sampleList.add("Baby");
		sampleList.add("Aero");
		
		/**
		 * Each and every object is being streamed first checked for containing the character "a"
		 * then collects a distinct elements
		 */	
		System.out.println("\nStream peek");
		sampleList.stream()
				  .filter(e->e.contains("a"))
				  .peek(e -> System.out.println(e))
				  .distinct()
				  .peek(e -> System.out.println(e))
				  .collect(Collectors.toList());
	}	
}
