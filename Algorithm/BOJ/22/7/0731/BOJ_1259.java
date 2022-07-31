package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		
		
		while(n.charAt(0) != '0') {
			boolean ans=true;
			
			Stack<Character> s1 = new Stack<>();
		
			for (int i = 0; i < n.length()/2; i++) {
				s1.add(n.charAt(i));
			}
			if (n.length()%2 == 0) {
				for (int i = n.length()/2; i < n.length(); i++) {
					char temp = s1.pop();
					if (n.charAt(i) != temp) {
						ans = false;
					}
				}
			}
			else {
				for (int i = n.length()/2+1; i < n.length(); i++) {
					char temp = s1.pop();
					if (n.charAt(i) != temp) {
						ans = false;
					}
				}
			}
			System.out.println(ans ? "yes" : "no");
			
			n = br.readLine();
		}
	}

}
