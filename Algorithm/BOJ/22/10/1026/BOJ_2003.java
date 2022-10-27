package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, target;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		target = Integer.parseInt(st.nextToken()); 
		arr = new int[N+1];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sum += Integer.parseInt(st.nextToken());
			arr[i] = sum;
		}
		int answer  = 0;
		int l = 0;
		int r = 1;
		
		while(l <= r) {
			if (r > N) {
				break;
			}
			int temp = arr[r] - arr[l];
			if (temp < target) {
				r += 1;
			}
			else if (temp >= target) {
				if (temp == target) {
					answer++;
				}
				l += 1;
			}
		}
		System.out.println(answer);
	}
}
