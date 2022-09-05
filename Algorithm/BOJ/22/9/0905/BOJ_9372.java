package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String[] temp;
		for (int i = 0; i < T; i++) {
			int N, M;
			temp = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			M = Integer.parseInt(temp[1]);
		
			for (int j = 0; j < M; j++) {
				br.readLine();
				continue;
			}
			System.out.println(N-1);
		}
	}
}