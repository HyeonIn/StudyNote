package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static class spot{
    	int l, r, w, h;

		public spot(int l, int r, int w, int h) {
			this.l = l;
			this.r = r;
			this.w = w;
			this.h = h;
		}
		@Override
		public String toString() {
			return "" + w ;
		}
    }
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	ArrayList<spot> aqua = new ArrayList<>();
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for (int i = 0; i < (N-2)/2; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			aqua.add(new spot(l, r, (r-l)*h, h));
		}
    	st = new StringTokenizer(br.readLine());
    	
    	int K = Integer.parseInt(br.readLine());
    	int answer = 0;
    	int[] check = new int[aqua.size()];
    	
    	
    	for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int idx = 0;
			for (int j = 0; j < aqua.size(); j++) {
				int templ = aqua.get(j).l;
				if (templ < L) {
					continue;
				}
				if (templ > L) {
					break;
				}
				idx = j;
			}
			aqua.get(idx).w = 0;
			
			int temph = aqua.get(idx).h;
			check[idx] = Math.max(temph, check[idx]);
			for (int j = idx+1; j < aqua.size(); j++) {
				if (temph <= check[j]) {
					continue;
				}
				
				if (aqua.get(j).h <= temph) {
					temph = aqua.get(j).h;
					aqua.get(j).w = 0;
				}
				else {
					aqua.get(j).w -= (aqua.get(j).r-aqua.get(j).l)*(temph-check[j]);
				}
				check[j] = temph;

				
			}
			temph = aqua.get(idx).h;
			for (int j = idx-1; j >= 0; j--) {
				if (temph <= check[j]) {
					continue;
				}
				if (aqua.get(j).h <= temph) {
					temph = aqua.get(j).h;
					aqua.get(j).w = 0;
				}
				else {
					aqua.get(j).w -= (aqua.get(j).r-aqua.get(j).l)*(temph-check[j]);
				}
				check[j] = temph;

			}
		}
    	
    	for (int i = 0; i < aqua.size(); i++) {
			answer += aqua.get(i).w; 
		}
    	System.out.println(answer);
    	
    }
}