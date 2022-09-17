// 두 리스트의 중복된 값을 찾는 문제
// 반복문을 돌면서 탐색할 수 있지만, 데이터의 최대 개수가 50만개여서 시간초과 발생
// 해싱을 이용하여 시간초과를 해결하였다

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