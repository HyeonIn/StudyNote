package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int[] S = new int[L];
		int count = 0;
		
		for (int i = 0; i < S.length; i++) {
			S[i] = sc.nextInt();
		}
		Arrays.sort(S);
		
		int n = sc.nextInt();
		int a = 0;
		int b = 0;
		
		
		for (int i = 0; i < L-1; i++) {
			if (S[i] < n) {
				if (S[i+1] > n) {
					a = S[i]+1;
					b = S[i+1]-1;					
				}
			}else if(S[i] > n) { //집합의 첫번째 원소보다 n이 작을 때
				if (i == 0) {
					a = 1;
					b = S[i] - 1;
				}
			}
		}
		if (S[L-1] < n) { //집합의 마지막 원소보다 n이 클 때
			a = S[L-1]+1;
			b = 1000;
		}
		int ntob = b-n;
		
		if (a != 0 && b != 0) {

			count += ntob;
			for (int i = a; i < n; i++) {
				count += ntob+1;
			}
			
		}
				
		System.out.println(count);
		
	}
}
