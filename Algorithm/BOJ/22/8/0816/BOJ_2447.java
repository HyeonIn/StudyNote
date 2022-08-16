package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] stars;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		stars = new char[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				stars[i][j] = '*';
			}
		}
		star(n);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				sb.append(stars[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	static void star(int temp) {
		if (temp == 1) {
			return;
		}
		for (int i = 0; i < n/temp; i++) {
			for (int j = 0; j < n/temp; j++) {
				for (int k = temp/3+1+(temp*i); k <= temp/3*2+(temp*i); k++) {
					for (int l = temp/3+1+(temp*j); l <= temp/3*2+(temp*j); l++) {
						stars[k][l] = ' ';
					}
				}
			}
			
		}
		
		star(temp/3);
	}
}