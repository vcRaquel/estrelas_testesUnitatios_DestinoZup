package br.com.zup.DestinoZup.destinoTest;

import br.com.zup.DestinoZup.categoria.CategoriaRepository;
import br.com.zup.DestinoZup.destino.Destino;
import br.com.zup.DestinoZup.destino.DestinoRepository;
import br.com.zup.DestinoZup.destino.DestinoService;
import br.com.zup.DestinoZup.regiao.Regiao;
import br.com.zup.DestinoZup.regiao.RegiaoNaoEncontradaException;
import br.com.zup.DestinoZup.regiao.RegiaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

//Primeiro colocar a anotação de teste para springboot:

@SpringBootTest
public class DestinoServiceTest {

    //Segundo colocar como atributo as injeções de dependência usadas na classe service original
    // como MockBean para criar o mock de tudo aquilo que não vai ser testado
    // para que os testes unitários serem aplicados apenas à classe a ser testada:

    @MockBean //em vez da injeção de dependência @Autowired
    private DestinoRepository destinoRepository;
    @MockBean
    private RegiaoRepository regiaoRepository;
    @MockBean
    private CategoriaRepository categoriaRepository;

    //Terceiro fazer a injeção de dependência da classe original que está sendo testada
    // pois precisa do objeto verdadeiro para ser testado:

    @Autowired
    private DestinoService destinoService;

    @Test
    public void testarSalvarDestinoCaminhoRuim(){
        //Mockito: usado para a manipulação do MockBean
        Mockito.when(regiaoRepository.existsById(Mockito.anyString())).thenReturn(false);

        //instâncias e atribuições de valor
        Destino destino = new Destino();
        Regiao regiao = new Regiao();
        regiao.setNome("Xablau");
        destino.setRegiao(regiao);

        //teste em si, testar a exception de RegiaoNaoEncontrada no método salvarDestino da destinoService
        Assertions.assertThrows(RegiaoNaoEncontradaException.class, () -> {destinoService.salvarDestino(destino);});
    }

    @Test
    public void testarSalvarDestinoCaminhoPositivo(){
        //instâncias e atribuições de valor
        Destino destino = new Destino();
        Regiao regiao = new Regiao();
        regiao.setNome("Xablau");
        destino.setRegiao(regiao);

        //Mockito: usado para a manipulação do MockBean
        //para o método de existsById
        Mockito.when(regiaoRepository.existsById(Mockito.anyString())).thenReturn(true);
        //para o método de save com parâmetro destino
        Mockito.when(destinoRepository.save(Mockito.any(Destino.class))).thenReturn(destino);


        //teste em si, testar o método salvarDestino da destinoService e verificar se o método de salvar
        // com parâmetro destino foi chamado apenas uma vez no mokito da destinoRepository:

        destinoService.salvarDestino(destino);
        //Mockito.verify verifica quantas vezes um método é chamado dentro do método testado (salvarDestino nesse caso)
        //Nesse mockito estamos verificando o método save do destinoRepository
        Mockito.verify(destinoRepository, Mockito.times(1)).save(destino);

        //??? perguntar/verificar se é pelo menos uma vez ou apenas uma vez ???

    }
    //obs:
    //false: caminho triste/negativo é quando não existe uma situação -> Ou seja, estoura uma exception
    //true: caminho feliz/positivo quando uma condição/situação é satisfeita pela condição lógica

}
