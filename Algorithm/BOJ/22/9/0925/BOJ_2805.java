// 2805 나무 자르기
// 매개변수 탐색, 최대 길이 나무를 기준으로 이분탐색을 하면서 자를 구간을 정한다


package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int N, M;
	static int[] trees;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		trees = new int[N];
		
		temp = br.readLine().split(" ");
		int top = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(temp[i]); 
			top = Integer.max(top, trees[i]);
		}
		int bottom = 0;
		while (bottom + 1 < top) {
			int mid = (top+bottom)/2;
			long tempSum = 0;
			for (int j = 0; j < N; j++) {
				if (trees[j] > mid) {
					tempSum += trees[j] - mid;
				}
			}
			if (tempSum >= M) {
				bottom = mid;
			}else {
				top = mid;
			}
		}
		System.out.println(bottom);
	}
}