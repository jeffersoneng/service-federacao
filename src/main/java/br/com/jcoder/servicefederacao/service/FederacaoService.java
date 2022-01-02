package br.com.jcoder.servicefederacao.service;

import br.com.jcoder.servicefederacao.model.Federacao;
import org.springframework.stereotype.Service;

public interface FederacaoService {
    Federacao cadastrar (Federacao federacao);

    Federacao buscarPorId(Integer id);
}