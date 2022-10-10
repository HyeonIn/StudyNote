package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class coord implements Comparable<coord>{
		int y, x;

		public coord(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(coord o) {
			if (this.y > o.y) {
				return 1;
			}
			else if (this.y < o.y) {
				return -1;
			}
			else {
				if (this.x > o.x) {
					return 1;
				}
				else if (this.x < o.x) {
					return -1;
				}
			}
			return 0;
		}
		@Override
		public String toString() {
			
			return x+" "+y;
		}
	}
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	PriorityQueue<coord> pq = new PriorityQueue<>();
    	StringTokenizer st;
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		pq.add(new coord(y,x));
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	while(!pq.isEmpty()) {
    		sb.append(pq.poll()).append('\n');	
    	}
    	System.out.print(sb);
    }
}