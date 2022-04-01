package b10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer input = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(input.nextToken());

		List<Integer> ages = new LinkedList<>();
		List<String> names = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			input = new StringTokenizer(br.readLine());
			ages.add(Integer.parseInt(input.nextToken()));
			names.add(input.nextToken());
		}


		for (int i = 0; i < N; i++) {
			int minIdx = i;
			for (int j = i + 1; j < N; j++) {
				if (ages.get(minIdx) > ages.get(j))
					minIdx = j;
			}

			int tempAge = ages.get(minIdx);
			String tempName = names.get(minIdx);
			
			ages.add(i, ages.get(i));
			names.add(i, names.get(i));
			
			ages.remove(minIdx);
			names.remove(minIdx);
			
			ages.set(i, tempAge);
			names.set(i, tempName);
		}

		for (int i = 0; i < N; i++) {
			sb.append(ages.get(i)).append(" ").append(names.get(i)).append("\n");
		}
		
		System.out.print(sb);
		
	}
}
