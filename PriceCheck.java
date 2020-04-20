package org.cap.pricecheck;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PriceCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		int noOfProducts= sc.nextInt();
		String products[]=new String[noOfProducts];
		for(int i=0; i<noOfProducts; i++)
			products[i]=sc.next();
		int noOfPrices= sc.nextInt();
		String prices[] = new String[noOfPrices];
		for(int i=0; i<noOfPrices; i++)
			prices[i]=sc.next();
		int noOfProductSold= sc.nextInt();
		String productsSold[] = new String[noOfProductSold];
		for(int i=0; i<noOfProductSold; i++)
			productsSold[i]=sc.next();
		int noOfSoldPrice= sc.nextInt();
		float soldPrice[] = new float[noOfSoldPrice];
		for(int i=0; i<noOfSoldPrice; i++)
			soldPrice[i]=sc.nextFloat();
		
		int result=priceCheck(products, prices, productsSold, soldPrice);
		System.out.println(result);
	}
	
	
	static int priceCheck(String products[], String prices[], String productSold[], float soldPrice[]) {
		Map<String, String> saleRecord = IntStream.range(0, products.length).boxed()
			    .collect(Collectors.toMap(i -> products[i], i -> prices[i]));
		System.out.println(saleRecord); 
		Map<String, Float> saleEnetered = IntStream.range(0, productSold.length).boxed()
			    .collect(Collectors.toMap(i -> productSold[i], i -> soldPrice[i]));
		System.out.println(saleEnetered); 
		int count=0;
		for(int i=0; i<productSold.length;i++) {
			if(saleRecord.containsKey(productSold[i])) {
				String price= saleRecord.get(productSold[i]);
				float sold=saleEnetered.get(productSold[i]);
				if(!Float.valueOf(price).equals(sold))
					count++;
			}
		}
		return count;
	}

}
