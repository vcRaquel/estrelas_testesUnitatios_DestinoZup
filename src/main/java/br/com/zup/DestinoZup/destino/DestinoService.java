package br.com.zup.DestinoZup.destino;

import br.com.zup.DestinoZup.categoria.CategoriaRepository;
import br.com.zup.DestinoZup.regiao.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//poderia ser usado o @Component, mas o @Service é mais específico
@Service
public class DestinoService {
//faz os atributos com todos os elementos a terem injeção de dependência
    private DestinoRepository destinoRepository;
    private RegiaoRepository regiaoRepository;
    private CategoriaRepository categoriaRepository;

    //cria um construtor com os atributos a terem injeção de dependência e coloca a marcação @Autowired
    @Autowired //injeção de dependência
    public DestinoService(DestinoRepository destinoRepository,
                          RegiaoRepository regiaoRepository,
                          CategoriaRepository categoriaRepository) {
        this.destinoRepository = destinoRepository;
        this.regiaoRepository = regiaoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Destino salvarDestino(Destino destino){
        if (!regiaoRepository.existsById(destino.getRegiao().getNome())){
            throw new RuntimeException("Região não existe");
        }
        return destinoRepository.save(destino);
    }
}
