package com.assignment3;
import mpi.*;
import mpi.MPI;
import java.util.Scanner;
public class ScatterGather{
	public static void main(String[] args) {
		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		int root=0;
		int send_buffer[] = null;
		int unitsize=5;
		send_buffer = new int[unitsize*size];
		int receive_buffer[] = new int[unitsize];
		int new_receive_buffer[] = new int[size];
		if(rank==root) {
			Scanner sc = new Scanner(System.in);
			int total_elements = unitsize*size;
			System.out.println("Enter elements: ");
			for(int i=0;i<total_elements;i++) {
				System.out.println("Enter element " + (i+1) + ": ");
				send_buffer[i] = sc.nextInt();
			}
		}
		MPI.COMM_WORLD.Scatter(send_buffer, 0, unitsize, MPI.INT, receive_buffer, 0, unitsize, MPI.INT, root);
		for(int i=1;i<unitsize;i++) {
			receive_buffer[0] += receive_buffer[i];
		}
		System.out.println("Sum at process " + (rank) + " is " + receive_buffer[0]);
		MPI.COMM_WORLD.Gather(receive_buffer, 0, 1, MPI.INT, new_receive_buffer, 0, 1, MPI.INT, root);
		if(rank==root) {
			int total_sum=0;
			for(int i=0;i<size;i++) {
				total_sum += new_receive_buffer[i];
			}
			System.out.println("Total sum = " + total_sum);
		}
		MPI.Finalize();
	}
}