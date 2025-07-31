package kg.attractor.quiz.exception;

import java.util.NoSuchElementException;

public class NotFoundException extends NoSuchElementException {
    public NotFoundException() {
        super("Not found");
    }
}
