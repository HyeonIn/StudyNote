package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		
		int temp = 1;
		while (x > temp) {
			x -= temp++;
		}
		
		int a = temp;
		int b = 1;
		
		for (int i = 0; i < x-1; i++) {
			a-=1;
			b+=1;
		}
		if (temp % 2 == 0) {
			System.out.println(b+"/"+a);
		}
		else {
			System.out.println(a+"/"+b);
		}
	}
}