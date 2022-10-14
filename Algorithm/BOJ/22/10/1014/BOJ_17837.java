package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] map;
	static ArrayList<piece>[][] board;
	
	static class piece{
		int n, i, j, dir;
		public piece(int n, int i, int j, int dir) {
			this.n = n;
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "" + n + " ("+i+","+j+") " + dir;
		}		
		
	}
	
	static int[] di = {0,0,-1,1};
	static int[] dj = {1,-1,0,0};
	static piece[] ps;
	static boolean answer;
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][N];
    	board = new ArrayList[N][N];
    	ps = new piece[K+1];
    	answer = false;
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = new ArrayList<>();
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) -1;
			
			piece tmp = new piece(i+1, r,c,dir);
			board[r][c].add(tmp);
			ps[i+1] = tmp;
		}
    	
    	int turn = 1;
    	while (turn <= 1000) {
    		for (int k = 1; k <= K; k++) {
    			int tempi = ps[k].i;
    			int tempj = ps[k].j;
    			int ni = ps[k].i + di[ps[k].dir]; 
    			int nj = ps[k].j + dj[ps[k].dir];
    			if (ni < 0 || nj < 0 || ni >= N || nj >= N) {
					change(ps[k]);
					ni = tempi + di[ps[k].dir];
    				nj = tempj + dj[ps[k].dir];
    				if (map[ni][nj] == 2) {
						continue;
					}
    				else if (map[ni][nj] == 1) {
    					move(ps[k], ni, nj);
    					check(ni, nj);
						reverse(ps[k]);
						remove(ps[k], tempi, tempj);
					}
    				else {
    					move(ps[k], ni, nj);
    					check(ni, nj);
        				remove(ps[k], tempi, tempj);
    				}
    				continue;
				}
    			if (map[ni][nj] == 0) {
					move(ps[k], ni, nj);
					check(ni, nj);
    				remove(ps[k], tempi, tempj);
				}
    			
    			else if (map[ni][nj] == 1) {
					move(ps[k], ni, nj);
					check(ni, nj);
					reverse(ps[k]);
					
					remove(ps[k], tempi, tempj);
				}
    			else {
    				change(ps[k]);
    				ni = tempi + di[ps[k].dir];
    				nj = tempj + dj[ps[k].dir];
    				if (ni < 0 || nj < 0 || ni >= N || nj >= N) {
    					continue;
    				}
    				if (map[ni][nj] == 2) {
						continue;
					}
    				else if (map[ni][nj] == 1) {
    					move(ps[k], ni, nj);
    					check(ni, nj);
						reverse(ps[k]);
						remove(ps[k], tempi, tempj);
					}
    				else {
    					move(ps[k], ni, nj);
    					check(ni, nj);
        				remove(ps[k], tempi, tempj);
    				}
    			}
    			
    		}
    		
    		if (answer) {
				break;
			}
    		turn++;
		}
    	System.out.println(turn == 1001 ? -1 : turn);
	}
    public static void change(piece p) {
    	if (p.dir == 0 || p.dir == 2) {
			p.dir += 1;
		}
    	else {
    		p.dir -= 1;
    	}
    }
    public static void remove(piece p, int i, int j) {
    	int size = board[i][j].size();
    	for (int k = size-1; k >= 0; k--) {
			if (board[i][j].get(k).n == p.n) {
				board[i][j].remove(k);
				break;
			}
			board[i][j].remove(k);
		}
    }
    public static void reverse(piece p) {
    	ArrayList<piece> copy = new ArrayList<>();
    	for (int k = board[p.i][p.j].size()-1; k >= 0; k--) {
    		copy.add(board[p.i][p.j].get(k));
    		if (board[p.i][p.j].get(k).n == p.n) {
    			board[p.i][p.j].remove(k);
    			break;
    		}
    		board[p.i][p.j].remove(k);
		}
    	for (piece piece : copy) {
    		board[p.i][p.j].add(piece);			
		}
    }
    public static void move(piece p, int ni, int nj) {
		boolean find = false;
		for (piece tmp : board[p.i][p.j]) {
			if (tmp.n == p.n) {
				find = true;
			}
			if (!find) {
				continue;
			}
			board[ni][nj].add(tmp);
			tmp.i = ni;
			tmp.j = nj;
		}
	
    }
    public static void check(int i, int j) {
    	if (board[i][j].size() >= 4) {
			answer = true;
		}
    }
}