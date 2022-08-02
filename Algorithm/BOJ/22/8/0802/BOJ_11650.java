package algo;

import java.util.Arrays;
import java.util.Scanner;


class coord implements Comparable<coord>{
	int x;
	int y;
	
	@Override
	public int compareTo(coord o) {
		if (x > o.x) {
			return 1;
		}
		else if (x <o.x) {
			return -1;
		}
		else {
			if (y > o.y) {
				return 1;
			}
			else if(y < o.y) {
				return -1;
			}
			else {
				return 0;
			}
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x+" "+y;
	}
	
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		coord[] arr = new coord[n];
		for (int i = 0; i < n; i++) {
			coord c = new coord();
			c.x = sc.nextInt();
			c.y = sc.nextInt();
			arr[i] = c;
		}
		Arrays.sort(arr);
		for (coord coord : arr) {
			System.out.println(coord);
		}
	}

}
