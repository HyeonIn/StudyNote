package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [][] paper = new int[101][101];
		
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			for (int j = a; j < a+10; j++) {
				for (int k = b; k < b+10; k++) {
					paper[j][k] = 1;
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if (paper[i][j] == 1) {
					answer += 1;
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
