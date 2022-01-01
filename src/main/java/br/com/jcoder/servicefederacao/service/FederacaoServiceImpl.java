package br.com.jcoder.servicefederacao.service;

import br.com.jcoder.servicefederacao.model.Federacao;
import br.com.jcoder.servicefederacao.repository.FederacaoRepository;
import org.springframework.stereotype.Service;

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
}
