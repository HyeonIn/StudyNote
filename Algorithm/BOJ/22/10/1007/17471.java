package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] people;
	static boolean[][] graph;
	
	static int M;
	static boolean[] selected;
	static int result;
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	people = new int[N+1];
    	graph = new boolean[N+1][N+1];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
    	
    	for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				int next = Integer.parseInt(st.nextToken());
				graph[i][next] = true;
				graph[next][i] = true;
			}
		}
    	result = Integer.MAX_VALUE;
    	for (int i = 1; i < N; i++) {
			M = i;
			selected = new boolean[N+1];
			comb(1,0);
		}
    	System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
    public static void comb(int idx, int cnt) {
    	if (cnt == M) {
    		for (int i = 1; i <= N; i++) {
				if (selected[i]) {
					if (find(i)) {
						int count1 = 0;
						int count2 = 0;
						for (int j = 1; j <= N; j++) {
							if (selected[j]) {
								count1 +=people[j];
							}
							else {
								count2 += people[j];
							}
						}
						result = Math.min(result, Math.abs(count1-count2));
					}
					break;
				}
			}
    		return;
		}
    	if (idx == N+1) {
			return;
		} 
    	
    	selected[idx] = true;
    	comb(idx+1, cnt+1);
    	selected[idx] = false;
    	comb(idx+1, cnt);
    }
    public static boolean find(int start) {
    	ArrayDeque<Integer> q = new ArrayDeque<>();
    	boolean check[] = new boolean[N+1];
    	q.add(start);
    	check[start] = true;
    	while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 1; i <= N; i++) {
				if (check[i]) {
					continue;
				}
				if (selected[i] && graph[temp][i]) {
					check[i] = true;
					q.add(i);
				}
			}
		}
    	for (int i = 1; i <= N; i++) {
			if (selected[i] != check[i]) {
				return false;
			}
		}
    	int i;
    	for (i = 1; i <= N; i++) {
			if (!selected[i]) {
				break;
			}
		}
    	
    	check = new boolean[N+1];
    	q.add(i);
    	check[i] = true;
    	while (!q.isEmpty()) {
			int temp = q.poll();
			for (int j = 1; j <= N; j++) {
				if (check[j]) {
					continue;
				}
				if (!selected[j] && graph[temp][j]) {
					check[j] = true;
					q.add(j);
				}
			}
		}
    	for (int j = 1; j <= N; j++) {
			if (selected[j] == check[j]) {
				return false;
			}
		}
    	return true;
    }
}