import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1043 거짓말
// 그래프 문제, 입력으로 들어오는 파티를 통해 사람들끼리 연결된 정보를 먼저 그래프로 만든다
// 사전에 진실을 아는 사람들을 기점으로 그래프를 순회하며 진실을 아는 사람들이 더 생길 수 있는지 기록한다
// 마지막으로 파티에 참석한 인원들을 검사하면서 진실을 아는 사람이 있는 파티인지 확인한다

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		ArrayList<Integer>[] party = new ArrayList[M];
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] check = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		int kn = Integer.parseInt(st.nextToken());
		for (int i = 0; i < kn; i++) {
			int n = Integer.parseInt(st.nextToken());
			q.add(n);
			check[n] = true;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pn = Integer.parseInt(st.nextToken());
			
			int prev = Integer.parseInt(st.nextToken());
			party[i].add(prev);
			for (int j = 0; j < pn-1; j++) {
				int next = Integer.parseInt(st.nextToken());
				party[i].add(next);
				graph[prev].add(next);
				graph[next].add(prev);
				prev = next;
			}
		}
		
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < graph[temp].size(); i++) {
				int next = graph[temp].get(i);
				if (check[next]) {
					continue;
				}
				check[next] = true;
				q.add(next);
			}
		}
		
		int answer =0;
		for (int i = 0; i < M; i++) {
			boolean factCheck = false;
			for (int p : party[i]) {
				if (check[p]) {
					factCheck = true;
					break;
				}
			}
			if (!factCheck) {
				answer += 1;
			}
		}
		System.out.println(answer);
	}
}
