package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	static ArrayDeque<Long> gostack;
	static ArrayList<String[]> program;
	static int n, size;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		while(!temp[0].equals("QUIT")) {
			size = 0;
			
			program = new ArrayList<>();
			sb = new StringBuilder();
			while (!temp[0].equals("END")) {
				program.add(temp);
				size++;
				temp = br.readLine().split(" ");
			}
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				gostack = new ArrayDeque<>();
				Long v = (long) Integer.parseInt(br.readLine());
				gostack.add(v);
				machine();
			}
			System.out.println(sb);
			br.readLine();
			temp = br.readLine().split(" ");
		}
	}
	public static void machine() {	
		boolean err = false;
		for (int i = 0; i < size; i++) {
			
			if (program.get(i)[0].equals("NUM")) {
				gostack.add((long) Integer.parseInt(program.get(i)[1]));
			}
			else if (program.get(i)[0].equals("POP")) {
				if (gostack.isEmpty()) {
					sb.append("ERROR\n");
					err= true;
					break;
				}
				else {
					gostack.pollLast();
				}
			}
			else if (program.get(i)[0].equals("INV")) {
				if (gostack.isEmpty()) {
					sb.append("ERROR\n");
					err= true;
					break;
				}
				else {
					long x = gostack.pollLast();
					gostack.add(x*-1);
				}
			}
			else if (program.get(i)[0].equals("DUP")) {
				if (gostack.isEmpty()) {
					sb.append("ERROR\n");
					err= true;
					break;
				}
				else {
					gostack.add(gostack.getLast());
				}
			}
			else if (program.get(i)[0].equals("SWP")) {
				if (gostack.isEmpty()) {
					sb.append("ERROR\n");
					err= true;
					break;
				}
				else {
					long x = gostack.pollLast();
					long y = gostack.pollLast();
					gostack.add(x);
					gostack.add(y);
				}
			}
			else if (program.get(i)[0].equals("ADD")) {
				if (gostack.isEmpty() || gostack.size() == 1) {
					sb.append("ERROR\n");
					err= true;
					break;
				}
				else {
					long x = gostack.pollLast();
					long y = gostack.pollLast();
					if (Math.abs(x+y) > 1000000000) {
						sb.append("ERROR\n");
						err= true;
						break;
					}
					else {
						gostack.add(x+y);
					}
					 
				}
			}
			else if (program.get(i)[0].equals("SUB")) {
				if (gostack.isEmpty() || gostack.size() == 1) {
					sb.append("ERROR\n");
					err= true;
					break;
				}
				else {
					long x = gostack.pollLast();
					long y = gostack.pollLast();
					if (Math.abs(y-x) > 1000000000) {
						sb.append("ERROR\n");
						err= true;
						break;
					}
					else {
						gostack.add(y-x);
					}
				}
			}
			else if (program.get(i)[0].equals("MUL")) {
				if (gostack.isEmpty() || gostack.size() == 1) {
					sb.append("ERROR\n");
					err= true;
					break;
				}
				else {
					long x = gostack.pollLast();
					long y = gostack.pollLast();
					if (Math.abs(x*y) > 1000000000) {
						sb.append("ERROR\n");
						err= true;
						break;
					}
					else {
						gostack.add(x*y);
					}
				}
			}
			else if (program.get(i)[0].equals("DIV")) {
				if (gostack.isEmpty() || gostack.size() == 1) {
					sb.append("ERROR\n");
					err= true;
					break;
				}
				else {
					long x = gostack.pollLast();
					long y = gostack.pollLast();
					if (x == 0) {
						sb.append("ERROR\n");
						err= true;
						break;
					}
					gostack.add(y/x);
				}
			}
			else if (program.get(i)[0].equals("MOD")) {
				if (gostack.isEmpty() || gostack.size() == 1) {
					sb.append("ERROR\n");
					err= true;
					break;
				}
				else {
					long x = gostack.pollLast();
					long y = gostack.pollLast();
					if (x == 0) {
						sb.append("ERROR\n");
						err= true;
						break;
					}
					gostack.add(y%x);
				}
			}
			
		}
		if (!err) {
			if (gostack.size() == 1) {
				sb.append(gostack.poll()).append('\n');
			}
			else {
				sb.append("ERROR\n");
			}
		}
		
		
	}
}

