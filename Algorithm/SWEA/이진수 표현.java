package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int answerCheck =  (1 << N) -1;
			
			if ((answerCheck & M) == answerCheck) {
				System.out.printf("#%d %s\n", t+1, "ON");				
			}
			else {
				System.out.printf("#%d %s\n", t+1, "OFF");				
			}
		}
	}
}
