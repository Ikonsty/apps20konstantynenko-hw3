package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] elements;
    private String description;

    public BaseArray(Object [] elements) {
        this.elements = elements;
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    @Override
    public String operationDescription() {
        return description;
    }

    @Override
    public int size() {
        return elements.length;
    }
}
