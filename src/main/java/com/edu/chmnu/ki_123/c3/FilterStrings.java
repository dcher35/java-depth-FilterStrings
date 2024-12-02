package com.edu.chmnu.ki_123.c3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStrings {
    public static void main(String[] args) {
        String[] words = {"banana", "day", "laptop", "6832", "lesson"};

        String filteredSentence = Arrays.stream(words)
                .filter(word -> !isNumber(word))
                .collect(Collectors.joining(" "));
        System.out.println("Filtered sentence: " + filteredSentence);

        String sentence = "banana day 1431 hi 28234";

        List<String> matchingWords = Arrays.stream(sentence.split("\\s+")).filter(FilterStrings::isNumber).toList();
        System.out.println("Matching Words: " + matchingWords);
    }

    private static boolean isNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}