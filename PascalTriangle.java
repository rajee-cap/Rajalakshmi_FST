package org.cap.numerology;

import java.util.Scanner;

public class PascalTriangle {

    static int fact(int num) {
	int factorial;

	for(factorial = 1; num > 1; num--){
		factorial *= num;
	}
	return factorial;
    }
    static int ncr(int n,int r) {
	return fact(n) / ( fact(n-r) * fact(r) );
    }
    public static void main(String args[]){
	int rows, i, j,result = 1;

	System.out.println("Enter number of rows:");
	Scanner scanner = new Scanner(System.in);
	rows = scanner.nextInt();
	System.out.println("Enter co-ordinates:");
	int x=scanner.nextInt();
	int y=scanner.nextInt();

	System.out.println("Pascal Triangle:");
	for(i = 0; i < rows; i++) {
		for(j = 0; j <= i; j++){
			if(i==x-1 && j==y-1)
				result=ncr(i,j);
			System.out.print(" "+ncr(i, j));
		}
		System.out.println();
 	}
	System.out.println(result);
    }
   
}
