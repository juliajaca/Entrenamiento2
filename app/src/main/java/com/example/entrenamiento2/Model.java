package com.example.entrenamiento2;

public class Model {
    String title;
    int imageId;

    public Model(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public Model(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
