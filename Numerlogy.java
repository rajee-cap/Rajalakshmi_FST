package org.cap.numerology;

import java.util.HashMap;
import java.util.Scanner;

public class Numerlogy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Character, Integer> map= new HashMap<Character, Integer>();
		map.put('A',1);
		map.put('I',1);
		map.put('J',1);
		map.put('Q',1);
		map.put('Y',1);
		map.put('B',2);
		map.put('K',2);
		map.put('R',2);
		map.put('C',3);
		map.put('G',3);
		map.put('L',3);
		map.put('S',3);
		map.put('D',4);
		map.put('M',4);
		map.put('T',4);
		map.put('E',5);
		map.put('H',5);
		map.put('N',5);
		map.put('X',5);
		map.put('U',6);
		map.put('V',6);
		map.put('W',6);
		map.put('O',7);
		map.put('Z',7);
		map.put('F',8);
		map.put('P',8);
		
		Scanner sc= new Scanner(System.in);
		String name= sc.next();
		char[] ch= name.toUpperCase().toCharArray();
		int result=0,sum;
		for(int i=0;i<ch.length;i++) {
			result+=map.get(ch[i]);
		}
		
//		System.out.println(getSum(result));
		
		int[][] myArray = { {1,2,3,4},{0,2,7},{4,12},{1,2,5,6}};

		int shortestIndex = 0;

		for( int i=1; i< myArray.length; i++){
		    if(myArray[shortestIndex].length > myArray[i].length)
		        shortestIndex = i;
		}
		for(int i=0;i<myArray[shortestIndex].length;i++)
		System.out.println(myArray[shortestIndex][i]);
		
	}

		static int getSum(int result) { 
			int sum;
			for (sum = 0; result > 0; sum += result % 10, result /= 10); 
			return sum; 
		}

}
