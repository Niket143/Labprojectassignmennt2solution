package paymoney;

import java.util.Scanner;

public class Transaction {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the no of Denominations : ");
			
			int noOfDenominations = sc.nextInt();
			
			int arr[]= new int[noOfDenominations];
			
			System.out.println("Enter the Denomination Values :");
			
			for(int i=0; i<arr.length;i++) {
				
				arr[i]= sc.nextInt();
				
			}
				
				System.out.println("Enter the payment amount");
				
				int payment = sc.nextInt();
				
				sortArray(arr);
				for(int i=0;i<arr.length;i++) {
					System.out.println(arr[i]);
				}
				
				CountNotes(arr,payment);
		}
			
	}

	private static void CountNotes(int[] arr, int payment) {
		
		int[] notesCounter = new int[arr.length];
			try {			
		for(int i=0; i<arr.length;i++) {
			
			if(payment>=arr[i]) {
				notesCounter[i]= payment/arr[i];
				payment = payment-notesCounter[i] * arr[i];		
				
			}
		}
		if(payment>0) {
			
			System.out.println("your payment amount can not be achieved with the heighest denomination");
		}else {
			
		System.out.println("your Payment denominations will be");
		for(int i=0;i<arr.length;i++) {
			if(notesCounter[i] !=0 ) {
				
				System.out.println(arr[i] + " : " + notesCounter[i]);				
				
			}
		}
		
		}
		}
		
			catch(ArithmeticException e) {
				
					System.out.println("Denomination cannot be zero");
					
			}
			}

	private static void sortArray(int[] arr) {
		for(int i=0;i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i;j++) {
				if(arr[j]<arr[j+1]) {	
				int temp = arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
				
				
				}
			}
		}
		
	}

}