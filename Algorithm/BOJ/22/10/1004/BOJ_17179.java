package boj;

// 매개변수 탐색 문제
// 케이크 조각의 길이에 초점을 두고, 최솟값을 임의로 지정해서 (이분 탐색 활용)
// 해당 최솟값으로 정해진 횟수만큼 자르는게 가능한지 확인하며 최솟값을 찾아간다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] cakes;
	static int N, M, L;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		L = Integer.parseInt(temp[2]);
		
		cakes = new int[M+1];
		
		for (int i = 0; i < M; i++) {
			cakes[i] = Integer.parseInt(br.readLine());
		}
		cakes[M] = L;
		
		for (int i = 0; i < N; i++) {
			int cut = Integer.parseInt(br.readLine()); //최대 자를 수 있는 횟수
			int answer = 0;
			int low = 0;
			int high = L;
			while (low <= high) {
				int mid = (low+high)/2;
				if (canMin(mid, cut)) { //최솟값이 가능한지 확인, 가능하면 더 큰 최솟값이 있는지 확인
					answer = Math.max(answer, mid);
					low = mid+1;
				}
				else { // 불가능한 최솟값이었다면, 더 작은 최솟값을 찾음
					high = mid-1;
				}
			}
			System.out.println(answer);
		}
		
	}
	public static boolean canMin(int min, int cut) {
		int prev = 0; //케익 조각의 길이를 구하기 위해 사용
		int count = 0;
		for (int i = 0; i < M+1; i++) {
			int nowLength = cakes[i]-prev; //현재 조각의 크기
			if (nowLength >= min) { //현재 조각이 최솟값보다 크거나 같으면, 자를 수 있다는 뜻
				count++; //자르고
				prev = cakes[i]; //다음 조각을 찾기 위해 시작점을 현재 지점으로 초기화
			}
		}
		if (count >= cut+1) { //잘려진 케이크의 조각의 개수가 자를 수 있는 횟수 +1 보다 크거나 같을 때,
			//임의로 정한 min 값이 알맞은 min값이라는 뜻
			return true;
		}
		else { //조각의 개수가 부족하면 임의로 정한 min값이 크다는 뜻 
			return false;
		}
	}
}