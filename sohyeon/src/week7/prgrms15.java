package week7;
import java.util.*;

public class prgrms15 {
	public int solution(String s) {
		String res = remove(s.split(""));
		return res.length() == 0 ? 1 : 0;
	}

	private String remove(String[] arr) {
		ArrayList<String> al = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (al.size() < 1) al.add(arr[i]);
			else {
				if (al.get(al.size()-1).equals(arr[i])) {
					al.remove(al.size()-1);
				} else al.add(arr[i]);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < al.size(); i++) {
			sb.append(al.get(i));
		}
		return sb.toString();
	}
}
