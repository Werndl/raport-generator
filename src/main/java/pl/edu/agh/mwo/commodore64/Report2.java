package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.TreeMap;

// alfabetyczna lista projektów za dany rok
// sumaryczna liczba godzin w danym roku
// tabelka: nazwa projektu, liczba godzin

public class Report2 {

    private ArrayList<Task> project = new ArrayList<>();
    private TreeMap<String, Double> workingHours = new TreeMap<>();

    public Report2(ArrayList<Task> dataModel, String project, String year)  {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(project + " | liczba godzin w roku " + year);
        }

    private void fillReport() {
        for (Task t : project) {
            String key = makeCompoundKey(t.getMonth(), t.getProject());
            if (workingHours.containsKey(key)) {

                double dayHours = workingHours.get(key) + Double.parseDouble(t.getHours());
                workingHours.replace(key, dayHours);
            } else {
                workingHours.put(key, Double.parseDouble(t.getHours()));
            }
        }
    }
}