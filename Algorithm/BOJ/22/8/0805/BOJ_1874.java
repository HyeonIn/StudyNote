package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main { //출력 케이스가 50만개 여서 스트링빌더 꼭 써야 하는 문제 였음.... 그리고 HashMap에 getOrDefault 사용해야 contain 안쓰고 풀수있음
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[n+1];
		Stack<Integer> s = new Stack<>();
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			if (!check[m]) {
				while (count <= m) {
					s.push(count++);
					sb.append('+').append('\n');
				}
				while (!s.isEmpty() && s.lastElement() >= m) {
					check[s.pop()] = true;
					sb.append('-').append('\n');
				}
			}
			else {
				sb = new StringBuilder("NO");
				break;
			}
		}
		System.out.println(sb);
		
	}
}