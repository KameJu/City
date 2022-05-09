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
            storage.remove(from, to);
    }

    public ObservableList<City> getAll() {
        return storage;
    }

    public int size() {
        return storage.size();
    }

    public Integer getId(City city) {

        for (int i = 0; i < storage.size(); i++) {
            if (city.equals(storage.get(i))) {
                return i + 1;
            }
        }
        return 0;
    }
}
