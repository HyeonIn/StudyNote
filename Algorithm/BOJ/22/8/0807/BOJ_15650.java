import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	static int n, m;
	static int[] arr;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        
        arr = new int[n];
        select = new boolean[n];
        
        for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
        
        comb(0, 0);

        System.out.println(sb);
        
    }
    public static void comb(int idx, int cnt) {
    	if (cnt == m) {
			for (int i = 0; i < n; i++) {
				if (select[i]) {
					sb.append(arr[i]).append(' ');
				}
			}
			sb.append('\n');
			return;
		}
    	if (idx == n) {
			return;
		}
    	
    	select[idx] =true;
    	comb(idx+1, cnt+1);
    	select[idx] = false;
    	comb(idx+1, cnt);
    	
    }
}