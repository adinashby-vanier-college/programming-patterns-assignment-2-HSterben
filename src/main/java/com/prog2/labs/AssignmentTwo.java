package com.prog2.labs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author adinashby
 *
 */
public class AssignmentTwo {

    /**
     * Write your test code below in the main (optional).
     *
     */
    public static void main(String[] args) {

    }

    /**
     * Please refer to the README file for question(s) description
     */
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // Initialize the board with all dots representing empty spaces.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> solutions = new ArrayList<>();
        // Start the backtracking process from the first row.
        backtrack(0, board, solutions);
        return solutions;
    }

    static void backtrack(int row, char[][] board, List<List<String>> solutions) {
        if (row == board.length) {
            // If the last row is reached, a solution is found.
            solutions.add(createSolution(board));
            return;
        }

        // Try placing a queen in each column of the current row.
        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, solutions);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    static boolean isSafe(int row, int col, char[][] board) {
        // Check the column, and both diagonals for any existing queens.
        for (int i = 0; i < row; i++) {
            // Column
            if (board[i][col] == 'Q') {
                return false;
            }
        }
            // Diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // It's safe if no queens can attack the position
        return true;
    }

    static List<String> createSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            String rowString = new String(row);
            solution.add(rowString);
        }
        return solution;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            // If the endWord is not in the wordList, there is no possible answer
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1; // The transformation sequence length starts at 1.

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of elements at the current level.
            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll(); // Get the next word to process.
                if (currentWord.equals(endWord)) {
                    return level; // If the endWord is reached, return the sequence length.
                }

                // Find and queue all surroundings (words that are one letter different).
                List<String> surroundings = getSurroundings(currentWord, wordSet);
                for (String neighbor : surroundings) {
                    queue.add(neighbor);
                }
            }
            // Increment the level (sequence length) after processing all words at the current level.
            level++;
        }

        // Return 0 if the endWord cannot be reached.
        return 0;
    }

    static List<String> getSurroundings(String word, HashSet<String> wordSet) {
        List<String> surroundings = new ArrayList<>();
        char[] chars = word.toCharArray();

        // Change each character of the word and check if the new word is in wordSet.
        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) {
                    // Skip if the character is the same.
                    continue; 
                }
                chars[i] = c;
                String newWord = String.valueOf(chars);
                if (wordSet.remove(newWord)) { // Use the word only once
                    // If the word is in the set, add it to surroundings.
                    surroundings.add(newWord);
                }
            }
            chars[i] = originalChar; // Restore original word
        }
        // Return the list of surroundings.
        return surroundings;
    }
}
