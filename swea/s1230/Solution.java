
package swea.s1230;

import java.util.Scanner;

public class Solution {

	static class MyLinkedList {
		Node head;
		int size;

		public Node search(int idx) {
			if (idx < 0 || idx >= size) {
				System.out.println("잘못된 idx");
				return null;
			}

			Node curr = head;
			for (int i = 0; i < idx; i++) {
				curr = curr.link;
			}

			return curr;
		}

		public void addToFirst(int data) {
			Node newNode = new Node(data);

			newNode.link = head;
			head = newNode;

			size++;
		}

		public void addToLast(int data) {
			if (size == 0) {
				head = new Node(data);
			} else {
				Node newNode = new Node(data);
				Node curr = search(size - 1);
				curr.link = newNode;
			}

			size++;
		}

		public void add(int idx, int data) {
			if (idx < 0 || idx >= size) {
				System.out.println("잘못된 idx");
				return;
			}
			if (idx == 0) {
				addToFirst(data);
			}

			Node newNode = new Node(data);
			Node pre = search(idx - 1);
			newNode.link = pre.link;
			pre.link = newNode;

			size++;
		}

		public void addManyToLast(int[] data) {
			MyLinkedList tempNodes = new MyLinkedList();
			for (int d : data) {
				tempNodes.addToLast(d);
			}

			if (size == 0)
				head = tempNodes.head;
			else {
				Node curr = head;
				while (curr.link != null)
					curr = curr.link;
				curr.link = tempNodes.head;
			}

			size += data.length;
		}

		public void addMany(int idx, int[] data) {
			MyLinkedList tempNodes = new MyLinkedList();
			for (int d : data) {
				tempNodes.addToLast(d);
			}

			if (idx < 0 || idx >= size) {
				System.out.println("잘못된 idx");
				return;
			}

			if (idx == 0) {
				tempNodes.search(tempNodes.size - 1).link = head;
				head = tempNodes.head;
			} else {
				Node pre = search(idx - 1);

				tempNodes.search(tempNodes.size - 1).link = pre.link;
				pre.link = tempNodes.head;
			}

			size += data.length;
		}

		public Integer removeFromFirst() {
			Node ret = head;
			head = head.link;
			size--;
			return ret.data;
		}

		public Integer remove(int idx) {
			if (idx < 0 || idx >= size) {
				System.out.println("잘못된 idx");
				return -1;
			}
			if (idx == 0)
				removeFromFirst();

			Node pre = search(idx);
			Node ret = search(idx + 1);

			pre.link = pre.link.link;
			size--;
			return ret.data;
		}

		public boolean isEmpty() {
			return head == null;
		}

		public String removeTen() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				sb.append(this.removeFromFirst());
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			size -= 10;
			return sb.toString();
		}

	}

	public static class Node {
		public int data;
		public Node link; // ??? NullPointerException ???

		public Node(int data) {
			super();
			this.data = data;
			this.link = null;
		}

		public Node getLink() {
			return link;
		}

		public void setLink(Node link) {
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", link=" + link + "]";
		}
	}

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			MyLinkedList list = new MyLinkedList();
			for (int n = 0; n < N; n++) {
				list.addToLast(input.nextInt());
			}

			int M = input.nextInt();
			for (int m = 0; m < M; m++) {
				int O = input.next().charAt(0);
				switch (O) {
				case 'I':
					int Xi = input.nextInt();
					int Yi = input.nextInt();
					int[] dataI = new int[Yi];
					for (int i = 0; i < Yi; i++) {
						dataI[i] = input.nextInt();
					}

					list.addMany(Xi, dataI);
					break;
				case 'D':
					int Xd = input.nextInt();
					int Yd = input.nextInt();
					for (int y = 0; y < Yd; y++) {
						list.remove(Xd);
					}
					break;
				case 'A':
					int Ya = input.nextInt();
					int[] dataA = new int[Ya];
					for (int y = 0; y < Ya; y++) {
						dataA[y] = input.nextInt();
					}

					list.addManyToLast(dataA);
				}
			}

			System.out.printf("#%d ", tc);
			System.out.println(list.removeTen());

		}

	}

}