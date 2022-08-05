package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main { //출력 케이스가 50만개 여서 스트링빌더 꼭 써야 하는 문제 였음.... 그리고 HashMap에 getOrDefault 사용해야 contain 안쓰고 풀수있음
	static int n;
	static int m;
	static int[][] map;
	static int[] dx = {0, 1, -1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	
	static class dice{
		int[] nums = {0,0,0,0,0,0}; //동,서,북,남,아래, 위 
		
		public void roll(int x) {
			int[] nums2 = new int[6];
			if (x == 1) { //동쪽으로 굴릴 때
				nums2[0] = nums[5];
				nums2[1] = nums[4];
				nums2[2] = nums[2];
				nums2[3] = nums[3];
				nums2[4] = nums[0];
				nums2[5] = nums[1];
			}
			else if (x == 2) {
				nums2[0] = nums[4];
				nums2[1] = nums[5];
				nums2[2] = nums[2];
				nums2[3] = nums[3];
				nums2[4] = nums[1];
				nums2[5] = nums[0];
			}
			else if (x == 3) { //북쪽으로 굴릴 때
				nums2[0] = nums[0];
				nums2[1] = nums[1];
				nums2[2] = nums[5];
				nums2[3] = nums[4];
				nums2[4] = nums[2];
				nums2[5] = nums[3];
			}
			else  { //남쪽으로 굴릴 때
				nums2[0] = nums[0];
				nums2[1] = nums[1];
				nums2[2] = nums[4];
				nums2[3] = nums[5];
				nums2[4] = nums[3];
				nums2[5] = nums[2];
			}
			for (int i = 0; i < 6; i++) {
				nums[i] = nums2[i];
			};
		}
		public int top() {
			return nums[5];
		}
		public int copy() {
			return nums[4];
		}
		public void copy(int x) {
			nums[4] = x;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return Arrays.toString(nums);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		int y = Integer.parseInt(temp[2]);
		int x = Integer.parseInt(temp[3]);
		int k = Integer.parseInt(temp[4]);
		
		map = new int[n][m];	
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		dice dice = new dice();
		temp= br.readLine().split(" ");
		int startx = x;
		int starty = y;
		for (int i = 0; i < k; i++) {
			int dir = Integer.parseInt(temp[i]);
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx >= 0 && nx < m && ny >=0 && ny < n) {
				dice.roll(dir);
				if (map[ny][nx] == 0) {
					map[ny][nx] = dice.copy();
				}
				else {
					dice.copy(map[ny][nx]);
					map[ny][nx] = 0;
				}
				System.out.println(dice.top());
				x = nx;
				y = ny;
			}
		}
		
		
	}
}