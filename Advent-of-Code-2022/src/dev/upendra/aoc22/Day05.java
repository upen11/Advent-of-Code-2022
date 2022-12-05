package dev.upendra.aoc22;

import java.util.ArrayList;
import java.util.List;

public class Day05 extends AOCBaseCode {

	public Day05() {
		super("5");
	}

	@Override
	void solve(List<String> input) {
		
		List<List<Character>> stacks = new ArrayList<>();
		
//		The returned list is backed by this list, so non-structural changes 
//		in the returned list are reflected in this list, and vice-versa. 
//		The returned list supports all of the optional list operations.
		List<String> sublist1 = input.subList(0, 8);
		
		
/*			[N]         [C]     [Z]            
			[Q] [G]     [V]     [S]         [V]
			[L] [C]     [M]     [T]     [W] [L]
			[S] [H]     [L]     [C] [D] [H] [S]
			[C] [V] [F] [D]     [D] [B] [Q] [F]
			[Z] [T] [Z] [T] [C] [J] [G] [S] [Q]
			[P] [P] [C] [W] [W] [F] [W] [J] [C]
			[T] [L] [D] [G] [P] [P] [V] [N] [R]
			 1   2   3   4   5   6   7   8   9 
	*/
		for(int i=0; i<9; i++) {
			stacks.add(new ArrayList<>());
		}
		
		
		for(String s : sublist1) {
			
			int inputIndex = 1;
			int stackIndex = 0;
			while(inputIndex < s.length()) {
				char ch = s.charAt(inputIndex);
				
				if(ch != ' ') {
					stacks.get(stackIndex).add(0, ch);	// new values will go to starting index
				}
				
				inputIndex += 4;
				stackIndex++;
			}
		}
		
		List<String> sublist2 = input.subList(10, input.size());
		

//		List<List<Character>> stacksCopy = new ArrayList<>(stacks); will not work, same reference
		
//		copying original list for part 2
		List<List<Character>> stacksCopy = new ArrayList<>();
		
		for(List<Character> list : stacks) {
			stacksCopy.add(new ArrayList<>(list));
		}
		
		for(String s : sublist2) {
//			0123456789..     17
//			move 6 from 2 to 1
//			but move number can be greater than 9, better to split
			String[] instructions = s.split(" ");
			
			int moves = Integer.parseInt(instructions[1]);
			int from = Integer.parseInt(instructions[3]) - 1;
			int to = Integer.parseInt(instructions[5]) - 1;
			
			List<Character> fromStack = stacks.get(from);
			List<Character> toStack = stacks.get(to);
			
//			Part 1: SVFDLGLWV, Duration: 3.36ms
			for(int i=0; i<moves; i++) {
				if(!fromStack.isEmpty()) {
					toStack.add(fromStack.remove(fromStack.size()-1));
				}
			}
			
//			Part 2: DCVTCVPCL, Duration: 7µs
			List<Character> fromStack2 = stacksCopy.get(from);
			List<Character> toStack2 = stacksCopy.get(to);
			List<Character> moving = new ArrayList<>();
			
			for(int i=0; i<moves; i++) {
				if(!fromStack2.isEmpty()) {
					moving.add(0, fromStack2.remove(fromStack2.size() - 1)); // will store from (end-moves to end) i.e from back
				}
			}
			
			toStack2.addAll(moving);	// at last add in to
			
		}
		
		printAns(stacks);
		printAns(stacksCopy);
	}
	

	private void printAns(List<List<Character>> list) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<list.size(); i++) {
			List<Character> stack = list.get(i);
			sb.append(stack.get(stack.size()-1));
		}
		
		lap(sb.toString());
	
	}
	
}
