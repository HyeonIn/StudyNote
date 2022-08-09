package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] temp;
	static StringBuilder sb;
	static int[] arr;
	static boolean[] selected;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			temp = br.readLine().split(" ");
			if (temp[0].equals("0")) {
				break;
			}
			else {
				k = Integer.parseInt(temp[0]);
				sb = new StringBuilder();
				arr = new int[k];
				selected = new boolean[k];
				
				
				for (int i = 1; i <= k; i++) {
					arr[i-1] = Integer.parseInt(temp[i]); 
				}
				comb(0,0);
				System.out.println(sb);
			}
		}
		
	}
	public static void comb(int idx, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < k; i++) {
				if (selected[i]) {
					sb.append(arr[i]).append(' ');
				}
			}
			sb.append('\n');
			return;
		}
		if (idx == k) {
			return;
		}
		selected[idx] = true;
		comb(idx+1, cnt+1);
		selected[idx] = false;
		comb(idx+1, cnt);
	}
}
