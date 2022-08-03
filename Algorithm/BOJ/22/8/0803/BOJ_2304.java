package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1000];
		
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			arr[a-1] = b;
		}
		
		int[][] map = new int[1000][1000];
		
		int answer = 0;
		int max_idx = 0;
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				max_idx = i;
				
			}
		}
		
		for (int i = 0; i <= max_idx; i++) {
			if (arr[i] != 0) {
				for (int j = 0; j < arr[i]; j++) {
					for (int k = i; k <= max_idx; k++) {
						map[j][k] = 1;
					}
				}
			}
		}
		for (int i = max_idx; i < map.length; i++) {
			if (arr[i] != 0) {
				for (int j = 0; j < arr[i]; j++) {
					for (int k = max_idx; k < i+1; k++) {
						map[j][k] = 1;
					}
				}
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 1) {
					answer += 1;
				}
			}
		}
		System.out.println(answer);
	}
}
