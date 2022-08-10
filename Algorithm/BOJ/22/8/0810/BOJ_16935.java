package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n, m, r;
	static int[][] arr;
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		r = Integer.parseInt(temp[2]);
		int max = Math.max(n, m);
		arr = new int[max][max];
		result = new int[max][max];
		
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		temp = br.readLine().split(" ");
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].equals("1") || temp[i].equals("2")) {
				mirror(temp[i]);
			}
			else if (temp[i].equals("3") || temp[i].equals("4")) {
				rotate(temp[i]);
				swap();
			}
			else {
				square(temp[i]);
			}
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					arr[j][k] = result[j][k];
				}	
			}
		}
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[k][j] + " ");
			}
			System.out.println();
		}
		
	}
	public static void mirror(String cmd) {
		if (cmd.equals("1")) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					result[i][j] = arr[n-1-i][j];
				}
			}
		}
		else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					result[i][j] = arr[i][m-1-j];
				}
			}
		}
	}
	public static void rotate(String cmd) {
		if (cmd.equals("3")) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					result[i][j] = arr[n-1-j][i];
				}
			}
		}
		else {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					result[i][j] = arr[j][m-i-1];
				}
			}
		}
	}
	public static void square(String cmd) {
		if (cmd.equals("5")) {
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j < m/2; j++) {
					result[i][j+m/2] =  arr[i][j];
				}
			}
			for (int i = 0; i < n/2; i++) {
				for (int j = m/2; j < m; j++) {
					result[i+n/2][j] =  arr[i][j];
				}
			}
			for (int i = n/2; i < n; i++) {
				for (int j = m/2; j < m; j++) {
					result[i][j-m/2] =  arr[i][j];
				}
			}
			for (int i = n/2; i < n; i++) {
				for (int j = 0; j < m/2; j++) {
					result[i-n/2][j] =  arr[i][j];
				}
			}
		}
		else {
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j < m/2; j++) {
					result[i+n/2][j] =  arr[i][j];
				}
			}
			for (int i = n/2; i < n; i++) {
				for (int j = 0; j < m/2; j++) {
					result[i][j+m/2] =  arr[i][j];
				}
			}
			for (int i = n/2; i < n; i++) {
				for (int j = m/2; j < m; j++) {
					result[i-n/2][j] =  arr[i][j];
				}
			}
			for (int i = 0; i < n/2; i++) {
				for (int j = m/2; j < m; j++) {
					result[i][j-m/2] =  arr[i][j];
				}
			}
		}
	}
	public static void swap() {
		int temp = n;
		n = m;
		m = temp;
	}
}
