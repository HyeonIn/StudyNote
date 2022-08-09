package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr;
	static int[] arr2;
	static int[] result;
	static boolean[] used;
	static int win, loss;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] temp = br.readLine().split(" ");
			
			boolean[] check = new boolean[19];
			arr = new int[9];
			arr2 = new int[9];
			used = new boolean[9];
			result = new int[9];
			win = 0;
			loss = 0;
			
			for (int i = 0; i < 9; i++) {
				check[Integer.parseInt(temp[i])] = true; 
				arr[i] = Integer.parseInt(temp[i]);
			}
			for (int i = 1, j = 0; i <= 18; i++) {
				if (!check[i]) {
					arr2[j++] = i;
				}
			}
			perm(0);
			System.out.println("#"+t+" "+win+" "+loss);
		}
	}
	public static void perm(int cnt) {
		if (cnt == 9) {
			int A = 0;
			int B = 0;
			for (int i = 0; i < 9; i++) {
				if (arr[i] > result[i]) {
					A+= arr[i]+result[i];
				}
				else {
					B+=arr[i]+result[i];
				}
			}
			if (A > B) {
				win++;
			}
			else {
				loss++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!used[i]) {
				result[cnt] = arr2[i];
				used[i] = true;
				perm(cnt+1);
				used[i] = false;
			}
		}
	}
}
