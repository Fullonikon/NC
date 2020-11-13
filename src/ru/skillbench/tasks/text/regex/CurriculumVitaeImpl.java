package ru.skillbench.tasks.text.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurriculumVitaeImpl implements CurriculumVitae {
    private static final String NAME_PATTERN = "(([A-Z][a-z]*[a-z\\.]) ([A-Z][a-z]*[a-z\\.])( [A-Z][a-z]*[a-z\\.])?)";
    private String text;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        if (text == null) throw new IllegalStateException("Text not found");
        return text;
    }

    @Override
    public List<Phone> getPhones() {
        return parsePhones(getText());
    }

    @Override
    public String getFullName() {
        Matcher tmp = Pattern.compile(NAME_PATTERN).matcher(getText());
        if (!tmp.find()) throw new NoSuchElementException();
        return tmp.group(1);
    }

    @Override
    public String getFirstName() {
        Matcher tmp = Pattern.compile(NAME_PATTERN).matcher(getText());
        if (!tmp.find()) throw new NoSuchElementException();
        return tmp.group(2);
    }

    @Override
    public String getMiddleName() {
        Matcher tmp = Pattern.compile(NAME_PATTERN).matcher(getText());
        if (!tmp.find()) throw new NoSuchElementException();
        return tmp.group(3);
    }

    @Override
    public String getLastName() {
        Matcher tmp = Pattern.compile(NAME_PATTERN).matcher(getText());
        if (!tmp.find()) throw new NoSuchElementException();
        return tmp.group(4) == null ? "" : tmp.group(4).trim();
    }

    @Override
    public void updateLastName(String newLastName) {
        /*Matcher tmp = Pattern.compile(NAME_PATTERN).matcher(getText());
        if (!tmp.find()) throw new NoSuchElementException();
        this.text.replaceAll(tmp.group(3), newLastName);*/
        getText().replaceAll(getLastName(), newLastName);
    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {
        getText().replaceAll(oldPhone.toString(), newPhone.toString());
    }

    @Override
    public void hide(String piece) {

    }

    @Override
    public void hidePhone(String phone) {

    }

    @Override
    public int unhideAll() {
        return 0;
    }

    private List<Phone> parsePhones(String text) {
        List<Phone> res = new ArrayList<>();
        Matcher matcher = Pattern.compile(PHONE_PATTERN).matcher(text);
        while (matcher.find()) {
            int code = matcher.group(2) == null ? -1 : Integer.parseInt(matcher.group(2));
            int extension = matcher.group(7) == null ? -1 : Integer.parseInt(matcher.group(7));
            String number = matcher.group(3) + matcher.group(4) + matcher.group(5);
            res.add(new Phone(number, code, extension));
        }
        return res;
    }

}
