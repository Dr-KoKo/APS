package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sof_804_플레이페어암호_1 {
    private static char[][] table;
    private static boolean[] check;
    private static String message;
    private static String key;

    private static StringBuilder sb;
    private static StringBuilder encryption;

    public static void main(String[] args) throws IOException {
        input();
        generateTable();
        encryptMessage();
        print();
    }

    private static void print() {
        System.out.println(encryption);
    }

    private static void encryptMessage() {
        processMessage();
        encrypt();
    }

    private static void encrypt() {
        encryption = new StringBuilder();

        for (int i = 0; i < message.length(); i += 2) {
            char pre = message.charAt(i);
            char post = message.charAt(i + 1);

            int preNum = -1;
            int postNum = -1;

            for (int j1 = 0; j1 < 5; j1++) {
                for (int j2 = 0; j2 < 5; j2++) {
                    if (table[j1][j2] == pre)
                        preNum = j1 * 5 + j2;
                    if (table[j1][j2] == post) {
                        postNum = j1 * 5 + j2;
                    }
                }
            }

            if (preNum / 5 == postNum / 5) {
                pre = table[preNum / 5][(preNum + 1) % 5];
                post = table[postNum / 5][(postNum + 1) % 5];
            } else if (preNum % 5 == postNum % 5) {
                pre = table[(preNum / 5 + 1) % 5][preNum % 5];
                post = table[(postNum / 5 + 1) % 5][postNum % 5];
            } else {
                pre = table[preNum / 5][postNum % 5];
                post = table[postNum / 5][preNum % 5];
            }

            encryption.append(pre).append(post);
        }
    }

    private static void processMessage() {
        sb = new StringBuilder();

        for (int i = 0; i < message.length(); i += 2) {
            if (i == message.length() - 1) {
                sb.append(message.charAt(i)).append('X');
                break;
            }

            if (message.charAt(i) == message.charAt(i + 1)) {
                if (message.charAt(i) == 'X') {
                    sb.append(message.charAt(i)).append('Q');
                } else {
                    sb.append(message.charAt(i)).append('X');
                }
                i--;
            } else {
                sb.append(message.charAt(i)).append(message.charAt(i + 1));
            }
        }

        message = sb.toString();
        System.out.println(message);
    }

    private static void generateTable() {
        initialize();

        Queue<Character> tempQueue = new LinkedList<>();

        for (char ch : key.toCharArray()) {
            if (check[ch - 'A']) {
                continue;
            }

            check[ch - 'A'] = true;

            tempQueue.add(ch);
        }

        for (int i = 0; i < 26; i++) {
            if (!check[i]) {
                tempQueue.add((char) ('A' + i));
            }
        }

        for (int i = 0; i < 25; i++) {
            table[i / 5][i % 5] = tempQueue.poll();
        }
    }

    private static void initialize() {
        table = new char[5][5];
        check = new boolean[26];
        check['J' - 'A'] = true;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        message = br.readLine();
        key = br.readLine();

        br.close();
    }
}
