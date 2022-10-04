package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	static int N, K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			
			String[] temp = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			K = Integer.parseInt(temp[1]);
			int a = N/4;
			ArrayList<Long> s = new ArrayList<>();
			char[] nums = br.readLine().toCharArray();
			for (int i = 0; i < a; i++) {
				ArrayDeque<Character> q = new ArrayDeque<>();
				for (int j = 0; j < nums.length; j++) {
					q.add(nums[j]);
				}
				for (int j = 0; j < i; j++) {
					char c= q.poll();
					q.add(c);
				}
				for (int j = 0; j < 4; j++) {
					StringBuilder sb = new StringBuilder();
					for (int k = 0; k < a; k++) {
						sb.append(q.poll());
					}
					Long now = Long.parseLong(sb.toString(), 16);
					s.add(now);
				}
			}
			Collections.sort(s);
			ArrayList<Long> s2 = new ArrayList<>();
			long check = s.get(0);
			s2.add(s.get(0));
			for (int i = 1; i < s.size(); i++) {
				if (check != (long)s.get(i)) {
					check = s.get(i);
					s2.add(s.get(i));
				}
			}
			System.out.printf("#%d %d\n",t+1,s2.get(s2.size()-K));
		}
	}
}
