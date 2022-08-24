package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int R, C;
    static boolean[][] check;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int time;
    static char[][] map;
    
    static class coord{
        int i, j;
        public coord(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        
        R = Integer.parseInt(temp[0]);
        C = Integer.parseInt(temp[1]);
        
        
        map = new char[R][C];
        check = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        time = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    int answer = bfs(i, j);
                    System.out.println(answer == -1 ? "KAKTUS" : answer );
                    break;
                }
            }
        }
    }
    public static int bfs(int startI, int startJ) {
        ArrayDeque<coord> q = new ArrayDeque<>();
        q.add(new coord(startI,startJ));
        
        int time = 0;
        while (!q.isEmpty()) {
            int repeat = q.size();
            time++;
            flood();
            for (int r = 0; r < repeat; r++) {                
                coord temp = q.poll();
                for (int k = 0; k < 4; k++) {
                    int ni = temp.i+di[k];
                    int nj = temp.j+dj[k];
                    if (ni >= 0 && ni < R && nj >= 0 && nj < C && !check[ni][nj]) {
                        if (map[ni][nj] == 'D') {
                            return time;
                        }
                        else if (map[ni][nj] == '.') {
                            check[ni][nj]= true;
                            q.add(new coord(ni, nj));
                        }
                    }
                }
                
            }
        }
        return -1;
    }
    public static void flood() {
        char[][] copy = copy(map);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    for (int k = 0; k < 4; k++) {
                        int ni = i+di[k];
                        int nj = j+dj[k];
                        if (ni >= 0 && ni < R && nj >=0 && nj < C) {
                            if (map[ni][nj] == '.' || map[ni][nj] == 'S') {
                                copy[ni][nj] = '*';                                 
                            }
                        }
                    }
                }
            }
        }
        map = copy(copy);
    }
    public static char[][] copy(char[][] map){
        char[][] copy = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }
}