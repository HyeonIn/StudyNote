package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long s = Integer.parseInt(st.nextToken());
		long answer;
		if (2*w <= s) {
			answer = (w*x) + (w*y); 
		}
		else {
			if (s <= w) {
				if (Math.abs(x-y)%2 == 0) {
					answer = Long.max(x, y)*s;
				}
				else {
					answer = (Long.max(x, y)-1)*s + w;
				}
			}
			else {
				answer = Long.min(x, y)*s + (Long.max(x,y) - Long.min(x, y))*w;
			}
			
		}
		System.out.println(answer);
	}
}