package ua.edu.ucu.smartarr;

public interface SmartArray {

    Object[] toArray(); // return array with SmartArray elements

    String operationDescription(); // return current operation name
    
    int size(); // return SmartArray size

}
