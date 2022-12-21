package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static int[] arr;
	static int[] select;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		check = new boolean[N];
		select = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0);
	}
	public static void perm(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(select[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (check[i]) {
				continue;
			}
			check[i] = true;
			select[idx] = arr[i];
			perm(idx+1);
			check[i] = false;
			
		}
			
	}
}