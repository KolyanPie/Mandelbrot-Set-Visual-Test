package com.github.fx;

import javafx.scene.control.TextField;

public class DoubleTextField extends TextField {
    public DoubleTextField() {
        super();
        init();
    }

    public DoubleTextField(String text) {
        super(text);
        init();
    }

    private void init() {
        textProperty().addListener((observable, oldValue, newValue) -> {

        });
    }

    public double getDouble() {
        return Double.parseDouble(getText());
    }

    public void setDouble(double text) {
        setText(String.valueOf(text));
    }
}
