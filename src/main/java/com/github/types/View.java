package com.github.types;

import java.util.Objects;

public class View {
    public double x1;
    public double x2;
    public double y1;
    public double y2;
    public int maxIter;

    public View(double x1, double x2, double y1, double y2, int maxIter) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.maxIter = maxIter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        View view = (View) o;
        return Double.compare(view.x1, x1) == 0 &&
                Double.compare(view.x2, x2) == 0 &&
                Double.compare(view.y1, y1) == 0 &&
                Double.compare(view.y2, y2) == 0 &&
                maxIter == view.maxIter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2, y1, y2, maxIter);
    }
}
