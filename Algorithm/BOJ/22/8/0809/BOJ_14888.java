package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int[] arr;
	static char[] result;
	static char[] oper;
	static boolean[] used;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		char[] O = {'+', '-', '*', '/'};
		arr = new int[n];
		result = new char[n-1];
		oper = new char[n-1];
		used = new boolean[n-1];
		String[] temp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		temp = br.readLine().split(" ");
		for (int j = 0, i = 0; j < 4; j++) {
			int amount = Integer.parseInt(temp[j]);
			if (amount != 0) {
				for (int k = 0; k < amount; k++) {
					oper[i++] = O[j];
				}
			}
		}
		perm(0);
		System.out.println(max);
		System.out.println(min);
	}
	public static void perm(int idx) {
		if (idx == n-1) {
			int temp = arr[0];
			for (int i = 0; i < result.length; i++) {
				if (result[i] == '+') {
					temp += arr[i+1];
				}
				else if (result[i] == '-') {
					temp -= arr[i+1];
				}
				else if (result[i] == '*') {
					temp *= arr[i+1];
				}
				else {
					temp /= arr[i+1];
				}
			}
			max = Math.max(temp, max);
			min = Math.min(temp, min);
			return;
		}
		for (int i = 0; i < n-1; i++) {
			if (!used[i]) {
				result[idx] = oper[i];
				used[i] = true;
				perm(idx+1);
				used[i] = false;
			}
		}
	}
}
