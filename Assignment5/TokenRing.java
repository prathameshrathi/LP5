package com.assignment5;

import java.util.Scanner;

public class TokenRing{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes: ");
		int n = sc.nextInt();
		int token=0;
		boolean flag=true;
		for (int i = 0; i < n; i++) {
	       System.out.print(" " + i);
	    }
		      System.out.println(" " + 0);
		while(flag) {
			System.out.println("********************");
			System.out.println("Enter the sender: ");
			int s = sc.nextInt();
			System.out.println("Enter the receiver: ");
			int r = sc.nextInt();
			System.out.println("Enter the message: ");
			sc.nextLine();
			String str = sc.nextLine();
			System.out.println("\nToken passing: ");
			for(int i=token;i!=s;i=(i+1)%n) {
				System.out.print(" " + i + "->");
			}
			System.out.println(" " + s);
			System.out.println("Sender " + s + " sending data: " + str);
			for(int i=s+1;i!=r;i=(i+1)%n) {
				System.out.println("Data " + str + " forwarded by " + i%n);
			}
			System.out.println("Receiver " + r + " received the data");
			token = s;
			System.out.println("********************");
			System.out.println("\nPress 4 to exit!!");
			int opt = sc.nextInt();
			if(opt==4)
				flag=false;
		}
	}
}