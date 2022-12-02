package dev.upendra.aoc22;

import java.util.List;

public class Day02 extends AOCBaseCode {

	public Day02() {
		super("2");
	}

	@Override
	void solve(List<String> input) {

		// Part 1

		// opponent: Values
		// A for Rock, 1
		// B for Paper 2
		// C for Scissors 3

		// me: Rock (X), Paper (Y), Scissor (Z)

		// win gives 6, defeat 0, draw 3. Each outcome is added with the weapons value
		// i.e win gives (value + 6)
		long score = 0;
		for (String i : input) {
			char opp = i.charAt(0);
			char me = i.charAt(2);

			if ((opp == 'A' && me == 'Y') || (opp == 'B' && me == 'Z') || (opp == 'C' && me == 'X')) {
				score += ((int) me - 87 + 6);
			} else if ((opp == 'A' && me == 'X') || (opp == 'B' && me == 'Y') || (opp == 'C' && me == 'Z')) {
				score += ((int) me - 87 + 3);
			} else {
				score += ((int) me - 87);
			}
		}

		lap(score);

		// Part 2
		// X means lose the round
		// Y means draw the round
		// Z means win the round

		long score2 = 0;
		for (String i : input) {
			char opp = i.charAt(0);
			char outcome = i.charAt(2);
			char me;

			if (outcome == 'Z') { // win
				if (opp == 'A')
					me = 'Y';
				else if (opp == 'B')
					me = 'Z';
				else
					me = 'X';

				score2 += ((int) me - 87 + 6);
			} else if (outcome == 'Y') { // draw
				score2 += ((int) opp - 64 + 3);
			} else { // loss
				if (opp == 'A')
					me = 'Z';
				else if (opp == 'B')
					me = 'X';
				else
					me = 'Y';
				score2 += (int) me - 87;
			}
		}

		lap(score2);

	}
}