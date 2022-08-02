package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			
			if (temp.length == 2) {
				s.add(Integer.parseInt(temp[1]));
			}
			else {
				String cmd = temp[0];
				if (cmd.equals("pop")) {
					if (s.size() != 0) {
						System.out.println(s.pop());
					}
					else {
						System.out.println(-1);
					}
				}
				else if (cmd.equals("size")) {
					System.out.println(s.size());
				}
				else if (cmd.equals("empty")) {
					System.out.println(s.isEmpty() ? 1 : 0);
				}
				else {
					if (s.size() != 0) {
						System.out.println(s.lastElement());
					}
					else {
						System.out.println(-1);
					}
				}
			}
			
			
		}
		
	}

}
