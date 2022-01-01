package br.com.jcoder.servicefederacao.dto.response;

import lombok.Getter;

public class FederacaoResponseDto {

    @Getter
    private final String nome;

    public FederacaoResponseDto(String nome) {
        this.nome = nome;
    }
}
