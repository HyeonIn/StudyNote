package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class time implements Comparable<time>{
	int start;
	int end;
	public time(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(time o) {
		// TODO Auto-generated method stub
		if (end > o.end) {
			return 1;
		}
		else if (end < o.end) {
			return -1;
		}
		else {
			if (start > o.start) {
				return 1;
			}
			else if (start < o.start) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}


public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<time> q = new PriorityQueue<>();
		
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			q.add(new time(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
		}
		int count = 0;
		time temp = q.poll();
		int end = temp.end;
		count++;
		while (!q.isEmpty()) {
			
			time next = q.poll();
			if (end <= next.start) {
				end = next.end;
				count++;
			}
		}
		System.out.println(count);			
	}

}