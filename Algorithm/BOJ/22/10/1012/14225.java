package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> arr;
	static boolean[] num;
	static boolean[] check;
	static int N;
	static int answer = 1;
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());    	
    	
    	check = new boolean[N];
    	arr = new ArrayList<>();
    	num = new boolean[100000*N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
    	ps(0);
    	for (int i = 1; i < 100000*N; i++) {
			if (!num[i]) {
				System.out.println(i);
				break;
			}
		}
    }
	public static void ps(int idx) {
		if (idx == N) {
			int temp = 0;
			for (int i = 0; i < N; i++) {
				if (check[i]) {
					temp+= arr.get(i);
				}
			}
			num[temp] = true;
			return;
		}
		check[idx] = true;
		ps(idx+1);
		check[idx] = false;
		ps(idx+1);
	}
}