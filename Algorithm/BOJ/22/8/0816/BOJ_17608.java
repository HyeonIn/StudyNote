package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static ArrayDeque<Integer> s1;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		s1 = new ArrayDeque<>();
		s1.add(Integer.parseInt(br.readLine()));
		for (int i = 1; i < n; i++) {
			int temp = Integer.parseInt(br.readLine());
			while (!s1.isEmpty()) {
				if (s1.peekLast() <= temp) {
					s1.pollLast();
				}
				else {
					break;
				}
			}

			s1.add(temp);
		}
		System.out.println(s1.size());
		
	}
}