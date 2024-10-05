package com.sckaya.rentacar.core.utilities.exceptions;

public class BusinessException extends RuntimeException {

    // private static final long serialVersionUID = 1L;   // serileştirme için laızm olursa bizim proje için gerek yok.

    public BusinessException(String message){
        super(message);
    }
}
