package com.example.city;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class CityCellFactory implements Callback<ListView<City>, ListCell<City>> {

    @Override
    public ListCell<City> call(ListView<City> cityListView) {
        return new CityCell();
    }
}
