import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {
	static int N, start;
	static boolean[][] graph;
	static int[] check;
	static class node{
		int n, w;
		
		public node(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp;
		for (int T = 1; T < 11; T++) {
			temp = br.readLine().split(" ");
			
			N = Integer.parseInt(temp[0]);
			start = Integer.parseInt(temp[1]);
			List[] graph = new LinkedList[101];
			graph = new boolean[101][101];
			check = new int[101];
			
			temp = br.readLine().split(" ");
			
			for (int i = 0; i < N-1; i+=2) {
				graph[Integer.parseInt(temp[i])][Integer.parseInt(temp[i+1])] = true;
			}
			for (int i = 0; i < 101; i++) {
				check[i] = Integer.MAX_VALUE;
			}
			bfs(start);
			int maxIdx = 0;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < 101; i++) {
				if (max <= check[i] && check[i] != Integer.MAX_VALUE) {
					maxIdx = i;
					max = check[i];
				}
			}
			System.out.printf("#%d %d\n", T, maxIdx);
		}
	}
	public static void bfs(int start) {
		ArrayDeque<node> q = new ArrayDeque<>();
		q.add(new node(start, 0));
		while (!q.isEmpty()) {
			node temp = q.poll();
			for (int i = 0; i < 101; i++) {
				if (graph[temp.n][i]) {
					if (check[i] > temp.w+1) {
						check[i] = temp.w+1;
						q.add(new node(i, temp.w+1));
					}
				}
			}
		}
	}
}