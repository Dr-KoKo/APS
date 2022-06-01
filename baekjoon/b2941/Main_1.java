package b2941;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String str = input.next();
		String[] chart = {"c=", "c-", "dz=", "d-","lj","nj","s=","z="};
		for (int i = 0; i < chart.length; i++) {
			str.replace(chart[i], "!");
		}
		
		System.out.println(str.length());
	}
}
