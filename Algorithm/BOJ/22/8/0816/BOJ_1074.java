package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
	static int n, r, c;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		r = Integer.parseInt(temp[1]);
		c = Integer.parseInt(temp[2]);
		
		calc(n,r,c);
		System.out.println(answer);
		
		
	}
	public static void calc(int n, int r, int c) {
		if (n == 0) {
			return;
		}
		if (r < Math.pow(2, n-1) && c < Math.pow(2, n-1)) {
			answer += Math.pow(4, n-1) * 0;
			calc(n-1, r, c);
		}
		else if(r < Math.pow(2, n-1) && c >= Math.pow(2, n-1)){
			answer += Math.pow(4, n-1) * 1;
			calc(n-1, r, c-(int)Math.pow(2, n-1));
		}
		else if (r >= Math.pow(2, n-1) && c < Math.pow(2, n-1)) {
			answer += Math.pow(4, n-1) * 2;
			calc(n-1, r-(int)Math.pow(2, n-1), c);
		}
		else if (r >= Math.pow(2, n-1) && c >= Math.pow(2, n-1)) {
			answer += Math.pow(4, n-1) * 3;
			
			calc(n-1, r-(int)Math.pow(2, n-1), c-(int)Math.pow(2, n-1));
		}
		
	}
}

