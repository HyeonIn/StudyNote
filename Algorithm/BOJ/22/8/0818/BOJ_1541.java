package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] minus = br.readLine().split("-");
		int answer = 0;
		for (int i = 0; i < minus.length; i++) {
			String[] plus = minus[i].split("\\+");
			int temp = 0;
			for (int j = 0; j < plus.length; j++) {
				temp+= Integer.parseInt(plus[j]);
			}
			if (i != 0) {
				answer -= temp;
			}
			else {
				answer += temp;
			}
		}
		System.out.println(answer);
	}
}