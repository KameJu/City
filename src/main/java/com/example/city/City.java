package com.example.city;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class City implements Observable {
    private String name;
    private String country;
    private Float latitudeCoordinate;
    private Float longitudeCoordinate;
    private byte status;
    private int citizenCount;
    private boolean isSeaside;
    private int creationYear;
    private boolean isHaveRiver;
    private String fullNameOfMayor;

    public City(
            String name,
            String country,
            float latitudeCoordinate,
            float longitudeCoordinate,
            byte status,
            int citizenCount,
            boolean isSeaside,
            int creationYear,
            boolean isHaveRiver,
            String fullNameOfMayor
    ) {
        this.name = name;
        this.country = country;
        this.latitudeCoordinate = latitudeCoordinate;
        this.longitudeCoordinate = longitudeCoordinate;
        this.status = status;
        this.citizenCount = citizenCount;
        this.isSeaside = isSeaside;
        this.creationYear = creationYear;
        this.isHaveRiver = isHaveRiver;
        this.fullNameOfMayor = fullNameOfMayor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Float getLatitudeCoordinate() {
        return latitudeCoordinate;
    }

    public void setLatitudeCoordinate(float latitudeCoordinate) {
        this.latitudeCoordinate = latitudeCoordinate;
    }

    public Float getLongitudeCoordinate() {
        return longitudeCoordinate;
    }

    public void setLongitudeCoordinate(float longitudeCoordinate) {
        this.longitudeCoordinate = longitudeCoordinate;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getCitizenCount() {
        return citizenCount;
    }

    public void setCitizenCount(int citizenCount) {
        this.citizenCount = citizenCount;
    }

    public boolean isSeaside() {
        return isSeaside;
    }

    public void setSeaside(boolean seaside) {
        isSeaside = seaside;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public boolean isHaveRiver() {
        return isHaveRiver;
    }

    public void setHaveRiver(boolean haveRiver) {
        isHaveRiver = haveRiver;
    }

    public String getFullNameOfMayor() {
        return fullNameOfMayor;
    }

    public void setFullNameOfMayor(String fullNameOfMayor) {
        this.fullNameOfMayor = fullNameOfMayor;
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
