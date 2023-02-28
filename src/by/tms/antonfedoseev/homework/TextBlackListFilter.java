package by.tms.antonfedoseev.homework;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {
    private String[] badWords;

    public TextBlackListFilter(String... badWords) {
        this.badWords = Arrays.copyOf(badWords, badWords.length);
    }

    public boolean hasBadWords(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Enter text!");
        }
        for (int i = 0; i < badWords.length; i++) {
            boolean res;
            Pattern pattern = Pattern.compile("\\b" + badWords[i] + "\\b", Pattern.UNICODE_CHARACTER_CLASS |
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
            Pattern pattern = Pattern.compile("\\b" + badWords[i] + "\\b", Pattern.UNICODE_CHARACTER_CLASS |
                    Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
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
            Pattern pattern = Pattern.compile("\\b" + badWords[i] + "\\b", Pattern.UNICODE_CHARACTER_CLASS |
                    Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            text = matcher.replaceAll("####");
        }
        return text;
    }

//    public Pattern getPattern (String text) {
//        return Pattern.compile("\\b" + badWords[i] + "\\b", Pattern.UNICODE_CHARACTER_CLASS |
//                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
//    }


}
