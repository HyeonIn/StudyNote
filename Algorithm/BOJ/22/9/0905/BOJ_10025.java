package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] ice = new int[1000001];
		String[] temp;
		int N, K;
		temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		K = Integer.parseInt(temp[1]);
	
		for (int j = 0; j < N; j++) {
			temp = br.readLine().split(" ");
			int x, g;
			g = Integer.parseInt(temp[0]);
			x = Integer.parseInt(temp[1]);
			ice[x] = g;
		}
		int tempSum = 0;
		for (int i = 0; i <= 1000000; i++) {
			tempSum += ice[i];
			ice[i] = tempSum;
		}
		int result = Integer.MIN_VALUE;
		if (K >= 1000000) {
			result = ice[1000000];
		}
		else {
			for (int i = 0; i <= 1000000; i++) {
				int right = i+K;
				int left = i-K;
				if (right > 1000000) {
					right = 1000000;
				}
				if (left < 0) {
					left = 0;
				}
				
				if (left != 0) {
					result = Math.max(result, ice[right] - ice[left-1]);					
				}
				else {
					result = Math.max(result, ice[right]);
				}
			}
		}
		System.out.println(result);
	}
}