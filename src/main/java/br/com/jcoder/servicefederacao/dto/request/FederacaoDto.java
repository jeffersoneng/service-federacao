package br.com.jcoder.servicefederacao.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

public class FederacaoDto {

    @Getter
    @Setter
    @NotEmpty
    private String nome;

    @Deprecated
    public FederacaoDto(){
    }
}
