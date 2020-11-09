package ru.skillbench.tasks.text;

import java.io.PrintStream;
import java.util.*;

public class WordCounterIMPL implements WordCounter {

    String text;
    Map<String, Long> words = new HashMap<>();

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Map<String, Long> getWordCounts() {
        if (text == null)  {
            throw new IllegalStateException();
        }
        String[] wrds = text.split(" ");
        for (int i = 0; i < wrds.length; i++) {
            words.putIfAbsent(wrds[i].toLowerCase(), 0L);
            if (words.containsKey(wrds[i])) {
                words.put(wrds[i], words.get(wrds[i]) + 1);
            }
        }
        return words;
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {
        ArrayList<String> tmp  = new ArrayList<>(words.keySet());
        Collections.sort(tmp);
        Map<String, Long> tmp1 = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            tmp1.put(tmp.get(i), words.get(tmp.get(i)));
        }

        List<Map.Entry<String, Long>> res = new ArrayList<>(tmp1.entrySet());
        return null;
    }

    @Override
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K, V>> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        return null;
    }

    @Override
    public <K, V> void print(List<Map.Entry<K, V>> entries, PrintStream ps) {

    }
}
