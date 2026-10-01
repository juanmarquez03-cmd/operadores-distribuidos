package co.uptc.ejercicio11.exeption;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

/**
 * Intercepta las excepciones lanzadas en cualquier capa y las traduce
 * a respuestas HTTP consistentes para el cliente.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DivisionPorCeroException.class)
    public ResponseEntity<ErrorResponse> manejarDivisionPorCero(DivisionPorCeroException ex,
                                                                HttpServletRequest request) {
        return construirRespuesta(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler(OperacionNoSoportadaException.class)
    public ResponseEntity<ErrorResponse> manejarOperacionNoSoportada(OperacionNoSoportadaException ex,
                                                                     HttpServletRequest request) {
        return construirRespuesta(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler(CalculadoraException.class)
    public ResponseEntity<ErrorResponse> manejarCalculadoraException(CalculadoraException ex,
                                                                     HttpServletRequest request) {
        return construirRespuesta(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> manejarValidacion(MethodArgumentNotValidException ex,
                                                           HttpServletRequest request) {
        String mensaje = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return construirRespuesta(HttpStatus.BAD_REQUEST, mensaje, request);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> manejarTipoInvalido(MethodArgumentTypeMismatchException ex,
                                                              HttpServletRequest request) {
        String mensaje = "El parámetro '" + ex.getName() + "' tiene un valor inválido: " + ex.getValue();
        return construirRespuesta(HttpStatus.BAD_REQUEST, mensaje, request);
    }

    @ExceptionHandler(PersonaNoEncontradaException.class)
    public ResponseEntity<ErrorResponse> manejarPersonaNoEncontrada(PersonaNoEncontradaException ex,
                                                                    HttpServletRequest request) {
        return construirRespuesta(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorResponse> manejarBaseDatosNoDisponible(DataAccessException ex,
                                                                      HttpServletRequest request) {
        return construirRespuesta(HttpStatus.SERVICE_UNAVAILABLE,
                "No fue posible consultar la base de datos de personas", request);
    }

    @ExceptionHandler(PersonaException.class)
    public ResponseEntity<ErrorResponse> manejarPersonaException(PersonaException ex,
                                                                  HttpServletRequest request) {
        return construirRespuesta(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> manejarErrorGeneral(Exception ex, HttpServletRequest request) {
        return construirRespuesta(HttpStatus.INTERNAL_SERVER_ERROR,
                "Ocurrió un error inesperado: " + ex.getMessage(), request);
    }

    private ResponseEntity<ErrorResponse> construirRespuesta(HttpStatus status, String mensaje,
                                                             HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                mensaje,
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(error);
    }
}
