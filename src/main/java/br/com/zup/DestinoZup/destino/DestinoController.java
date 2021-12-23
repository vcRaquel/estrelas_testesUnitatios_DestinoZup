package br.com.zup.DestinoZup.destino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController //para criar o objeto controller e conseguir receber as requisições
@RequestMapping("/destinos") //mapeando o caminho para as requisições do protocolo http
public class DestinoController {
    @Autowired //injeção de dependencia de um objeto destinoservice da destinoservice
    DestinoService destinoService;

    @PostMapping //mapeamento do método http para a requisição com o método http post
    @ResponseStatus(HttpStatus.CREATED)//modificando a resposta padrão de 200ok para creadet por meio do @ResponseStatus
    public Destino cadastrarDestino(@RequestBody Destino destino) {
        return destinoService.salvarDestino(destino);
    }
}
