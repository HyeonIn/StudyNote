package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			char[] W = br.readLine().toCharArray();
			int K = Integer.parseInt(br.readLine());
			
			ArrayDeque<Integer> q;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < 26; j++) {
				char c = (char)((int)'a' + j);
				q = new ArrayDeque<>();
				int count = 0;
				for (int k = 0; k < W.length; k++) {
					if (W[k] == c) {
						count++;
						q.add(k);
						if (count == K) {
							int idx = q.poll();
							int nowLen = k - idx + 1;
							min = Math.min(min, nowLen);
							max = Math.max(max, nowLen);
							
							count--;
						}
					}
				}
						
			}
			if (min == Integer.MAX_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(min+" "+max);
			}
		}
	}
}