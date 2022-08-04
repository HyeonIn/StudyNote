package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main { //출력 케이스가 50만개 여서 스트링빌더 꼭 써야 하는 문제 였음.... 그리고 HashMap에 getOrDefault 사용해야 contain 안쓰고 풀수있음
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, Integer> map = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for (int i = 0; i < n; i++) {
			String temp = st.nextToken();
			map.put(temp, map.getOrDefault(temp, 0)+1);
			
		}
		int m = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder() ;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			sb.append(map.getOrDefault(st.nextToken(), 0)).append(' ');
		}
		
		System.out.println(sb);
		
	}
}