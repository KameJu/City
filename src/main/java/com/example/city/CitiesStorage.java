package com.example.city;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public final class CitiesStorage {

    private final static CitiesStorage INSTANCE = new CitiesStorage();
    private final ObservableList<City> storage = FXCollections.observableArrayList();

    private CitiesStorage() {

    }

    public static CitiesStorage getInstance() {
        return INSTANCE;
    }

    public void add(City city) {
        city.setId(storage.size() + 1);
        storage.add(city);
    }

    public void addAll(int index , List<City> city) {
        storage.addAll(index, city);

    }

    public void remove(int index) {
        if (index >= 0 && index < storage.size()) {
            storage.remove(index);
        }
    }

    public void remove(int from, int to) {
        if (from <= to && from >= 0 && to < storage.size()) {
            storage.remove(from, to);
        }
    }

    public ObservableList<City> getAll() {
        return storage;
    }

    public int size() {
        return storage.size();
    }

//    public void updateId() {
//        int counter = 1;
//
//        for (City city : storage) {
//            city.setId(counter++);
//        }
//    }
}
