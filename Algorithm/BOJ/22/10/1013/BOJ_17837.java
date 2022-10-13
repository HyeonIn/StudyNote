// 17837 새로운 게임 2

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static piece[] ps;
	static int[] di = {0, 0, -1, 1};
	static int[] dj = {1, -1, 0, 0};
	
	static int[][] board;
	static boolean answer;
	static int[][] pieceBoard;
	static class piece{
		int i, j, dir;
		ArrayList<Integer> pieces;
		
		public piece(int i, int j, int dir, int n) {
			this.i = i;
			this.j = j;
			this.dir = dir;
			pieces = new ArrayList<>();
			pieces.add(n);
		}
	}
	public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	board = new int[N][N];
    	pieceBoard = new int[N][N];
    	ps = new piece[K+1];
    	
    	for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			ps[i+1] = new piece(r-1, c-1, d-1, i+1);
			pieceBoard[r-1][c-1] = i+1;
		}
    	int count = 1;
    	answer = false;
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print();
			}
		}
    	while (count <= 1000) {
    		
    		for (int k = 1; k <= K; k++) {
				int ni = ps[k].i + di[ps[k].dir];
				int nj = ps[k].j + dj[ps[k].dir];
				if (ni < 0 || ni >= N || nj < 0 || nj >=N) {
					int tempN = k;
					remove(ps[k].i, ps[k].j);
					change(ps[k]);
					if (board[ps[k].i][ps[k].j] == 1) {
						tempN = reverse(ps[k]);
					}
					move(tempN, ps[k].i, ps[k].j);
					continue;
				}
				if (board[ni][nj] == 0) {
					remove(ps[k].i, ps[k].j);
					move(k, ni, nj);
				}
				else if (board[ni][nj] == 1) {
					remove(ps[k].i, ps[k].j);
					int n = reverse(ps[k]);
					move(n, ni, nj);
				}
				else {
					int tempN = k;
					remove(ps[k].i, ps[k].j);
					change(ps[k]);
					if (board[ps[k].i][ps[k].j] == 1) {
						tempN = reverse(ps[k]);
					}
					move(tempN, ps[k].i, ps[k].j);
				}
			}
			
			if (answer) {
				break;
			}
    		count++;
		}
    	System.out.println(count == 1001 ? -1 : count);
	}
    public static void change(piece p) {
    	if (p.dir == 0 || p.dir == 2) {
    		p.dir += 1;
		}
    	else {
    		p.dir -= 1;
    	}
    }
    public static void remove(int i, int j) {
    	pieceBoard[i][j] = 0;
    }
    public static int reverse(piece p) {
    	int n = p.pieces.get(p.pieces.size()-1);			
    	for (int i = p.pieces.size()-1; i >= 0; i--) {
			ps[n].pieces.add(p.pieces.get(i));
		}
    	p.pieces = new ArrayList<>();
    	return n;
    }
    public static void move(int n, int i, int j) {
    	if (pieceBoard[i][j] == 0) {
			pieceBoard[i][j] = n;
			for (int tmp : ps[n].pieces) {
				ps[tmp].i = i;
				ps[tmp].j = j;
			}
		}
    	else {
    		if (ps[n].pieces.size() + ps[pieceBoard[i][j]].pieces.size() >= 4) {
				answer = true;
				return;
			}
    		for (int tmp : ps[n].pieces) {
				ps[tmp].i = i;
				ps[tmp].j = j;
				System.out.println(i+ " "+ j +" " + n);
				for (int tmp2 : ps[pieceBoard[i][j]].pieces) {
					ps[tmp2].pieces.add(tmp);
				}
			}
    	}
    }
}