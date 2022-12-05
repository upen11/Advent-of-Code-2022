package dev.upendra.aoc22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 extends AOCBaseCode {

	public Day01() {
		super("1");
	}
	
	@Override
	void solve(List<String> input) {
//		System.out.println(input);
		List<Integer> calories = new ArrayList<>();
		
		int sum = 0;
		int max = 0;
//		int elfNum = 0;
//		int ans = 0;
		for(String i : input) {
			if(!i.trim().equals("")) {
				sum += Integer.parseInt(i);
			}
			else {
				calories.add(sum);
//				elfNum++;
				if(sum > max) {
					max = sum;
//					ans = elfNum;
				}
				sum = 0;
			}
		}
		
		lap(max);

		Collections.sort(calories);
		
		// descending
		// calories.sort((a, b) -> b - a);
		
		int n = calories.size()-1;
		
		lap(calories.get(n) + calories.get(n-1) + calories.get(n-2));
	}
}
