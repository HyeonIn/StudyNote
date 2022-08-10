package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	static char[] alpha;
	static ArrayDeque<Character> s1 = new ArrayDeque();
	static ArrayDeque<Character> s2 = new ArrayDeque();
	
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		alpha = br.readLine().toCharArray();

		Arrays.sort(alpha);
		
		for (char c1 : alpha) {
			if (s1.size() == 0) {
				s1.add(c1);
			}
			else {
				if (s1.getLast() == c1) {
					sb.append(s1.pollLast());
					s2.add(c1);
				}
				else {
					s1.add(c1);
				}
			}
		}
		if (s1.size() == 0) {
			int range= s2.size();
			for (int i = 0; i < range; i++) {
				sb.append(s2.pollLast());
			}
			System.out.println(sb);
		}
		else if (s1.size() == 1) {
			sb.append(s1.pop());
			int range= s2.size();
			for (int i = 0; i < range; i++) {
				sb.append(s2.pollLast());
			}
			System.out.println(sb);
		}
		else {
			System.out.println("I'm Sorry Hansoo");
		}
	}
}