package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int N;
	static int[] primes2 = {1,3,7,9};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] primes = {2,3,5,7};
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < 4; i++) {
			check(primes[i], 1);
		}
	}
	public static void check(int n, int cnt) {
		if (cnt == N) {
			if (isPrime(n)) {
				System.out.println(n);
			}
			return;
		}
		if (isPrime(n)) {
			for (int i = 0; i < 4; i++) {
				check(n*10 + primes2[i], cnt+1);
			}
		}
	}
	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		else if (n == 2) {
			return true;
		}
		else {
			for (int i = 2; i < Math.sqrt(n); i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
}