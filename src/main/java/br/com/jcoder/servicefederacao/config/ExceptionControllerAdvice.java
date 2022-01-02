package br.com.jcoder.servicefederacao.config;

import br.com.jcoder.servicefederacao.dto.response.Error;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.NoResultException;
import java.util.Locale;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @Value("${springdoc.swagger-ui.path}")
    private String urlDocumentation;

    @Hidden
    @ResponseBody
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error objetoNaoEncotrado(NoResultException e){
        return new Error("X_100", e.getMessage(), urlDocumentation);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error parametroInvalido(MethodArgumentTypeMismatchException e){
        return new Error("X_200", "Parâmetro Inválido.", urlDocumentation);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error parametroNulo(MethodArgumentNotValidException e){
        String mensagensError = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> "A propriedade "+fieldError.getField().toUpperCase(Locale.ROOT) + " - " + fieldError.getDefaultMessage())
                .collect(Collectors.joining());
        return new Error("X_300", mensagensError, urlDocumentation);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error OutrasExceptions(Exception e){
       return new Error("X_400", e.getMessage(), urlDocumentation);
    }
}
