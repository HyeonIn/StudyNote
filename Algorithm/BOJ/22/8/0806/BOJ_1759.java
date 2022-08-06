package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //출력 케이스가 50만개 여서 스트링빌더 꼭 써야 하는 문제 였음.... 그리고 HashMap에 getOrDefault 사용해야 contain 안쓰고 풀수있음	
	static int l;
	static int c;
	static char[] alphas;
	static char[] vowels = {'a','e','i','o','u'};
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		l = Integer.parseInt(temp[0]);
		c = Integer.parseInt(temp[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		alphas = new char[c];
		select = new boolean[c];
		
		for (int i = 0; i < c; i++) {
			alphas[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphas);
		
		
		comb(0,0);
		
		System.out.println(sb);
	}
	public static void comb(int idx, int cnt) {
		if(cnt == l) {
			int count = 0;
			for (int i = 0; i < c; i++) {
				if (select[i]) {
					for (int j = 0; j < 5; j++) {
						if (vowels[j] == alphas[i]) {
							count++;
						}
					}
				}
			}
			
			if (count >= 1 && l-count >= 2) {
				for (int i = 0; i < c; i++) {
					if (select[i]) {
						sb.append(alphas[i]);
					}
				}
				sb.append('\n');
			}
			return;
		}
		if(idx == c) {
			return;
		}
		select[idx] = true;
		comb(idx+1, cnt+1);
		select[idx] = false;
		comb(idx+1, cnt);
	}
}