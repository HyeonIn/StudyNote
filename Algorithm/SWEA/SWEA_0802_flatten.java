package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t < 11; t++) {
			int n = sc.nextInt();
			int [] arr = new int[100];
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
			int max;
			int min;
			for (int i = 0; i < n; i++) {
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				int max_idx = -1;
				int min_idx = -1;
				
				for (int j = 0; j < 100; j++) {
					if (max < arr[j]) {
						max = arr[j];
						max_idx = j;
					}
					if (min > arr[j]) {
						min = arr[j];
						min_idx = j;
					}
				}
				arr[max_idx]--;
				arr[min_idx]++;				
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			for (int j = 0; j < 100; j++) {
				max = Integer.max(arr[j], max);
				min = Integer.min(arr[j], min);
			}
			
			System.out.printf("#%d %d\n", t, max-min);
			
		}
		
			
	}

}