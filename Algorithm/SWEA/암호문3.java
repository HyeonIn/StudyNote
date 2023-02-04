package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		int T = 10;
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> mainList = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				mainList.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String cmd = st.nextToken();
				if (cmd.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = x; j < x+y; j++) {
						mainList.add(j, Integer.parseInt(st.nextToken()));
					}
				}
				else if (cmd.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = x; j < x+y; j++) {
						mainList.remove(j);
						mainList.
					}
				}
				else {
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						mainList.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			System.out.printf("#%d ", t+1);
			for (int i = 0; i < 10; i++) {
				System.out.print(mainList.get(i)+ " ");
			}
			System.out.println();
		}
	}
}
