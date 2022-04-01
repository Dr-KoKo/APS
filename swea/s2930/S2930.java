package s2930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2930 {
	static class HeapByUser {
		private int[] data;
		public int size;
		public int maxSize;

		HeapByUser() {
			data = new int[10 + 1];
			data[0] = Integer.MAX_VALUE;
			maxSize = 10;
		}

		public void insert(int param) {
			if (size == maxSize) {
				int[] newData = new int[maxSize * 2 + 1];
				System.arraycopy(data, 0, newData, 0, maxSize);
				data = newData;
				maxSize *= 2;
			}

			data[++size] = param;
			
			int target = size;
			while (true) {
				if(data[target] <= data[target / 2])
					break;
				swap(target, target / 2);
				target /= 2;
			}
		}

		public int pop() {
			if (isEmpty())
				return -1;

			int ret = data[1];
			data[1] = data[size--];
			
			int target = 1;
			while (true) {
				int child = target * 2;
				
				if(child>size||(data[child] <= data[target]&&data[child + 1] <= data[target]))
					break;
				
				if (data[child] >= data[child + 1] && data[child] > data[target]) {
					swap(target, child);
					target = child;
				} else if (data[child] < data[child + 1] && data[child + 1] > data[target]) {
					swap(target, child + 1);
					target = child + 1;
				}
			}

			return ret;
		}

		private boolean isEmpty() {
			return size == 0;
		}

		private void swap(int idx_1, int idx_2) {
			int temp = data[idx_1];
			data[idx_1] = data[idx_2];
			data[idx_2] = temp;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer input = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(input.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc);

			HeapByUser myHeap = new HeapByUser();

			input = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(input.nextToken());
			for (int n = 0; n < N; n++) {
				input = new StringTokenizer(br.readLine());
				int order =Integer.parseInt(input.nextToken()); 
				if (order==1) {
					myHeap.insert(Integer.parseInt(input.nextToken()));
				} else if(order==2)
					sb.append(" ").append(myHeap.pop());
				
			}
			sb.append("\n");

		}

		System.out.print(sb);

	}

}
