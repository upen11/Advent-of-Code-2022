package dev.upendra.aoc22;

import java.util.List;

public class Day04 extends AOCBaseCode {

	public Day04() {
		super("4");
	}

	@Override
	void solve(List<String> input) {

//		Part 1: 413, Duration: 1.931ms
		int count = 0;
		for (String s : input) {

			int dash = s.indexOf('-');
			int comma = s.indexOf(',');

			int a = Integer.parseInt(s.substring(0, dash));
			int b = Integer.parseInt(s.substring(dash + 1, comma));

			String sec = s.substring(comma + 1);

			int dash2 = sec.indexOf('-');

			int x = Integer.parseInt(sec.substring(0, dash2));
			int y = Integer.parseInt(sec.substring(dash2 + 1));

			if (((a <= x && b >= y) || ((x <= a && y >= b)))) {
				count++;
			}
		}

		lap(count);

		part2(input);
	}

//	Part 2: 806, Duration: 737µs
	private void part2(List<String> input) {
		int count = 0;
		for (String s : input) {

			int dash = s.indexOf('-');
			int comma = s.indexOf(',');

			int a = Integer.parseInt(s.substring(0, dash));
			int b = Integer.parseInt(s.substring(dash + 1, comma));

			String sec = s.substring(comma + 1);

			int dash2 = sec.indexOf('-');

			int x = Integer.parseInt(sec.substring(0, dash2));
			int y = Integer.parseInt(sec.substring(dash2 + 1));

			if (((a <= x && b >= x) || ((a <= y && b >= y)))) {
				count++;
			}
			else if (((x <= a && y >= a) || ((y <= a && y >= b)))) {
				count++;
			}
		}

		lap(count);

	}
}
