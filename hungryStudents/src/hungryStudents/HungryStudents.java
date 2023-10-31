package hungryStudents;

/*
File: HungryStudents.java
Author: Ram Longman
Date: 8/3/2023
Description: find out how many students are left hungry.
*/
import java.util.Stack;
import java.util.LinkedList;

public class HungryStudents {

	public static void main(String[] args) {

		
		HungryStudentsTest();
		
	}
	
	public static int NumHungryStudents(Stack<Integer> sandwiches, LinkedList<Integer> students) {
		//TODO: Implement this method
		
		int hungryStudents = 0;
		
		

	    while (!students.isEmpty()) {
	        int studentPreference = students.poll();
	        
	        if (!sandwiches.isEmpty() && studentPreference == sandwiches.peek()) {
	        	
	        	//everybody goes hungry
	        	System.out.println("student is fed");
	            sandwiches.pop(); // Student got a matching sandwich
	        } 
	        else 
	        {
	            hungryStudents++; // Student is left hungry
	            System.out.println("student is hungry");
	        }
	    }

	    return hungryStudents;
	}
	
	public static void HungryStudentsTest() {
		
		Stack<Integer> sandwiches = new Stack<Integer>();
		LinkedList<Integer> students = new LinkedList<Integer>();
		//test 1- everyone find their match. No one is hungry.
		sandwiches.push(0);
		sandwiches.push(1);
		sandwiches.push(1);
		sandwiches.push(0);
		
		students.add(0);
		students.add(1);
		students.add(1);
		students.add(0);
		
		assert NumHungryStudents(sandwiches, students) == 0;
		System.out.println();
		students.clear();
		sandwiches.clear();
		
		//test 2- no one wants the top sandwich, everyone is left hungry.
		sandwiches.push(1);
		sandwiches.push(1);
		sandwiches.push(0);
		
		students.add(1);
		students.add(1);
		students.add(1);
		
		assert NumHungryStudents(sandwiches, students) == 3;
		System.out.println();
		students.clear();
		sandwiches.clear();
		
		//test 3- last student doesn't want the last sandwich.
		sandwiches.push(0);
		sandwiches.push(1);
		sandwiches.push(0);
		
		students.add(0);
		students.add(1);
		students.add(1);
		
		assert NumHungryStudents(sandwiches, students) == 1;
		System.out.println();
		students.clear();
		sandwiches.clear();
		
		//test 4- extra sandwich
		sandwiches.push(1);
		sandwiches.push(1);
		sandwiches.push(0);
		sandwiches.push(0);
		
		students.add(0);
		students.add(0);
		students.add(1);
		
		assert NumHungryStudents(sandwiches, students) == 0;
		System.out.println();
		students.clear();
		sandwiches.clear();
		
		//test 5- not enough sandwiches
		sandwiches.push(1);
		sandwiches.push(0);
		sandwiches.push(1);
		
		students.add(1);
		students.add(0);
		students.add(1);
		students.add(0);
		students.add(1);
		
		assert NumHungryStudents(sandwiches, students) == 2;
		System.out.println();
		
		System.out.println("Test Successful!");
	}

}

