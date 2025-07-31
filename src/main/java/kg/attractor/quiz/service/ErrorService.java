package kg.attractor.quiz.service;

import kg.attractor.quiz.exception.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {
    ErrorResponseBody makeResponse(BindingResult bindingResult);
}
