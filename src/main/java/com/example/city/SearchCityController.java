package com.example.city;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;

import static com.example.city.CitiesStorage.getInstance;

public class SearchCityController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField country;
    @FXML
    private TextField latitudeCoordinate;
    @FXML
    private TextField longitudeCoordinate;
    @FXML
    private CheckBox districtCenter;
    @FXML
    private CheckBox regionalCenter;
    @FXML
    private CheckBox capital;
    @FXML
    private RadioButton isSeaside;
    @FXML
    private RadioButton isHaveRiver;
    @FXML
    private TextField fullNameOfMayor;

    @FXML
    private ListView<City> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setCellFactory(new CityCellFactory());
        search();
    }

    //поиск по фильтрам
    @FXML
    private void search() {
        List<City> cities = getInstance().getAll().stream().toList();


        String name = this.name.getCharacters().toString();
        String country = this.country.getCharacters().toString();
        String latitude = latitudeCoordinate.getCharacters().toString();
        String longitude = longitudeCoordinate.getCharacters().toString();
        boolean district =  districtCenter.isSelected();
        boolean regional = regionalCenter.isSelected();
        boolean capital = this.capital.isSelected();
        boolean isSeaside = this.isSeaside.isSelected();
        boolean isHaveRiver = this.isHaveRiver.isSelected();
        String fullNameOfMayor = this.fullNameOfMayor.getCharacters().toString();

        if (!name.isEmpty()) {
            cities = search(cities, "name="+name);
        }
        if (!country.isEmpty()) {
            cities = search(cities, "country="+country);
        }
        if (!latitude.isEmpty()) {
            cities = search(cities, "latitudeCoordinate="+latitude);
        }
        if (!longitude.isEmpty()) {
            cities = search(cities, "longitudeCoordinate="+longitude);
        }
        if (district) {
            cities = search(cities, "status=2");
        }
        if (regional) {
            cities = search(cities, "status=3");
        }
        if (capital) {
            cities = search(cities, "status=1");
        }
        if (isSeaside) {
            cities = search(cities, "isSeaside=true");
        }
        if (isHaveRiver) {
            cities = search(cities, "isHaveRiver=true");
        }
        if (!fullNameOfMayor.isEmpty()) {
            cities = search(cities, "fullNameOfMayor="+fullNameOfMayor);
        }

        updateList(cities);
    }

    private List<City> search(List<City> cities, String property) {
        return  cities.stream().filter(item -> item.toString().contains(property)).toList();
    }

    private void updateList(List<City> cities) {
        listView.getItems().clear();
        listView.getItems().addAll(cities);
    }

    @FXML
    private void districtAction() {
        regionalCenter.setSelected(false);
        capital.setSelected(false);
        search();
    }

    @FXML
    private void regionalAction() {
        districtCenter.setSelected(false);
        capital.setSelected(false);
        search();
    }

    @FXML
    private void capitalAction() {
        districtCenter.setSelected(false);
        regionalCenter.setSelected(false);
        search();
    }


}
