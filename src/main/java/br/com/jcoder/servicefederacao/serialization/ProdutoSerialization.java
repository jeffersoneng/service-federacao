package br.com.jcoder.servicefederacao.serialization;

import br.com.jcoder.servicefederacao.dto.response.FederacaoResponseDto;
import br.com.jcoder.servicefederacao.model.Federacao;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ProdutoSerialization extends JsonSerializer<Federacao> {

    private final ModelMapper mapper;

    public ProdutoSerialization(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void serialize(Federacao federacao, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        FederacaoResponseDto dto = this.mapper.map(federacao, FederacaoResponseDto.class);
        jsonGenerator.writeObject(dto);
    }
}
