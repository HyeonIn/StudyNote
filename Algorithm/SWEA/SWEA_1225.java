package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Main {
    
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int T = 1; T <= 10; T++) {
			String t = br.readLine();
        	
			String[] temp = br.readLine().split(" ");
	        Stack<Integer> s= new Stack<>();
			Queue<Integer> q = new LinkedList<Integer>();
			
			for (int i = 0; i < temp.length; i++) {
				q.add(Integer.parseInt(temp[i]));
			}
			
			int minus = 1;
			while (true) {
				int n = q.poll();
				
				if (n-minus <=0) {
					q.add(0);
					break;
				}
				q.add(n-minus++);
				if (minus == 6) {
					minus = 1;
				}
			}
			
	        System.out.printf("#%d ", T);
	        for (int i = 0; i < 8; i++) {
				System.out.print(q.poll()+" ");
			}
	        System.out.println();
        }
    }
}