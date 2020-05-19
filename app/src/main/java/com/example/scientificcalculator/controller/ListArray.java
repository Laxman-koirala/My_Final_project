package com.example.scientificcalculator.controller;
import java.util.ArrayList;
import java.util.List;

public class ListArray {
    public ArrayList<String> list;

    public void saveTohistory(String finalCalculation) {
        list.add(finalCalculation);

    }
}
