import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	static int s;
	static int p;
	static char[] dna;
	static char[] d = {'A', 'C', 'G', 'T'};
	static HashMap<Character, Integer> count = new HashMap<>();
 	static HashMap<Character, Integer> minCount = new HashMap<>();

 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int answer = 0;
		
		
		s = Integer.parseInt(temp[0]);
		p = Integer.parseInt(temp[1]);
		
		dna = br.readLine().toCharArray();
		
		temp = br.readLine().split(" ");
		for (int i = 0; i < temp.length; i++) {
			minCount.put(d[i], Integer.parseInt(temp[i]));
			count.put(d[i], 0);
		}
		
		for (int i = 0; i < p; i++) {
			count.put(dna[i], count.get(dna[i]) + 1);
		}
		
		boolean add;
		int left = 0;
		for (int i = p; i < s; i++) {
			add = true;
			for (int j = 0; j < 4; j++) {
				if (count.get(d[j]) < minCount.get(d[j])) {
					add = false;
				}
			}
			if(add) {
				answer += 1;
			}
			count.put(dna[left], count.get(dna[left]) == 0 ? 0 : count.get(dna[left++])-1);
			
			count.put(dna[i], count.get(dna[i]) + 1);
		}
		add = true;
		
		for (int j = 0; j < 4; j++) {
			if (count.get(d[j]) < minCount.get(d[j])) {
				add = false;
			}
		}		
		System.out.println(add ? answer+1 : answer);
	}
}