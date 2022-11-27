package br.com.dio.store.exception;

import java.io.Serial;

public class ProductPriceException extends Exception {
    // Exception Pega caso o Valor do produto seja negativo -
    @Serial
    private static final long serialVersionUID = 1L;
}
