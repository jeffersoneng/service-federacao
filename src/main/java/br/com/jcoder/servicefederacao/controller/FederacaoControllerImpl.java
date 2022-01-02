package br.com.jcoder.servicefederacao.controller;

import br.com.jcoder.servicefederacao.dto.request.FederacaoDto;
import br.com.jcoder.servicefederacao.dto.response.FederacaoResponseDto;
import br.com.jcoder.servicefederacao.model.Federacao;
import br.com.jcoder.servicefederacao.service.FederacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/federacao")
public class FederacaoControllerImpl implements FederacaoController {

    private final FederacaoService service;
    private final ModelMapper mapper;

    public FederacaoControllerImpl(FederacaoService service, ModelMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FederacaoResponseDto cadastrar(@RequestBody @Valid FederacaoDto dto){
        Federacao federacao = new Federacao(dto.getNome());
        Federacao federacaoDB = this.service.cadastrar(federacao);
        return this.mapper.map(federacaoDB, FederacaoResponseDto.class);
    }

    @Override
    @GetMapping("/{id}")
    public FederacaoResponseDto buscarById(@PathVariable Integer id){
        Federacao federacao = this.service.buscarPorId(id);
        return mapper.map(federacao, FederacaoResponseDto.class);
    }
}
