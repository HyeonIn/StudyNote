package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int T = 1; T <= 10; T++) {
			int n = Integer.parseInt(br.readLine());
			char[] temp = br.readLine().toCharArray();
	        
			int answer = 1;
			
			Stack<Character> s = new Stack<>();
	        for (int i = 0; i < n; i++) {
				if (temp[i] == ')') {
					if (s.pop() != '(') {
						answer = 0;
						break;
					}
				}
				else if (temp[i] == ']') {
					if (s.pop() != '[') {
						answer = 0;
						break;
					}
				}
				else if (temp[i] == '}') {
					if (s.pop() != '{') {
						answer = 0;
						break;
					}
				}
				else if (temp[i] == '>') {
					if (s.pop() != '<') {
						answer = 0;
						break;
					}
				}
				else {
					s.add(temp[i]);
				}
			}
	        System.out.printf("#%d %d\n", T, answer);
        }
    }
}