package b2869;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

//		Scanner input = new Scanner(System.in);
//
//		int a = input.nextInt(); // a
//		int amb = a - input.nextInt(); // a-b
//		int vma = input.nextInt() - a; // v-a

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(str.nextToken());
		int amb = a - Integer.parseInt(str.nextToken());
		int vma = Integer.parseInt(str.nextToken()) - a;

		if (vma <= 0)
			System.out.println(1);
		else if (vma % amb == 0)
			System.out.println(vma / amb + 1);
		else
			System.out.println(vma / amb + 2);

	}
}
