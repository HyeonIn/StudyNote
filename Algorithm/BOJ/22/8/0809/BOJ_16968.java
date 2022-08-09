package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int countD = 0;
	static int countC = 0;
	static int answer = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		if (input.charAt(0) == 'c') {
			answer *= 26;
		}
		else {
			answer *= 10;
		}
		
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == 'd') {
				if (input.charAt(i-1) =='d') {
					answer *= 9;
				}
				else {
					answer *= 10;
				}
			}
			else {
				if (input.charAt(i-1) == 'c') {
					answer *= 25;
				}
				else {
					answer *= 26;
				}
			}
		}
		System.out.println(answer);
		
	}
	
}
