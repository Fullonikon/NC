package ru.skillbench.tasks.javaapi.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class StringFilterImpl implements StringFilter {

    private final HashSet<String> words = new HashSet<>();

    @Override
    public void add(String s) {
        words.add(s == null ? null : s.toLowerCase());
    }

    @Override
    public boolean remove(String s) {
        return words.remove(s);
    }

    @Override
    public void removeAll() {
        words.clear();
    }

    @Override
    public Collection<String> getCollection() {
        return words;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {
        if (chars == null || chars.isEmpty()) return words.iterator();
        return words.stream()
                .filter((word) -> (new Filter() {
                    @Override
                    public boolean matches(String str) {
                        return false;
                    }
                }).matches(chars)).iterator();
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        if (begin == null || begin.isEmpty()) return words.iterator();
        return words.stream()
                .filter((word) -> (new Filter() {
                    @Override
                    public boolean matches(String str) {
                        return false;
                    }
                }).matches(begin)).iterator();
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        if (format == null || format.isEmpty()) return words.iterator();
        return words.stream()
                .filter((word) -> (new Filter() {
                    @Override
                    public boolean matches(String str) {
                        return false;
                    }
                }).matches(format)).iterator();
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        if (pattern == null || pattern.isEmpty()) return words.iterator();
        return words.stream()
                .filter((word) -> (new Filter() {
                    @Override
                    public boolean matches(String str) {
                        return false;
                    }
                }).matches(pattern)).iterator();
    }


    private interface Filter {
        boolean matches(String str);
    }

}
