package by.tms.antonfedoseev.homework;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {
    private static final String MASK = "####";
    private String[] badWords;
    private final Pattern[] patterns;

    public TextBlackListFilter(String... badWords) {
        this.badWords = Arrays.copyOf(badWords, badWords.length);
        this.patterns = new Pattern[badWords.length];
        for (int i = 0; i < badWords.length; i++) {
            patterns[i] = Pattern.compile("\\b" + Pattern.quote(badWords[i]) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS |
                            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        }
    }

    public boolean hasBadWords(String text) {
        for (int i = 0; i < badWords.length; i++) {
            Pattern pattern = this.patterns[i];
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }
    public int getCountBadWords(String text) {
        int count = 0;
        for (int i = 0; i < badWords.length; i++) {
            Pattern pattern = this.patterns[i];
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                    count++;
            }
        }
        return count;
    }

    public String hideBadWords(String text) {
        String result = text;
        for (int i = 0; i < badWords.length; i++) {
            Pattern pattern = this.patterns[i];
            Matcher matcher = pattern.matcher(text);
            result = matcher.replaceAll(MASK);
        }
        return result;
    }
}
