package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static int p[];
	
	public static void main(String[] argv) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			String[] temp = br.readLine().split(" ");
			
			N = Integer.parseInt(temp[0]);
			M = Integer.parseInt(temp[1]);
			
			StringBuilder sb = new StringBuilder();
			
			p = new int[N+1];
			
			for (int j = 0; j < N+1; j++) {
				p[j] = j;
			}
			
			for (int j = 0; j < M; j++) {
				temp = br.readLine().split(" ");
				int cmd = Integer.parseInt(temp[0]);
				int a = Integer.parseInt(temp[1]);
				int b = Integer.parseInt(temp[2]);
				
				if (cmd == 0) {
					union(a, b);
				}
				else {
					if (find(a) == find(b)) {
						sb.append(1);
					}
					
					else {
						sb.append(0);
					}
				}
			}
			
			System.out.printf("#%d %s\n", i, sb);
		}
	}
	public static int find(int x) {
		if (x == p[x]) {
			return x;
		}
		else {
			return p[x] = find(p[x]);
		}
	}
	public static void union(int x, int y) {
		if (find(y) == find(x)) {
			return;
		}
		p[find(y)] = find(x);
	}
}