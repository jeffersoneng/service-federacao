package br.com.jcoder.servicefederacao.controller;

import br.com.jcoder.servicefederacao.dto.request.FederacaoDto;
import br.com.jcoder.servicefederacao.dto.response.FederacaoResponseDto;
import br.com.jcoder.servicefederacao.model.Federacao;
import br.com.jcoder.servicefederacao.service.FederacaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/federacao")
public class FederacaoController {

    private final FederacaoService service;

    public FederacaoController(FederacaoService service){
        this.service = service;
    }

    @PostMapping
    public FederacaoResponseDto cadastrar(@RequestBody FederacaoDto dto){
        Federacao federacao = new Federacao(dto.getNome());
        Federacao federacaoDB = this.service.cadastrar(federacao);
        return new FederacaoResponseDto(federacaoDB.getNome());
    }
}
