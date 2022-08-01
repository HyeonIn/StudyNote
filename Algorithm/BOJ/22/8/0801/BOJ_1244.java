package boj;

import java.util.Scanner;

public class Main {
	public static int[] arr;
	
	public static void female(int idx) {
		int ridx = idx+1;
		int lidx = idx-1;
		
		while(true) {
			if (ridx < arr.length && lidx >= 0) {
				if (arr[ridx] == arr[lidx]) {
					arr[ridx] = (arr[ridx] == 1) ? 0 : 1;
					arr[lidx--] = arr[ridx++];
				}
				else {
					break;
				}
			}
			else {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new int[n];
		
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int idx = sc.nextInt();
			
			if (s == 1) {
				for (int j = idx-1; j < arr.length; j += idx) {
					arr[j] = (arr[j] == 1) ? 0 : 1;
				}
			}
			else {
				arr[idx-1] = (arr[idx-1] == 1) ? 0 : 1;
				female(--idx);
			}
				
		}
		int i = 0;
		for (i = 0; i < n/20; i++) {
			for (int j = i*20; j < i*20+20; j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.print("\n");
		}
		for (int j = 0; j < n%20; j++) {
			System.out.print(arr[i*20+j]+" ");
		}
		
		
	}

}
