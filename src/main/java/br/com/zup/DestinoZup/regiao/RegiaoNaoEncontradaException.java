package br.com.zup.DestinoZup.regiao;

import org.springframework.data.repository.CrudRepository;

public class RegiaoNaoEncontradaException extends RuntimeException {

    public RegiaoNaoEncontradaException(String message) {
        super(message);
    }

}
