package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		Deque<Integer> deq = new ArrayDeque<>();
		
		for (int i = 0; i < t; i++) {
			String[] now = br.readLine().split(" ");
			
			if (now.length == 2) {
				if (now[0].equals("push_back")) {
					deq.addLast(Integer.parseInt(now[1]));
				}
				else {
					deq.addFirst(Integer.parseInt(now[1]));
				}
			}
			else {
				if (now[0].equals("front")) {
					if (!deq.isEmpty()) {
						System.out.println(deq.getFirst());
					}
					else {
						System.out.println(-1);
					}
				}
				else if(now[0].equals("back")){
					if (!deq.isEmpty()) {
						System.out.println(deq.getLast());
					}
					else {
						System.out.println(-1);
					}
				}
				else if(now[0].equals("size")){
					System.out.println(deq.size());
				}
				else if(now[0].equals("empty")){
					System.out.println(deq.isEmpty()? 1 : 0);
				}
				else if(now[0].equals("pop_front")){
					if (!deq.isEmpty()) {
						System.out.println(deq.pollFirst());
					}
					else {
						System.out.println(-1);
					}
				}
				else {
					if (!deq.isEmpty()) {
						System.out.println(deq.pollLast());
					}
					else {
						System.out.println(-1);
					}
				}
				
			}
			
			
		}
	}

}
