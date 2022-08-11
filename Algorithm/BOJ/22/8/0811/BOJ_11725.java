package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static int[] roots;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	
	public static class node{
		int root;
		ArrayList<Integer> child;
		
		public node(int root, ArrayList<Integer> child) {
			this.root = root;
			this.child = child;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		roots = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			tree.add(new ArrayList<>());
		}
		
		int a, b;
		for (int i = 0; i < n-1; i++) {
			String temp[] = br.readLine().split(" ");
			
			a = Integer.parseInt(temp[0]);
			b = Integer.parseInt(temp[1]);
			
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		bfs(1);
		for (int i = 2; i <= n; i++) {
			sb.append(roots[i]).append('\n');
		}
		System.out.println(sb);
	}
	public static void bfs(int idx) {
		Queue<node> q = new ArrayDeque<>();
		q.add(new node(idx, tree.get(idx)));
		
		while (!q.isEmpty()) {
			node temp = q.poll();
			
			for (int j = 0; j < temp.child.size(); j++) {
				int Root = temp.root;
				int child = temp.child.get(j);
				if (roots[child] == 0) {
					roots[child] = Root;
					q.add(new node(child, tree.get(child)));
				}
				
				
			}
			
		}
	}
}