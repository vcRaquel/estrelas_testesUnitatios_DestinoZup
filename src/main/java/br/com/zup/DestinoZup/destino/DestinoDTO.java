package br.com.zup.DestinoZup.destino;

import br.com.zup.DestinoZup.categoria.Categoria;
import br.com.zup.DestinoZup.regiao.Regiao;

import javax.validation.constraints.Size;
import java.util.List;

public class DestinoDTO {
    @Size(min = 2, max = 150, message = "Nome fora do padrão esperado: min 2 e max 150 caracteres")
    private String nome;

    private Regiao regiao;

    private List<Categoria> categorias;
}
