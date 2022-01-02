package br.com.jcoder.servicefederacao.service;

import br.com.jcoder.servicefederacao.model.Federacao;
import br.com.jcoder.servicefederacao.repository.FederacaoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
public class FederacaoServiceImpl implements FederacaoService{

    private final FederacaoRepository repository;

    public FederacaoServiceImpl(FederacaoRepository repository){
        this.repository = repository;
    }

    @Override
    public Federacao cadastrar(Federacao federacao) {
        return this.repository.save(federacao);
    }

    @Override
    public Federacao buscarPorId(Integer id) {
        return this.repository.findById(id).orElseThrow(()-> new NoResultException(String.format("Federação com id %d não encontrada", id)));
    }
}
