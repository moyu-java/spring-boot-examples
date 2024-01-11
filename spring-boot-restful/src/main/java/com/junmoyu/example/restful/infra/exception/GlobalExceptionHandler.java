package com.junmoyu.example.restful.infra.exception;

import com.junmoyu.example.restful.model.base.Response;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 全局异常捕获处理
 *
 * @author 莫语
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected Response<String> handleExceptionHandler(final Exception exception) {
        log.error(exception.getMessage(), exception);
        return Response.failure(exception.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    protected Response<String> handleDuplicateKeyException(final DuplicateKeyException exception) {
        log.error("duplicate key exception", exception);
        return Response.failure("unique index conflict, please enter again");
    }

    @ExceptionHandler(NullPointerException.class)
    protected Response<String> handleNullPointException(final NullPointerException exception) {
        log.error("null pointer exception", exception);
        return Response.failure("null pointer exception");
    }

    @ExceptionHandler(ClassNotFoundException.class)
    protected Response<String> handleClassNotFoundException(final ClassNotFoundException exception) {
        log.warn("class not found exception", exception);
        return Response.failure("class not found exception");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected Response<String> handleHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException exception) {
        log.warn("http request method not supported", exception);
        StringBuilder sb = new StringBuilder();
        sb.append(exception.getMethod());
        sb.append(" method is not supported for this request. Supported methods are ");
        Objects.requireNonNull(exception.getSupportedHttpMethods()).forEach(t -> sb.append(t).append(" "));
        return Response.failure(sb.toString());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected Response<String> handleMissingServletRequestParameterException(final MissingServletRequestParameterException exception) {
        log.warn("missing servlet request parameter", exception);
        return Response.failure(String.format("%s parameter is missing", exception.getParameterName()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected Response<String> handlerMethodArgumentNotValidException(final MethodArgumentNotValidException exception) {
        log.error("method argument not valid exception", exception);
        List<String> errorMessages = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        return Response.failure(errorMessages.get(0));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected Response<String> handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException exception) {
        log.warn("method argument type mismatch", exception);
        return Response.failure(String.format("%s should be of type %s", exception.getName(),
                Objects.requireNonNull(exception.getRequiredType()).getName()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected Response<String> handleConstraintViolationException(final ConstraintViolationException exception) {
        log.warn("constraint violation exception", exception);
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        return Response.failure(violations.stream()
                .map(v -> v.getPropertyPath().toString().concat(": ").concat(v.getMessage()))
                .collect(Collectors.joining("| ")));
    }
}
