package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		MyComparator mc = new MyComparator();
		
		Arrays.sort(arr, mc);
		
		String before = "";
		for (int i = 0; i < n; i++) {
			if (!arr[i].equals(before)) {
				System.out.println(arr[i]);
			}
			before = arr[i];
			
		}
		
	}
}
class MyComparator implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if (o1.length() > o2.length()) {
			return 1;
		}
		else if (o1.length() < o2.length()) {
			return -1;
		}
		else {
			for (int i = 0; i < o1.length(); i++) {
				if (o1.charAt(i) > o2.charAt(i)) {
					return 1;
				}
				else if (o1.charAt(i) < o2.charAt(i)) {
					return -1;
				}
			}
			return 0;
		}
	}

}
