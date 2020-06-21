package pl.edu.agh.mwo.commodore64;

import java.util.*;

public class Report2 {

    private TreeMap<String, Double> reportDatas = new TreeMap<String, Double>();
    private ArrayList<Task> filtredDatas = new ArrayList<Task>();
    private double temp;

    public Report2(ArrayList<Task> tasks, String yearFilter){
        for (Task i: tasks) {
            if(i.getYear() == yearFilter) {
                filtredDatas.add(i);
            }
        }
        fillReport();
        printReport();
    }

    private void fillReport() {

        for (Task i: filtredDatas) {
            if (reportDatas.containsKey(i.getProject()) == true)
            {
                temp = reportDatas.get(i.getProject()) + Double.parseDouble(i.getHours());
                reportDatas.replace(i.getProject(), temp);
            }
            else {
                reportDatas.put(i.getProject(),Double.parseDouble(i.getHours()));
            }
        }
    }

    private void printReport() {

        Collection toPrint = reportDatas.entrySet();
        Iterator element = toPrint.iterator();
        while(element.hasNext()) {System.out.println(element.next());}
        System.out.println("raport 2");
    }
}