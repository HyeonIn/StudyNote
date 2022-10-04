package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 총 경기 수 : 15경기
// 경기 마다 생길 수 있는 경우는 3가지, 3가지 경우에 대해 전부 검사
// 현재 스코어 판에서 경기마다 결과를 팀별로 빼가면서 재귀적으로 탐색, 이 때 백트래킹을 위해 재귀 호출 후 다시 원상태로 복구 
// 뺄 수 없는 경우가 발생하면 재귀가 돌지 않으므로 15경기를 채울 수 가 없다.

public class Main {
	static int[] result = new int[15];
	static int[][] match = 
			{{0,1},{0,2},{0,3},{0,4},{0,5},
			{1,2},{1,3},{1,4},{1,5},
			{2,3},{2,4},{2,5},
			{3,4},{3,5},
			{4,5}};
	static int[][] score;
	static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		for (int i = 0; i < 4; i++) {
			score = new int[6][3];
			String temp[] = br.readLine().split(" ");
			answer = 1;
			for (int j = 0; j < 6; j++) {
				int tempCount = 0;
				for (int k = 0; k < 3; k++) {
					score[j][k] = Integer.parseInt(temp[(j*3)+k]);
					tempCount += score[j][k];
				}
				if (tempCount != 5) {
					answer = 0;
					break;
				}
				
			}
			if (answer == 1) {
				answer = 0;
				isValidGame(0);				
			}
			System.out.print(answer+ " ");
		}
		
	}
	public static void isValidGame(int matchNum) {
		if (answer == 1) {
			return;
		}
		if (matchNum == 15) {
			answer = 1;
			return;
		}
		int firstTeam = match[matchNum][0];
		int secondTeam = match[matchNum][1];
		
		//첫 번째 팀이 이긴경우
		if (score[firstTeam][0] > 0 && score[secondTeam][2] > 0) {
			score[firstTeam][0]--;
			score[secondTeam][2]--;
			isValidGame(matchNum+1);
			score[firstTeam][0]++;
			score[secondTeam][2]++;
		}
		//비긴 경우
		if (score[firstTeam][1] > 0 && score[secondTeam][1] > 0) {
			score[firstTeam][1]--;
			score[secondTeam][1]--;
			isValidGame(matchNum+1);
			score[firstTeam][1]++;
			score[secondTeam][1]++;
		}
		//두 번째 팀이 이긴 경우
		if (score[firstTeam][2] > 0 && score[secondTeam][0] > 0) {
			score[firstTeam][2]--;
			score[secondTeam][0]--;
			isValidGame(matchNum+1);
			score[firstTeam][2]++;
			score[secondTeam][0]++;
		}
	}
}