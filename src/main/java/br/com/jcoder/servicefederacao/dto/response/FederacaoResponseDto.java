package br.com.jcoder.servicefederacao.dto.response;

import lombok.Getter;
import lombok.Setter;

public class FederacaoResponseDto {
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String nome;

    @Deprecated
    FederacaoResponseDto(){}
}
