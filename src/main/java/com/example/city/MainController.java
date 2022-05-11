package com.example.city;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.city.CitiesStorage.getInstance;

public class MainController {

    @FXML
    private ListView<City> listView;
    @FXML
    private HBox additional;


    @FXML
    private void initialize() {
        getInstance().addListener( listener -> showAdditional());

        getInstance().add(new City("Москва", "Россия", 1F, 1F, (byte) 1, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        getInstance().add(new City("Буча", "Украина", 1F, 1F, (byte) 3, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        getInstance().add(new City("Ирпень", "Украина", 1F, 1F, (byte) 3, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        getInstance().add(new City("Киев", "Украина", 1F, 1F, (byte) 1, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        getInstance().add(new City("Мелитополь", "Украина", 1F, 1F, (byte) 3, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        getInstance().add(new City("Херосн", "Украина", 1F, 1F, (byte) 1, 200, true, 1950, false, "Пупкин Иван Васильевич"));
        listView.getItems().addAll(getInstance().getAll());

        listView.setItems(getInstance().getAll());
        listView.setCellFactory(new CityCellFactory());
    }

    @FXML
    private void addCityDialog() throws IOException {
        openUpDialog("add_city.fxml");
    }

    @FXML
    private void addMultipleDialog() throws IOException {
        openUpDialog("add_city_multiple.fxml");
    }

    @FXML
    private void editDialog() throws IOException {
        openUpDialog("edit_city.fxml");
    }

    @FXML
    private void removeCityDialog() throws IOException {
        openUpDialog("remove_city.fxml");
    }

    @FXML
    private void removeCityMultipleDialog() throws IOException {
        openUpDialog("remove_city_multiple.fxml");
    }

    @FXML
    private void searchDialog() throws IOException {
        openUpDialog("search_city.fxml");
    }

    private void showAdditional() {
        additional.setVisible(getInstance().size() > 0);
        listView.setVisible(getInstance().size() > 0);
    }

    private void openUpDialog(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(AddCityController.class.getResource(path));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);

        stage.show();
    }

}