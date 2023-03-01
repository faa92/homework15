package by.tms.antonfedoseev.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {
    private String[] badWords;
    public TextBlackListFilter(String badWords) {
        this.badWords = badWords.split(", ");
    }
    public boolean hasBadWords(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Enter text!");
        }
        for (int i = 0; i < badWords.length; i++) {
            boolean res;
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(badWords[i]) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS |
                            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(text);
            res = matcher.find();
            if (res) {
                return true;
            }
        }
        return false;
    }
    public int getCountBadWords(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Enter text!");
        }
        int count = 0;
        for (int i = 0; i < badWords.length; i++) {
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(badWords[i]) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS |
                            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                count++;
            }
        }
        return count;
    }
    public String hideBadWords(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Enter text!");
        }
        for (int i = 0; i < badWords.length; i++) {
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(badWords[i]) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS |
                            Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            text = text.replaceAll(badWords[i], "####");
        }
        return text;
    }
}
