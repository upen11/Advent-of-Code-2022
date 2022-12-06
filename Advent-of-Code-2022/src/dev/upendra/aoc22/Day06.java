package dev.upendra.aoc22;

import java.util.List;

public class Day06 extends AOCBaseCode {

	public Day06() {
		super("6");
	}

	@Override
	void solve(List<String> input) {

		String code = input.get(0);

//		Part 1: 1235, Duration: 662µs
		part(code, 4);

//		Part 2: 3051, Duration: 1.58ms
		part(code, 14);

	}

	private void part(String code, int marker) {
		int found = 0;
		for (int i = 0; i < code.length() - marker; i++) {
			int[] arr = new int[26];
			int count = 0;
			for (int j = i; j < (i + marker); j++) {
				int ind = code.charAt(j) - 'a';

				if (arr[ind] == 0) {
					arr[ind] = 1;
					count++;
				} else if (arr[ind] == 1) {
					break;
				}

			}

			if (count == marker) {
				found = i + marker;
				break;
			}
		}

		lap(found);
	}

}
