package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean isWhite = true;
		int count = 0;
		for (int i = 0; i < 8; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < temp.length; j++) {
				if (isWhite) {
					if (temp[j] == 'F') {
						count++;
					}
					isWhite = false;
				}
				else {
					isWhite = true;
				}
			}
			isWhite = isWhite ? false : true;
		}
		System.out.println(count);
	}
}
