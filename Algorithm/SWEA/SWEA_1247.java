package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, N;
    static int[][] map;
    static coord home, company;
    static coord[] custom;
    static coord[] result;
    static boolean[] select;
    static int min;
    
    static class coord{
    	int x, y;
    	
    	public coord(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T+1; t++) {
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            
            result = new coord[N];
            select = new boolean[N];
            custom = new coord[N];
            String[] temp = br.readLine().split(" ");
            company = new coord(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            home = new coord(Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
            for (int i = 4, k = 0; i < N*2+4; i+=2) {
				custom[k++] = new coord(Integer.parseInt(temp[i]), Integer.parseInt(temp[i+1])); 
			}
            perm(0);
            System.out.printf("#%d %d\n", t, min);
        }
    }
    public static void perm(int idx) {
    	if (idx == N) {
    		int count = getDistance(company, result[0]);
    		for (int i = 0; i < N-1; i++) {
    			count += getDistance(result[i], result[i+1]);
			}
    		count += getDistance(home, result[N-1]);
    		min = Math.min(count, min);
			return;
		}
    	for (int i = 0; i < N; i++) {
			if (!select[i]) {
				result[idx] = custom[i];
				select[i] = true;
				perm(idx+1);
				select[i] = false;
			}
		}
    }
    public static int getDistance(coord c1, coord c2) {
    	return Math.abs(c1.x- c2.x) + Math.abs(c1.y - c2.y);
    }
}