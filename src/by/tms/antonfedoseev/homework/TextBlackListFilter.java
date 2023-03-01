package by.tms.antonfedoseev.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {
    private String[] badWords;
    private final Pattern[] pattern;
    public TextBlackListFilter(String badWords) {
        this.badWords = badWords.split(", ");
        this.pattern = new Pattern[badWords.length()];
        for (int i = 0; i < badWords.length(); i++) {
            pattern[i] = Pattern.compile("\\b" + Pattern.quote(badWords) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS |
                            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        }
    }

    public boolean hasBadWords(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Enter text!");
        }
//        for (Pattern goodPattern : pattern) {
//            Matcher matcher = goodPattern.matcher(text);
//            if (matcher.find()) {
//                return true;
//            }
//        }

        for (int i = 0; i < badWords.length; i++) {
            Pattern pattern = this.pattern[text.length()];
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
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
            Pattern pattern = this.pattern[text.length()];
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                if (matcher.find()) {
                    count++;
                }
            }
        }
        return count;
    }
    public String hideBadWords(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Enter text!");
        }
        for (int i = 0; i < badWords.length; i++) {
            Pattern pattern = this.pattern[text.length()];
            Matcher matcher = pattern.matcher(text);
            text = text.replaceAll(Pattern.quote(String.valueOf(matcher)), "####");
        }
        return text;
    }
}
