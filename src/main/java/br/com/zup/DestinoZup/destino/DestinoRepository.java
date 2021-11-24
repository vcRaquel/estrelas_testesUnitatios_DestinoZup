package br.com.zup.DestinoZup.destino;

import org.springframework.data.repository.CrudRepository;
//não é necessário @Repository,
// normalmente essa anotação é usada quando a repository é uma classe (não uma interface)
// e você implementa a crud(e não extends)
public interface DestinoRepository extends CrudRepository <Destino, Integer>{

}
