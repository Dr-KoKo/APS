package b1402;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int i = 0; i < T; i++) {
			invertable(input.nextInt(), input.nextInt());
		}

	}

	public static boolean invertable(int a, int b) {
		for (int i = 1; i < b; i++) {
			//�뿬湲� �옉�꽦�븯�뒗 以�
		}
		
		
		return true;
	}

	
//	public static boolean invertable(int a, int b) {
//		List<Integer> list = cal(a);
//		for (int i = 0; i < list.size(); i++) {
//			
//		}
//
//		return true;
//	}
//
//	public static List<Integer> cal(int a) {
//
//		List<Integer> list = new LinkedList<>();
//
//		for (int i = 2; i < Math.sqrt(a); i++) {
//			if (a % i == 0)
//				list.add(i);
//		}
//		return list;
//	}

}
