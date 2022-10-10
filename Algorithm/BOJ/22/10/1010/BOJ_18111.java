package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, B;
	static int[] map;
	static int answerCount = Integer.MAX_VALUE;
	static int answerHeight;
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	int size = N*M;
    	map = new int[size];
    	int k=0;
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[k++] = Integer.parseInt(st.nextToken()); 
			}
		}
    	if (size == 1) {
			System.out.println(0 + " " + map[0]);
		}
    	else {
    		int answerC = Integer.MAX_VALUE;
    		int answerH = 0;
    		int height = 256;
    		while (height >= 0) {
    			int tempB = B;
    			for (int i = 0; i < size; i++) {
    				tempB += map[i] - height;
    			}
    			if (tempB >= 0) {
    				int count = 0;
    				for (int i = 0; i < size; i++) {
    					if (map[i] > height) {
    						count += 2*(map[i]-height);
    					}
    					else {
    						count += height-map[i];
    					}
    				}
    				if (count < answerC) {
						answerC = count;
						answerH = height;
					}
    			}
    			height--;
    		}
    		System.out.println(answerC + " " + answerH);
    	}
    }
}