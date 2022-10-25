package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static boolean check(int[] arr1, int[] arr2) {
		for (int i = 0; i < N; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	public static void opposit(int[] arr, int idx) {
		if (arr[idx] == 0) {
			arr[idx] = 1;
		}
		else {
			arr[idx] = 0;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		
		N = Integer.parseInt(br.readLine()); 
		
		char[] t1 = br.readLine().toCharArray();
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		for (int i = 0; i < N; i++) {
			arr1[i] = t1[i] -'0';
			arr2[i] = t1[i] -'0';
		}
		char[] t2 = br.readLine().toCharArray();
		int[] arr3 = new int[N];
		for (int i = 0; i < N; i++) {
			arr3[i] = t2[i] -'0';
		}
		if (N == 2) {
			int c = 0;
			for (int i = 0; i < 2; i++) {
				if (arr1[i] != arr3[i]) {
					c++;
				}
			}
			if (c == 0) {
				System.out.println(0);
			}
			else if (c == 1) {
				System.out.println(-1);
			}
			else {
				System.out.println(1);
			}
		}
		else {
			
			if (check(arr1, arr3)) {
				System.out.println(0);
			}
			else {
				int min = Integer.MAX_VALUE;
				
				boolean checkA = false;
				int count = 1;
				opposit(arr1, 0);
				opposit(arr1, 1);
				for (int i = 1; i < N; i++) {
					if (arr1[i-1] != arr3[i-1]) {
						count++;
						opposit(arr1, i-1);
						opposit(arr1, i);
						if (i < N-1) {
							opposit(arr1, i+1);
						}
					}
				}
				if (check(arr1, arr3)) {
					checkA = true;
					min = Integer.min(count, min);
				}
				count = 0;
				for (int i = 1; i < N; i++) {
					if (arr2[i-1] != arr3[i-1]) {
						count++;
						opposit(arr2, i-1);
						opposit(arr2, i);
						if (i < N-1) {
							opposit(arr2, i+1);
						}
					}
				}
				if (check(arr2, arr3)) {
					checkA = true;
					min = Integer.min(count, min);
				}
				
				System.out.println(checkA?min:-1);
			}
		}
	}
}
