// 15961 회전 초밥
// N이 300만 개라서 k 구간을 일일히 다 구해주면 시간 초과.
// 구간을 옮겨가면서 검사할거라 슬라이딩 윈도우 사용 
// 처음 지점에서 부터 k지점까지 구하고 왼쪽 인덱스와 오른쪽 인덱스의 초밥들을 빼고 더해주는 과정 반복
// 이렇게 하면 O(N)의 시간복잡도로 끝낼 수 있음

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c;
	static int[] rail;
	static int[] sushi;
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	d = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	c = Integer.parseInt(st.nextToken());
    	
    	rail = new int[N+k];
    	sushi = new int[d+1];
    	
    	for (int i = 0; i < N; i++) {
			rail[i] = Integer.parseInt(br.readLine());
		}
    	
    	int answer = Integer.MIN_VALUE; // 최대 값 저장할 변수
    	
    	sushi[c] = 1; //쿠폰으로 주는 초밥은 무조건 포함 된다고 가정.
    	int count = 1; // 쿠폰으로 주는 초밥이 있으므로 카운팅은 1부터
    	
    	// 첫 K구간 탐색
    	for (int i = 0; i < k; i++) {
			if (sushi[rail[i]] == 0) {
				count++;
			}
    		sushi[rail[i]] += 1;
			rail[N+i] = rail[i];
		}
    	
    	// 최대 값 반영
    	answer = Math.max(count, answer);
    	
    	for (int i = 1; i < N; i++) {
    		
			sushi[rail[i-1]] -= 1;
			if (sushi[rail[i-1]] == 0) {
				count--;
			}
			if (sushi[rail[i+k-1]] == 0) {
				count++;
			}
			sushi[rail[i+k-1]] += 1; 
			
			answer = Math.max(count, answer);
		}
    	System.out.println(answer);
    }
}