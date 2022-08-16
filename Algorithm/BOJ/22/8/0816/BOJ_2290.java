package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] nums;
	static int s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		s = Integer.parseInt(temp[0]);
		nums = temp[1].toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			switch (nums[i]) {
			case '1':
			case '4':
				for (int j = 0; j < s+3; j++) {
					sb.append(' ');
				}
				break;
			default:
				sb.append(' ');
				for (int j = 0; j < s; j++) {
					sb.append('-');
				}
				sb.append("  ");
				break;
			}
		}
		sb.append('\n');
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < nums.length; j++) {
				switch (nums[j]) {
				case '1':
				case '2':
				case '3':
				case '7':
					for (int k = 0; k < s+1; k++) {
						sb.append(' ');
					}
					sb.append('|').append(' ');
					break;
				case '5':
				case '6':
					sb.append('|');
					for (int k = 0; k < s+2; k++) {
						sb.append(' ');
					}
					break;
				default:
					sb.append('|');
					for (int k = 0; k < s; k++) {
						sb.append(' ');
					}
					sb.append('|').append(' ');
					break;
				}
			}
			sb.append('\n');
		}
		for (int i = 0; i < nums.length; i++) {
			switch (nums[i]) {
			case '1':
			case '7':
			case '0':
				for (int j = 0; j < s+3; j++) {
					sb.append(' ');
				}
				break;
			default:
				sb.append(' ');
				for (int j = 0; j < s; j++) {
					sb.append('-');
				}
				sb.append("  ");
				break;
			}
		}
		sb.append('\n');
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < nums.length; j++) {
				switch (nums[j]) {
				case '2':
					sb.append('|');
					for (int k = 0; k < s+2; k++) {
						sb.append(' ');
					}
					break;
				case '6':
				case '8':
				case '0':
					sb.append('|');
					for (int k = 0; k < s; k++) {
						sb.append(' ');
					}
					sb.append("| ");
					break;
				default:
					for (int k = 0; k < s+1; k++) {
						sb.append(' ');
					}
					sb.append('|').append(' ');
					break;
				}
			}
			sb.append('\n');
		}
		for (int i = 0; i < nums.length; i++) {
			switch (nums[i]) {
			case '1':
			case '4':
			case '7':
				for (int j = 0; j < s+3; j++) {
					sb.append(' ');
				}
				break;
			default:
				sb.append(' ');
				for (int j = 0; j < s; j++) {
					sb.append('-');
				}
				sb.append("  ");
				break;
			}
		}
		System.out.println(sb);
		
	}
}

