package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count;
	
	static void countBottle(int num) {
		count = 0;
		while (num > 0) {
			count += num%2;
			num >> 2;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		countBottle(N);
		while (count > M) {
			countBottle(++N);
			answer++;
		}
		
		System.out.println(answer);
	}
}
