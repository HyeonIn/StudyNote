package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		int count = 0;
		System.out.print("<");
		while (!q.isEmpty()) {
			int temp = q.poll();
			if (count++ < k-1) {
				q.add(temp);
			}
			else {
				if (q.size() == 0) {
					System.out.print(temp);
				}
				else {
					System.out.print(temp+", ");
				}
				count = 0;
			}
			
		}
		System.out.println(">");
	}
}