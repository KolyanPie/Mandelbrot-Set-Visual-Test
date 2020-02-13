package com.github.types;

public class Complex implements Cloneable {
    private double realPart;
    private double imaginaryPart;

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double module_square() {
        return realPart * realPart + imaginaryPart * imaginaryPart;
    }

    public Complex add(Complex complex) {
        realPart += complex.realPart;
        imaginaryPart += complex.imaginaryPart;
        return this;
    }

    public Complex multiply(Complex complex) {
        double real = realPart * complex.getRealPart() - imaginaryPart * complex.getImaginaryPart();
        imaginaryPart = realPart * complex.imaginaryPart + imaginaryPart * complex.getRealPart();
        realPart = real;
        return this;
    }

    @Override
    public Complex clone() {
        return new Complex(realPart, imaginaryPart);
    }
}
