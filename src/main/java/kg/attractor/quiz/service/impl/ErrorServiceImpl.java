package kg.attractor.quiz.service.impl;


import kg.attractor.quiz.exception.ErrorResponseBody;
import kg.attractor.quiz.service.ErrorService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ErrorServiceImpl implements ErrorService {
    @Override
    public ErrorResponseBody makeResponse(BindingResult bindingResult) {
        Map<String, List<String>> reasons = new HashMap<>();

        bindingResult.getFieldErrors().stream()
                .filter(e -> e.getDefaultMessage() != null)
                .forEach(e -> {
                    List<String> errors = new ArrayList<>();
                    errors.add(e.getDefaultMessage());
                    if( !reasons.containsKey(e.getField())) {
                        reasons.put(e.getField(), errors);
                    }
                });

        return ErrorResponseBody.builder()
                .title("Validation errors")
                .response(reasons)
                .build();
    }
}
