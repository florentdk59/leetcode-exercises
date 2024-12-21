package com.florent.leetcode.longestsubstring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LongestSubstringSolutionTest {

    @Nested
    class LengthOfLongestSubstring {

        @ParameterizedTest
        @CsvSource({
                "abcabcbb, abc",
                "bbbbb, b",
                "pwwkew, kew",
                "abcdaea, bcdae"
        })
        void shouldFindSizeOfLongestNonRepeatingChars(String completeString, String expectedSubstring) {
            var result = new LongestSubstringSolution().lengthOfLongestSubstring(completeString);
            log.info("shouldFindSizeOfLongestNonRepeatingChars : result({}) -> {}",  completeString, result);

            assertThat(result).isEqualTo(expectedSubstring.length());
        }

    }

}