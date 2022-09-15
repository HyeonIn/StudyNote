package boj;

// 1764 듣보잡
// 데이터의 입력이 최대 50만개 중복을 찾기 위해서 리스트를 반복하며 모든 단어를 찾는 것 보다
// 해싱을 이용해서 접근하는 것이 시간초과를 막을 수 있다고 생각
// 해시맵을 탐색하면서 값이 2인 key를 저장하고 출력했다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, M;
		String[] temp = br.readLine().split(" ");
		
		N = Integer.parseInt(temp[0]);
		M =	Integer.parseInt(temp[1]);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		for (int i = 0; i < M; i++) {
			String now = br.readLine();
			if (map.getOrDefault(now, 0) == 1) {
				map.put(now, 2);
			}
			else {
				map.put(now, 1);
			}
		}
		int count = 0;
		ArrayList<String> result = new ArrayList<>();
		for (String key : map.keySet()) {
			if (map.get(key) == 2) {
				count++;
				result.add(key);
			}
		}
		System.out.println(count);
		Collections.sort(result);
		for (String string : result) {
			System.out.println(string);
		}
	}

}
