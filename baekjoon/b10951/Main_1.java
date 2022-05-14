package b10951;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;

		while ((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			bw.write(A + B + " ");
		}
		
		bw.flush();

	}
}
