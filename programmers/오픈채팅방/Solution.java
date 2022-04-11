package 오픈채팅방;

public class Solution {

	public static int solution(String s) {

		int ans = Integer.MAX_VALUE;

		for (int len = 1; len <= s.length() / 2; len++) {

			int ret = s.length()-check(len, s)+1;
			
//			ans = Math.max(ans, );

		}

		return ans;

	}

	private static int check(int len, String s) {

		int cnt = 0;
		int cntChange = 0;

		String subStr = s.substring(0, len);
		int idx = len;
		while (idx < s.length()) {
			String nextStr = s.substring(idx, idx + len);

			if (subStr.equals(nextStr)) {
				++cnt;
			} else {
				subStr = nextStr;
				++cntChange;
			}

			idx += len;

		}

		return len * cnt;
	}
}
