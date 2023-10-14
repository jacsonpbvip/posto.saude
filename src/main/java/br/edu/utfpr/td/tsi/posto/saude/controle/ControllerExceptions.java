package br.edu.utfpr.td.tsi.posto.saude.controle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.utfpr.td.tsi.posto.saude.exceptions.CPFExistenteException;

@ControllerAdvice
public class ControllerExceptions {


    @ExceptionHandler(CPFExistenteException.class)
    public ResponseEntity<String> handleCPFExistenteException(CPFExistenteException e) {
        String mensagemDeErro = e.getMessage();
        return new ResponseEntity<>(mensagemDeErro, HttpStatus.BAD_REQUEST);
    }
	
	
}
