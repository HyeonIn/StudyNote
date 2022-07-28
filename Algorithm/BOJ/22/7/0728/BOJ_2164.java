import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = n;
		boolean [] check = new boolean[n+1];

		boolean isDel = true;
		while(count > 1) {
			for (int i = 1; i <= n; i++) {
				if (!check[i]) {
					if (isDel) {
						count--;
						check[i] = true;
						isDel = false;
					}
					else {
						isDel = true;						
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!check[i]) {
				System.out.println(i);
			}
		}
		
		
		
		
	}
}
