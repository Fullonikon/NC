package ru.skillbench.tasks.text.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternsImpl implements Patterns {
    @Override
    public Pattern getSQLIdentifierPattern() {
        return Pattern.compile("^[a-zA-Z]\\w{0,29}$");
    }

    @Override
    public Pattern getEmailPattern() {
        return Pattern.compile("^[a-zA-Z0-9]{1}([a-zA-Z0-9\\.\\-\\_]{0,20}[a-zA-Z0-9]){0,1}@[[:<:]][a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9][[:>:]]\\.(ru|com|net|org)");
    }

    @Override
    public Pattern getHrefTagPattern() {
        return null;
    }

    @Override
    public List<String> findAll(String input, Pattern pattern) {
        List<String> allMatches = new ArrayList<String>();
        Matcher m = pattern.matcher(input);
        while (m.find()) {
            allMatches.add(m.group());
        }
        return allMatches;
    }

    @Override
    public int countMatches(String input, String regex) {
        return findAll(input, Pattern.compile(regex)).size();
    }
}
