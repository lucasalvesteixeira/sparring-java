package generics;

public class CustomStackFullException extends RuntimeException {
    public CustomStackFullException(Object pushValue) {
        super("Stack is full, cannot push " + pushValue);
    }
}