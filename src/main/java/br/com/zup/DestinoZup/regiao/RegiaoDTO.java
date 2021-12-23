package br.com.zup.DestinoZup.regiao;

import javax.validation.constraints.Size;

public class RegiaoDTO {
    @Size(min = 2, max = 150, message = "Nome fora do padrão esperado: min 2 e max 150 caracteres")
    private String nome;

}
