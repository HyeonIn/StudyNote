package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] result;
	static char[] target;
	static char[] word;
	static int count;
	static int N;
	static String moem = "AEIOU";
	static long answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		word = br.readLine().toCharArray();
		N = word.length;
		count = 0;
		target = new char[] {'A', 'B', 'L'};
		
		for (int i = 0; i < word.length; i++) {
			if (word[i] == '_') {
				count++;
			}
		}
		result = new char[count];
		perm(0);
		
		System.out.println(answer);
	}
	public static void perm(int idx) {
		if (idx == count) {
			char copy[] = new char[N];
			for (int i = 0; i < N; i++) {
				copy[i] = word[i];
			}
			
			for (int i = 0, j = 0; i < N; i++) {
				if (copy[i] == '_') {
					copy[i] = result[j++];
				}
			}
			boolean isL = false;
			for (int i = 0; i < N; i++) {
				if (copy[i] == 'L') {
					isL = true;
				}
			}
			if (isL) {
				int count1 = 0; //자음
				int count2 = 0; //모음
				for (int i = 0; i < N; i++) {
					if (moem.contains(""+copy[i])) {
						count1 = 0;
						count2++;
					}
					else {
						count1++;
						count2 = 0;
					}
					if (count1 == 3 || count2 == 3) {
						return;
					}
				}
				long sum = 1; 
				for (int i = 0; i < count; i++) {
					if (result[i] == 'A') {
						sum *= 5;
					}
					else if (result[i] == 'B') {
						sum *= 20;
					}
				}
				answer += sum;
				
			}
			return;
		}
		for (int i = 0; i < 3; i++) {
			result[idx] = target[i];
			perm(idx+1);
		}
	}
}