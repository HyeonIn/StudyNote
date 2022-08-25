package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, S;
	static int[] result;
	static int[] arr;
	static boolean[] used;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		N = Integer.parseInt(temp[0]);
		S = Integer.parseInt(temp[1]);
		
		arr = new int[N];
		used = new boolean[N];
		
		temp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		} 
		powerSet(0);
		System.out.println(count);
		
	}
	public static void powerSet(int idx) {
		if (idx == N) {
			int sum = 0;
			boolean check = false;
			for (int i = 0; i < N; i++) {
				if (used[i]) {
					sum+= arr[i];
					check = true;
				}
			}
			if (sum == S && check) {
				count++;
			}
			return;
		}
		used[idx] = true;
		powerSet(idx + 1);
		used[idx] = false;
		powerSet(idx + 1);
	}
}