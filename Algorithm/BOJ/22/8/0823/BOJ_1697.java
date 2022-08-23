package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main {
	static int N, K;
	static boolean check[];
	static int time = 0;
	static int count;
	static int[] dx = {-1, 1, 2};
	
	public static void main(String[] argv) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		
		N = Integer.parseInt(temp[0]);
		K = Integer.parseInt(temp[1]);
		
		check = new boolean[100001];
		
		check[N]=true;
		if (N == K) {
			System.out.println(0);
			System.out.println(1);
		}
		else {
			bfs(N);
			System.out.println(time);	
			System.out.println(count);
		}
		
	}
	public static void bfs(int n) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		q.add(n);
		
		while (!q.isEmpty()) {
			time++;
			count = 0;
			int repeat = q.size();
			for (int i = 0; i < repeat; i++) {
				int temp = q.poll();
				for (int j = 0; j < 3; j++) {
					int nx;
					if (j < 2) {
						nx = temp + dx[j];
					}
					else {
						nx = temp*dx[j];
					}
					if (nx == K) {
						count++;
					}
					if (nx >= 0 && nx < 100001 && !check[nx]) {
						check[nx] = true;
						q.add(nx);
					}
				}
			}
			if (count != 0) {
				return;
			}
		}
		
	}
}