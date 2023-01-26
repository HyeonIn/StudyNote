package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(br.readLine());
			arr[i] = now;
		}
		
		Arrays.sort(arr);
		
		long answer = 0;
		for (int i = 1; i <= N; i++) {
			answer += Math.abs(i - arr[i-1]);
		}
		
		System.out.println(answer);
		br.close();
	}
}
