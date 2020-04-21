package org.cap.numerology;

public class ShortestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] myArray = { {1,2,3,4},{0,2,7},{4,12},{1,2,5,6}};

		int shortestIndex = 0;

		for( int i=1; i< myArray.length; i++){
		    if(myArray[shortestIndex].length > myArray[i].length)
		        shortestIndex = i;
		}
		int length=myArray[shortestIndex].length;
		System.out.println("Shortest array:");
		for (int i = 0; i < 1; i++) { 
            for (int j = 0; j < length; j++) { 
                System.out.print(myArray[shortestIndex][j] + " "); 
            } 
            System.out.println();
        } 
		System.out.println("Length :"+length);
		

	}

}
