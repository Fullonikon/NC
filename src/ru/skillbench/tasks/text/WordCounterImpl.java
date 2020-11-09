package ru.skillbench.tasks.text;

import java.io.PrintStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounterImpl implements WordCounter {

    String text;
    private Map<String, Long> words = new HashMap<>();

    @Override
    public void setText(String text) {
        if (text == null)  {
            throw new IllegalStateException("Text not found");
        }
        this.text = text;
        Pattern pattern = Pattern.compile("<.*>");
        String[] wrds = text.trim().split("\\s+|\\n+|\\t");
        for (int i = 0; i < wrds.length; i++) {
            Matcher matcher = pattern.matcher(wrds[i]);
            if (matcher.matches()) continue;
            words.putIfAbsent(wrds[i].toLowerCase(), 0L);
            if (words.containsKey(wrds[i].toLowerCase())) {
                words.put(wrds[i].toLowerCase(), words.get(wrds[i].toLowerCase()) + 1);
            }
        }
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Map<String, Long> getWordCounts() {
        return words;
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {
        return sort(words, (e1, e2) -> {
            int res = e2.getValue().compareTo(e1.getValue());
            if (res == 0) return e1.getKey().compareTo(e2.getKey());
            return res;
        });
    }

    @Override
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K, V>> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>(comparator);
        sortedEntries.addAll(map.entrySet());
        return new ArrayList<>(sortedEntries);
    }

    @Override
    public <K, V> void print(List<Map.Entry<K, V>> entries, PrintStream ps) {
        entries.forEach((entry) -> ps.printf("%s %s%n", entry.getKey(), entry.getValue()));
    }
}
