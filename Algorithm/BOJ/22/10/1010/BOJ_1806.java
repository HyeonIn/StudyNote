package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int S = Integer.parseInt(st.nextToken());
    	
    	long[] arr = new long[N+1];
    	long sum = 0;
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
			sum += Long.parseLong(st.nextToken());
    		arr[i] = sum;
		}
    	int l = 0;
    	int r = 1;
    	int answer = Integer.MAX_VALUE;
    	while(true) {
    		if (r > N) {
				break;
			}
    		if (l >= r) {
				break;
			}
    		if (arr[r]-arr[l] >= S) {
				answer = Math.min(answer, r-l);
				l+=1;
			}
    		else {
    			r += 1;
    		}
    	}
    	System.out.println(answer== Integer.MAX_VALUE ? 0 : answer);
    }
}