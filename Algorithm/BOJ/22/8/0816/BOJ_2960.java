package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] nums;
	static boolean[] check;
	static int n, k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		
		check = new boolean[n+1];
		
		int count = 0;
		int first = 2;
		int answer = 2;
		while(true) {
			for (int i = 2; i <= n; i++) {
				if (!check[i]) {
					if (i % first == 0) {
						check[i] = true;
						count++;
						answer = i;
					}
					if (count == k) {
						break;
					}
				}
			
			}
			if (count == k) {
				break;
			}
			first = findFirst();
		}
		
		System.out.println(answer);
		
	}
	static int findFirst() {
		for (int i = 2; i <=n; i++) {
			if (!check[i]) {
				return i;
			}
		}
		return 0;
	}
}

