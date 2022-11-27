package br.com.dio.store.controller;

import br.com.dio.store.exception.ProductIdNullException;
import br.com.dio.store.exception.ProductNullException;
import br.com.dio.store.exception.ProductPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> error(){

        Map<String, Object> infoCath = new HashMap<String,Object>();
        infoCath.put("message","Ocorreu um erro generico! - Padrão");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(infoCath);

    }

    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> catchErrorNull(){

        Map<String, Object> infoCath = new HashMap<String, Object>();
        infoCath.put("message","Verifique os campos do produto");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(infoCath);

    }

    @ExceptionHandler(ProductIdNullException.class)
    public  ResponseEntity<Object> catchErrorIdNull(){

        Map<String, Object> infoCath = new HashMap<String, Object>();
        infoCath.put("message","Id não encontrado, adicione um ID valido!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(infoCath);

    }

    @ExceptionHandler(ProductPriceException.class)
    public  ResponseEntity<Object> catchErrorPrice(){

        Map<String, Object> infoCath = new HashMap<String, Object>();
        infoCath.put("message","O valor do Produto está incorreto");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(infoCath);

    }
}
