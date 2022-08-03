import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j]= Integer.parseInt(temp[j]);
			}
		}
		
		boolean[][] check = new boolean[n][n];
		int count1 = 0;
		int count0 = 0;
		for (int k = n; k > 0; k /= 2) {
			for (int i = 0; i < arr.length; i+=k) {
				for (int j = 0; j < arr.length; j+=k) {
					if (!check[i][j]) {
						boolean isFull = true;
						if (arr[i][j] == 1) {
							
							for (int i2 = i; i2 < i+k; i2++) {
								for (int j2 = j; j2 < j+k; j2++) {
									if (arr[i2][j2] != 1) {
										isFull = false;
									}
								}
							}
							if (isFull) {
								count1++;
								for (int i2 = i; i2 < i+k; i2++) {
									for (int j2 = j; j2 < j+k; j2++) {
										check[i2][j2] = true;
									}
								}
							}
						}
						else {
							for (int i2 = i; i2 < i+k; i2++) {
								for (int j2 = j; j2 < j+k; j2++) {
									if (arr[i2][j2] != 0) {
										isFull = false;
									}
								}
							}
							if (isFull) {
								count0++;
								for (int i2 = i; i2 < i+k; i2++) {
									for (int j2 = j; j2 < j+k; j2++) {
										check[i2][j2] = true;
									}
								}
							}
						}	
					}
				}
			}
		}
		
		System.out.println(count0);
		System.out.println(count1);
	}
	
}