package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        map = new char[N][N];
        
        for (int i = 0; i < N; i++) {
        	map[i] = br.readLine().toCharArray();
		}
        
        zip(0, 0, 1);
        System.out.println(sb);
    }
    public static void zip(int y, int x, int count) {
    	int count0 = 0;
    	int count1 = 0;
    	for (int i = y; i < y + N/count; i++) {
			for (int j = x; j < x + N/count; j++) {
				if (map[i][j] == '0') {
					count0++;
				}
				else {
					count1++;
				}
			}
		}
    	if (count0 == 0 || count1 == 0) {
			System.out.print(count0 == 0 ? 1 : 0);
		}
    	else {
    		System.out.print('(');
    		zip(y, x, count*2);
    		zip(y, x+(N/(count*2)), count*2);
    		zip(y+(N/(count*2)), x, count*2);
    		zip(y+(N/(count*2)), x+(N/(count*2)), count*2);
    		System.out.print(')');
    	}   	
    }
}
