// 부동소수점 오차를 해결해야 함, double이나 float을 사용하면 부동소수점 오차가 발생
// 따라서 BigDecimal을 이용하여 계산

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main{
	static class stat {
		BigDecimal a, s, cr, crA, ag;


		public stat(BigDecimal a, BigDecimal s, BigDecimal cr, BigDecimal crA, BigDecimal ag) {
			super();
			this.a = a;
			this.s = s;
			this.cr = cr;
			this.crA = crA;
			this.ag = ag;
		}
		
		
	}	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp;
		stat[] stats = new stat[4];
		for (int i = 0; i < 4; i++) {
			temp = br.readLine().split(" ");
			BigDecimal a = new BigDecimal(temp[0]);
			BigDecimal s = new BigDecimal(temp[1]);
			BigDecimal cr = new BigDecimal(temp[2]).divide(new BigDecimal("100.0"));
			BigDecimal crA = new BigDecimal(temp[3]).divide(new BigDecimal("100.0"));
			BigDecimal ag = new BigDecimal(temp[4]).divide(new BigDecimal("100.0"));
			stats[i] = new stat(a,s,cr,crA,ag);
		}
		if (getPower(stats[0]).doubleValue() > getPower(getPlus(getDiff(stats[0], stats[2]), stats[3])).doubleValue()) {
			System.out.println("-");
		}
		else if (getPower(stats[0]).doubleValue() < getPower(getPlus(getDiff(stats[0], stats[2]), stats[3])).doubleValue()) {
			System.out.println("+");
		}
		else {
			System.out.println("0");
		}
		if (getPower(stats[1]).doubleValue() > getPower(getPlus(getDiff(stats[1], stats[3]), stats[2])).doubleValue()) {
			System.out.println("-");
		}
		else if (getPower(stats[1]).doubleValue() < getPower(getPlus(getDiff(stats[1], stats[3]), stats[2])).doubleValue()) {
			System.out.println("+");
		}
		else {
			System.out.println("0");
		}
		
	}
	public static BigDecimal getPower(stat s) {
		BigDecimal bigFirst = s.a;
		BigDecimal bigSecond = s.s.divide(new BigDecimal("100.0")).add(new BigDecimal("1.0"));
		BigDecimal bigThird = new BigDecimal("1.0").subtract(new BigDecimal(Double.min(s.cr.doubleValue(), 1.0)+"")).add(new BigDecimal(Double.min(s.cr.doubleValue(), 1.0)+"").multiply(s.crA));
		BigDecimal bigLast = s.ag.add(new BigDecimal("1.0"));		
		return bigFirst.multiply(bigSecond.multiply(bigThird.multiply(bigLast))); 
	}
	public static stat getDiff(stat s1, stat s2) {
		return new stat(s1.a.subtract(s2.a), s1.s.subtract(s2.s), s1.cr.subtract(s2.cr), s1.crA.subtract(s2.crA), s1.ag.subtract(s2.ag));
	}
	public static stat getPlus(stat s1, stat s2) {
		return new stat(s1.a.add(s2.a), s1.s.add(s2.s), s1.cr.add(s2.cr), s1.crA.add(s2.crA), s1.ag.add(s2.ag));		
	}
}