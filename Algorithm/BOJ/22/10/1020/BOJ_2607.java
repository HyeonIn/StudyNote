// 2607 비슷한 단어
// 개수가 1개 차이 날 때랑 개수가 같을 때로 나눠서 접근
// 개수가 같을 때 단어의 개수의 차이가 0개이거나 2개일 때만 가능함
// edge case : ABBBB, ABDDB 이런 케이스 조심
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int answer = 0;
    	String s = br.readLine();
    	
    	int lenS = s.length();
    	int[] check = new int[26];
    	for (int i = 0; i < lenS; i++) {
			check[s.charAt(i)-'A'] += 1;
		}
    	for (int i = 0; i < N-1; i++) {
			String temp = br.readLine();
			int lenT = temp.length();
			int[] target = new int[26];
			
			for (int j = 0; j < lenT; j++) {
				target[temp.charAt(j)-'A'] += 1;
			}
			
			if (Math.abs(lenS-lenT) == 1) {
				if (checkDiff(check, target) == 1) {
					answer += 1;
				}
			}
			else if (Math.abs(lenS-lenT) == 0) {
				int diff = checkDiff(check, target);
				if (diff == 0 || diff == 2) {
					answer += 1;
				}
			}
		}
    	System.out.println(answer);
	}
	public static int checkDiff(int[] check, int[] target) {
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (check[i] != target[i]) {
				count+= Math.abs(check[i] - target[i]);
			}
		}
		return count;
	}
	
}