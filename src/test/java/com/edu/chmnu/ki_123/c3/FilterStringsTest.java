package com.edu.chmnu.ki_123.c3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OutWordsTest {
    private static boolean isNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Тест для перевірки фільтрування слів в рядку
    @Test
    void testFilterWords() {
        String[] words = {"banana", "day", "laptop", "6832", "lesson"};

        String result = Arrays.stream(words).filter(word -> !isNumber(word)).collect(Collectors.joining(" "));

        assertEquals("banana day laptop lesson", result);
    }

    // Тест перевірки методу пошуку всіх чисел в заданому реченні
    @Test
    public void testFindMatchingWords() {
        String sentence = "banana day 1431 hi 28234";
        List<String> matchingWords = Arrays.stream(sentence.split("\\s+")).filter(OutWordsTest::isNumber).collect(Collectors.toList());

        assertEquals(List.of("1431", "28234"), matchingWords);
    }
}
