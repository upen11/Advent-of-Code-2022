package dev.upendra.aoc22;

import java.util.List;

public class Day03 extends AOCBaseCode {

	public Day03() {
		super("3");
	}

	@Override
	void solve(List<String> input) {

		part1(input);
		part2(input);
	}

//	Part 1: 7674, Duration: 637µs
	private void part1(List<String> input) {
		int[] arr;

		int sum = 0;

		for (String s : input) {
			arr = new int[53];

			int mid = s.length() / 2;

			fillArray(arr, s, mid);

			int comm = findCommon(arr, s, mid);

			sum += comm;

		}

		lap(sum);
	}

//	Part 2: 2805, Duration: 17.403ms
//	Part 2: 2805, Duration: 7.144ms using break in z for loop if(s1.charAt(x) != s2.charAt(y)) 
	private void part2(List<String> input) {
		
		int sum = 0;
		for(int i=0; i<input.size()-2; i+=3) {
			int value = 0;
			String s1 = input.get(i);
			String s2 = input.get(i+1);
			String s3 = input.get(i+2);
			
			for(int x=0; x<s1.length(); x++) {
				for(int y=0; y<s2.length(); y++) {
					for(int z=0; z<s3.length(); z++) {
						if(s1.charAt(x) != s2.charAt(y)) break;
						if((s3.charAt(z) == s2.charAt(y)) && (s3.charAt(z) == s1.charAt(x)) ) {
							value = alphaValue(s1.charAt(x));
							break;
						}
					}
				}
			}
			
			sum += value;
		}
		
		lap(sum);
	}

	private void fillArray(int[] arr, String s, int end) {
		for (int i = 0; i < end; i++) {
			char ch = s.charAt(i);

			int c = alphaValue(ch);

			arr[c] = arr[c] + 1;

		}

	}

	private int alphaValue(char ch) {
		int c = 0;
		if (ch >= 'a' && ch <= 'z') {
			c = ch - 96;
		} else if (ch >= 'A' && ch <= 'Z') {
			c = ch - 64 + 26;
		}
		return c;
	}

	private int findCommon(int[] arr, String s, int initial) {
		for (int i = initial; i < s.length(); i++) {
			char ch = s.charAt(i);

			int c = alphaValue(ch);

			if (arr[c] != 0) {
				return c;
			}

		}
		return -1;
	}

}