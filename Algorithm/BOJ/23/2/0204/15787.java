package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int[] trains;
	static StringTokenizer st;
	
	static int countTrain(){
		boolean check[] = new boolean[2000000];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			if (!check[trains[i]]) {
				count++;
				check[trains[i]] = true;
			}
		}
		
		return count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] trains = new int[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int cmd = Integer.parseInt(st.nextToken());
			int tIdx = Integer.parseInt(st.nextToken())-1;
			int x;
			
			switch (cmd) {
			case 1:
				x = Integer.parseInt(st.nextToken())-1;
				trains[tIdx] = trains[tIdx] | (1 << x);
				break;
			case 2:
				x = Integer.parseInt(st.nextToken())-1;
				if ((trains[tIdx] ^ (1 << x)) < trains[tIdx]) {
					trains[tIdx] = trains[tIdx] ^ (1 << x);					
				}
				break;
			case 3:
				trains[tIdx] = (trains[tIdx] << 1)%(1 << 20);
				break;
			case 4:
				trains[tIdx] = trains[tIdx] >> 1;
			default:
				break;
			}
		}
		
		System.out.println(countTrain());
	}
}
