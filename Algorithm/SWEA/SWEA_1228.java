package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main {
	static int n, m;
	static LinkedList<Integer> arr;
	static StringBuilder sb;
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int T = 1; T <= 10; T++) {
        	arr = new LinkedList<>();
        	sb = new StringBuilder();
        	n = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
    			arr.add(Integer.parseInt(st.nextToken()));
    		}
            
            m = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine(), " ");
            
            for (int i = 0; i < m; i++) {
    			String cmd = st.nextToken();
    			int idx = Integer.parseInt(st.nextToken());
    			int k = Integer.parseInt(st.nextToken());
    			LinkedList<Integer> arr2 = new LinkedList<>();
    			
    			for (int j = 0; j < k; j++) {
    				arr2.add(Integer.parseInt(st.nextToken()));
    			}
    			arr.addAll(idx, arr2);
    		}
            for (int i = 0; i < 10; i++) {
				sb.append(arr.get(i)).append(" ");	
			}
            System.out.printf("#%d ", T);
            System.out.println(sb);
		}     
        
    }
}