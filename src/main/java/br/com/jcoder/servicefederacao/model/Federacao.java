package br.com.jcoder.servicefederacao.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Federacao extends AbstractPersistable<Integer> {

    @Getter
    @Setter
    private String nome;

    public Federacao(@NonNull String nome){
        this.nome = Objects.requireNonNull(nome);
    }

    public Federacao() {

    }
}
