package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class user{
	int age;
	String name;
	
	public user(int age, String name) {
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return age+" "+name;
	}
}
class MyComparator implements Comparator<user>{
	@Override
	public int compare(user u1, user u2) {
		if (u1.age > u2.age) {
			return 1;
		}
		else if (u1.age < u2.age) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<user> users = new ArrayList<>();
		
		int n = sc.nextInt();
		
	
		
		for (int i = 0; i < n; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			users.add(new user(age, name));
		}
		MyComparator mc = new MyComparator();
		Collections.sort(users, mc);
		
		for (user u : users) {
			System.out.println(u);
		}
	
	}

}
