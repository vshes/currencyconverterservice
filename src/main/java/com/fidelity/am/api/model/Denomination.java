package com.fidelity.am.api.model;


public class Denomination {
    private int value;
    private String description;


    public Denomination() {
    }

    public Denomination(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Denomination{" +
                "value=" + value +
                ", description='" + description + '\'' +
                '}';
    }
}
