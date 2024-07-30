package com.workintech.S18D1.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   // Bu anatasyon sayesinde tüm controller lar merkezi bir yerden yakalayarak işleyebiliriz.
@Slf4j              // bu anatasyon sayesinde sınfa bir kayıt mekanizması ekler.

public class GlobalExceptionHandler {

    @ExceptionHandler    // bu anatasyon bir metot üzerine eklenerek; bu metodun belirli türdeki istisnalarını yakalar.
    // ResponseEntity --> HTTP yanıtlarını temsil eden bir sınıftır. HTTP yanıtlarının gövdesini durum kodunu ve başlıklarını içerir.
    public ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerException exception){
        log.error("burgerexception occured",exception);
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse,exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleBurgerException(Exception exception){
        log.error("Burgerexception occured", exception);
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR); // burada exception.getHttpStatus yerine internal_server_error yazdık.
    }


}
