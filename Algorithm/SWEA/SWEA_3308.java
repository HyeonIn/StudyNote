import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution
{
    static int[] c, arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
             
            c = new int[N];
            arr = new int[N];
             
            st = new StringTokenizer(br.readLine());
             
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int LIS = 0;
 
            for (int i = 0; i < N; i++) {
                int idx = bs(arr[i], 0, LIS, LIS + 1);
                if(idx == -1) {
                    c[LIS++] = arr[i];
                }
                else {
                    c[idx] = arr[i];
                }
                 
            }
             
            sb.append('#').append(t).append(' ').append(LIS).append('\n');
        }
        System.out.print(sb);
    }
    public static int bs(int target, int low, int high, int size) {
        int res = 0;
        while (low <= high) {
            int mid = (low+high)/2;
            if (c[mid] >= target) {
                high = mid - 1;
                res = mid;
            }
            else {
                low = mid + 1;
            }
        }
        if (low == size) {
            return -1;
        }
        else {
            return res;         
        }
    }
}