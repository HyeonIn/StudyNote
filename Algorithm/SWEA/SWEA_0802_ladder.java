package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int T = 1; T < 11; T++) {
			int g = Integer.parseInt(br.readLine());
			
			int[][] ladder = new int[100][100];
			
			
			for (int i = 0; i < 100; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(temp[j]);
				}
			}
			int answer = -1;
			int start = 0;
			for (int i = 0; i < 100; i++) {
				if (ladder[99][i] == 2) {
					start = i;
				}
			}
			int j = start;
			int[] dx =  {-1, 1};
			for (int i = 99; i > 0; i--) {
				for (int k = 0; k < 2; k++) {
					int nx = dx[k] + j;
						if (nx >= 0 && nx < 100) {
							if (ladder[i][nx] == 1) {
								int nx2 = nx;
								while (true) {
									nx2 += dx[k];
									if (nx2 >= 0 && nx2 < 100) {
										if (ladder[i][nx2] == 0) {
											nx2 -= dx[k];
											break;
										}
									}
									else {
										nx2 -= dx[k];
										break;
									}
								}
								j = nx2;
								break;
							}
						}
				}							
			}
			
			
			System.out.printf("#%d %d\n", T, j);
		}
			
	}

}