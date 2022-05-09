package com.example.city;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.city.CitiesStorage.getInstance;

public class MainController {

    @FXML
    private ListView<City> listView;


    @FXML
    private void initialize() {
        getInstance().add(new City(1,"Москва", "Россия", 1F, 1F, (byte) 1, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        getInstance().add(new City(2,"Буча", "Украина", 1F, 1F, (byte) 3, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        getInstance().add(new City(3,"Ирпень", "Украина", 1F, 1F, (byte) 3, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        getInstance().add(new City(4,"Киев", "Украина", 1F, 1F, (byte) 1, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        getInstance().add(new City(5,"Мелитополь", "Украина", 1F, 1F, (byte) 3, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        getInstance().add(new City(6, "Херосн", "Украина", 1F, 1F, (byte) 1, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        listView.getItems().addAll(getInstance().getAll());

        listView.setItems(getInstance().getAll());
        listView.setCellFactory(new CityCellFactory());
    }

    @FXML
    public void addCityDialog() throws IOException {
        openUpDialog("add_city.fxml", 600, 322);
    }

    @FXML
    public void addMultipleDialog() throws IOException {
        openUpDialog("add_city_multiple.fxml", 335, 218);
    }

    private void openUpDialog(String path, int width, int height) throws IOException {
        FXMLLoader loader = new FXMLLoader(AddCityController.class.getResource(path));
        Scene scene = new Scene(loader.load(), width, height);
        Stage stage = new Stage();
        stage.setScene(scene);

        stage.show();
    }
}