package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, K, count;
	
	static int kit[];
	static int result[]; //운동키트 저장 배열
	static boolean select[]; //선택 된거 표시
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		K = Integer.parseInt(temp[1]);
		
		result = new int[N];
		select = new boolean[N];
		kit = new int[N];
		count = 0;
		
		temp = br.readLine().split(" ");
		for (int i = 0; i < temp.length; i++) {
			kit[i] = Integer.parseInt(temp[i]);
		}
		
		perm(0);
		System.out.println(count);
		
	}
	public static void perm(int idx) {
		if (idx == N) {
			int tempWeight = 500;
			boolean Geunsonsil = false;
			for (int i = 0; i < N; i++) {
				tempWeight+=result[i] - K;
				if (tempWeight < 500) {
					Geunsonsil = true; //근 손 실 !!!!!
					break;
				}
			}
			if (!Geunsonsil) {
				count++;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!select[i]) {
				result[idx] = kit[i];				
				select[i] = true;
				perm(idx+1);
				select[i] = false;
			}
			
		}
	}
}