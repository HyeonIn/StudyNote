package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int nowX = 0, nowY = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int X = Integer.parseInt(temp[0]);
		int Y = Integer.parseInt(temp[1]);
		int answer = 0;
		
		if (X >= Y) {
			answer += X+(Y/10) + Y;
		}
		else {
			answer += Y+(X/10) + X;
		}
		
		System.out.println(answer);
	}	
}