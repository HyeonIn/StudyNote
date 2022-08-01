package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			String now = br.readLine();
			int cnt = 0;
			char[] next= new char[now.length()];
			for (int j = 0; j < next.length; j++) {
				next[j] = '0';
			}
			
			for (int j = 0; j < next.length; j++) {
				if (now.charAt(j) != next[j]) {
					cnt ++;
					for (int k = j; k < next.length; k++) {
						if (next[k] == '0') {
							next[k] = '1';
						}
						else {
							next[k] = '0';
						}
					}
				}
				
			}
			System.out.printf("#%d %d\n",i+1,cnt);
			
		}
	}

}
