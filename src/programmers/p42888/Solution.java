package programmers.p42888;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		String[] input = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		System.out.println(solution(input));
	}

	public static String[] solution(String[] record) {
		String[] answer;
		
		List<String[]> bufOrder = new ArrayList<>();
		Map<String, String> userData = new HashMap<>();

		for (String r : record) {
			String[] orderData = r.split(" ");

			switch (orderData[0]) {
			case "Enter":
				userData.put(orderData[1], orderData[2]);
				String[] e = { orderData[0], orderData[1] };
				bufOrder.add(e);
				break;
			case "Leave":
				String[] l = { orderData[0], orderData[1] };
				bufOrder.add(l);
				break;
			case "Change":
				userData.put(orderData[1], orderData[2]);
				break;
			}
		}

		answer = new String[bufOrder.size()];
		for (int i = 0; i < bufOrder.size(); i++) {
			String[] o = bufOrder.get(i);
			switch (o[0]) {
			case "Enter":
				answer[i] = userData.get(o[1]) + "님이 들어왔습니다.";
				break;
			case "Leave":
				answer[i] = userData.get(o[1]) + "님이 나갔습니다.";
				break;
			}
		}

		return answer;
	}
}
