package org.cap.DevTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DevTeam {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		   
		int row, col, r, result;
	    row = scan.nextInt();
	    col = scan.nextInt();
	    int arr[][] = new int[row][col];

	    List<List<Integer>> teams= new ArrayList<>();
	    for(int i=0; i<row; i++)
	    {
            ArrayList<Integer> list= new ArrayList<Integer>();
	        for(int j=0; j<col; j++)
	        {
	        	list.add(scan.nextInt());
	        }
            teams.add(list);
	    }
	    r= scan.nextInt();
	    for(List list:teams) {
	    	System.out.println(list.get(0)+" "+list.get(1));
	    }
	   
	    result=devTeam(teams, r);
	    System.out.println(result);
	}
	
	public static int devTeam(List<List<Integer>> teams, int r) {
		int totalThreshold=0,count=0;
		for(List list:teams) {
			int dev=(int)list.get(0);
			int team= (int)list.get(1);
			int percentage=(dev*100)/team;
			System.out.println(percentage+"---p");
			while(percentage!=r) {
				percentage=((dev+1)*100)/(team+1);
				System.out.println(percentage+" while");
				count++;
				dev++;
				team++;
			}
			totalThreshold+=percentage;
			System.out.println(totalThreshold);
		}
		if(totalThreshold/teams.size()==r)
			return count;
		return count;
	}

}
