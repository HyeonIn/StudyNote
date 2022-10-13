// 15652 N과 M(4)
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static StringBuilder sb;
	static int[] arr;
	public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new int[M];
    	sb = new StringBuilder();
    	dfs(0, 1);
    	System.out.println(sb);
	}
	public static void dfs(int idx, int n) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (i >= n) {
				arr[idx] = i;
				dfs(idx+1, i);
			}
		}
	}
}