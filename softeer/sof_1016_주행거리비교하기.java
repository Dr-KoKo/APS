package softeer;

import java.util.Scanner;

public class sof_1016_주행거리비교하기 {
    private static int A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        if(A>B)
            System.out.println("A");
        else if(A<B)
            System.out.println("B");
        else
            System.out.println("same");
    }
}
