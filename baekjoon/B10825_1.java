package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B10825_1 {
    private static int N;
    private static Student[] students;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        Arrays.sort(students);
        print();
    }

    private static void print() {
        Arrays.stream(students).forEach(x->sb.append(x.name).append('\n'));
        System.out.println(sb);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        students = new Student[N];
        for(int i = 0; i < N; i++){
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();

            students[i] = new Student(name, kor, eng, math);
        }
    }

    private static class Student implements Comparable<Student>{
        private String name;
        private int kor, eng, math;

        public Student(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(o.kor==this.kor){
                if(o.eng==this.eng){
                    if(o.math==this.math){
                        return this.name.compareTo(o.name);
                    }
                    return o.math-this.math;
                }
                return this.eng-o.eng;
            }
            return o.kor-this.kor;
        }
    }
}
