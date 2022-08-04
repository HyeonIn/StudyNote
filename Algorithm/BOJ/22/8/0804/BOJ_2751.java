package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main { //출력 케이스가 50만개 여서 스트링빌더 꼭 써야 하는 문제 였음.... 그리고 HashMap에 getOrDefault 사용해야 contain 안쓰고 풀수있음
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> arr = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			sb.append(arr.get(i)).append('\n');
		}
		
		System.out.print(sb);
		
	}
}