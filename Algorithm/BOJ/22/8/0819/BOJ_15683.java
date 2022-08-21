package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N, M;
    static int count;
    static ArrayList<cctv> cam;
    static class cctv{
    	int i, j;
    	int num;
    	
    	public cctv(int i, int j, int num) {
    		this.i = i;
    		this.j = j;
    		this.num = num;
    	}
    }
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0 ,1};
    static final int UP = 0, LEFT = 1, DOWN = 2, RIGHT =3;
    
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        
        int [][] map = new int[N][M];
        count = Integer.MAX_VALUE;
        cam = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
        	temp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if (map[i][j] != 0 && map[i][j] != 6) {
					cam.add(new cctv(i, j, map[i][j]));
				}
			}
		}
        
        perm(0, map);
        System.out.println(count);
    }
    static void perm(int idx, int[][] origin) {
    	if (idx == cam.size()) {
			int tempCount = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (origin[i][j] == 0) {
						tempCount++;
					}
				}
			}
			count = Math.min(count, tempCount);
			return;
		}
    	
    	cctv now = cam.get(idx);
    	int[][] copy;
    	switch (now.num) {
		case 1:
			for (int i = 0; i < 4; i++) {
				copy = deepcopy(origin);
				fill(now, i, copy);
				perm(idx+1, copy);
			}
			break;
		case 2:
			int[][] cam2 = {{UP,DOWN}, {LEFT, RIGHT}};
			for (int i = 0; i < 2; i++) {
				copy = deepcopy(origin);
				fill(now, cam2[i][0], copy);
				fill(now, cam2[i][1], copy);
				perm(idx+1, copy);
			}
			break;
		case 3:
			int[][] cam3 = {{UP, RIGHT}, {RIGHT, DOWN}, {DOWN, LEFT}, {LEFT, UP}};
			for (int i = 0; i < 4; i++) {
				copy = deepcopy(origin);
				fill(now, cam3[i][0], copy);
				fill(now, cam3[i][1], copy);
				perm(idx+1, copy);
			}
			break;
		case 4:
			int temp = 3;
			int[][] cam4 = {{LEFT, UP, RIGHT}, {UP, RIGHT, DOWN}, {RIGHT, DOWN, LEFT}, {DOWN, LEFT, UP}};
			
			for (int i = 0; i < 4; i++) {
				copy = deepcopy(origin);
				fill(now, cam4[i][0], copy);
				fill(now, cam4[i][1], copy);
				fill(now, cam4[i][2], copy);
				perm(idx+1, copy);
			}
			break;
		case 5:
			copy = deepcopy(origin);
			fill(now, RIGHT, copy);
			fill(now, LEFT, copy);
			fill(now, UP, copy);
			fill(now, DOWN, copy);
			perm(idx+1, copy);
			break;
		default:
			break;
		}
    }
    static void fill(cctv now, int dir, int[][] map) {
    	int ni = now.i +di[dir];
    	int nj = now.j +dj[dir];
    	
    	while (true) {
			if (ni < 0 || nj < 0 || ni >=N || nj >=M || map[ni][nj] == 6) {
				break;
			}
			map[ni][nj] = 9;
			ni += di[dir];
			nj += dj[dir];
		}
    }
    static int[][] deepcopy(int[][] origin){
    	int[][] copy = new int[N][M];
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = origin[i][j];
			}
		}
    	return copy;
    }
}
