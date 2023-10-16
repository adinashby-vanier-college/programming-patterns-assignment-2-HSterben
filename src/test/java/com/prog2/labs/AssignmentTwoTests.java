package com.prog2.labs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * DO NOT MODIFY ANYTHING IN THIS FILE.
 */
class AssignmentTwoTests {

	@Test
	void solveNQueensTest1() {
		List<List<String>> actualList = AssignmentTwo.solveNQueens(4);
		String[][] actual = new String[actualList.size()][];
		String[] blankArray = new String[0];
		
		for(int i = 0; i < actualList.size(); i++) {
			actual[i] = actualList.get(i).toArray(blankArray);
		}

		String[][] expected = { { ".Q..", "...Q", "Q...", "..Q." }, { "..Q.", "Q...", "...Q", ".Q.." } };
		
		Arrays.sort(actual, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				return o1[0].compareTo(o2[0]);
			}
		});
		
		Arrays.sort(expected, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				return o1[0].compareTo(o2[0]);
			}
		});
		
		System.out.println(Arrays.deepToString(actual));
		System.out.println(Arrays.deepToString(expected));
		
		assertTrue(Arrays.deepEquals(actual, expected));
	}
	
	@Test
	void solveNQueensTest2() {
		List<List<String>> actualList = AssignmentTwo.solveNQueens(1);
		String[][] actual = new String[actualList.size()][];
		String[] blankArray = new String[0];
		
		for(int i = 0; i < actualList.size(); i++) {
			actual[i] = actualList.get(i).toArray(blankArray);
		}

		String[][] expected = { { "Q" }};
		
		Arrays.sort(actual, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				return o1[0].compareTo(o2[0]);
			}
		});
		
		Arrays.sort(expected, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				return o1[0].compareTo(o2[0]);
			}
		});
		
		System.out.println(Arrays.deepToString(actual));
		System.out.println(Arrays.deepToString(expected));
		
		assertTrue(Arrays.deepEquals(actual, expected));
	}
	
	@Test
	void ladderLengthTest1() {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" });
		
		assertEquals(5, AssignmentTwo.ladderLength(beginWord, endWord, wordList));
	}
	
	@Test
	void ladderLengthTest2() {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log" });
		
		assertEquals(0, AssignmentTwo.ladderLength(beginWord, endWord, wordList));
	}
	
}