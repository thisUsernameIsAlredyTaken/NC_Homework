package com.nchomework.classes;

public class MyComplex {

    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
        real = 0.0;
        imag = 0.0;
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        setReal(real);
        setImag(imag);
    }

    @Override
    public String toString() {
        return "(" + getReal() + " + " + getImag() + "i)";
    }

    public boolean isReal() {
        return getImag() == 0.0 && getReal() != 0.0;
    }

    public boolean isImaginary() {
        return getReal() == 0.0 && getImag() != 0.0;
    }

    public boolean equals(double real, double imag) {
        return getReal() == real &&  getImag() == imag;
    }

    public boolean equals(Object another) {
        MyComplex c = (MyComplex) another;
        return equals(c.getReal(), c.getImag());
    }

    public double magnitude() {
        return Math.sqrt(getReal() * getReal() + getImag() * getImag());
    }

    public double argument() {
        return Math.atan2(getImag(), getReal());
    }

    public MyComplex add(MyComplex right) {
        setReal(getReal() + right.getReal());
        setImag(getImag() + right.getImag());
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        MyComplex result = new MyComplex(getReal(), getImag());
        result.add(right);
        return result;
    }

    public MyComplex subtract(MyComplex right) {
        setReal(getReal() - right.getReal());
        setImag(getImag() - right.getImag());
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        MyComplex result = new MyComplex(getReal(), getImag());
        result.subtract(right);
        return result;
    }

    public MyComplex multiply(MyComplex right) {
        double a = getReal(), b = getImag();
        double c = right.getReal(), d = right.getImag();
        setReal(a * c - b * d);
        setImag(a * d + b * c);

        return this;
    }

    public MyComplex divide(MyComplex right) {
        double a = getReal(), b = getImag();
        double c = getReal(), d = getImag();
        setReal((c*a + b*d) / (c*c + d*d));
        setImag((b*c - a*d) / (c*c + d*d));

        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(getReal(), -1 * getImag());
    }
}
