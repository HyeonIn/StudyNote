package boj;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[] cables = new int[k];
		long max = 0;
		
		for (int i = 0; i < k; i++) {
			cables[i] = sc.nextInt();
			if (max < cables[i]) {
				max = cables[i];
			}
		}
		long start = 0;
		long mid = 0;
		long end = max+1;
		while(start < end) {
			mid = (start+end) / 2; 
			
			long count = 0;
			
			for (int i = 0; i < k; i++) {
				count += cables[i] / mid; 
			}
			if (count < n) {
				end = mid;
			}
			else {
				start = mid+1;
			}
		}
		System.out.println(start-1);
		
	}
}
