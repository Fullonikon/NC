package ru.skillbench.tasks.text;


import ru.skillbench.tasks.javaapi.collections.StringFilterImpl;
import ru.skillbench.tasks.text.regex.CurriculumVitaeImpl;
import ru.skillbench.tasks.text.regex.PatternsImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        CurriculumVitaeImpl test = new CurriculumVitaeImpl();
        test.setText("Raz Smith \n\n (916)125-4171 495 926-93-47 ext.1846");

        System.out.println(test.getFullName());
        System.out.println(test.getLastName());
        System.out.println(test.getPhones());

    }

}
