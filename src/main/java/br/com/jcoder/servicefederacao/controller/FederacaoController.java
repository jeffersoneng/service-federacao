package br.com.jcoder.servicefederacao.controller;

import br.com.jcoder.servicefederacao.dto.request.FederacaoDto;
import br.com.jcoder.servicefederacao.dto.response.FederacaoResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface FederacaoController {

    @Operation(summary = "Api para cadastro de novas federações")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    FederacaoResponseDto cadastrar(@RequestBody @Valid FederacaoDto dto);

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{"+
                                            "codigo" +":"+ "X_100" +
                                            "\"mensagem\" : \"Federacao de codigo <codigo> não encontrada,\n" +
                                            "\"documentacao\" : null\n" +
                                            "}"

                            )
                    )
            )
    })
    @Operation(summary = "Retorna a federacao correspondente ao id passado por parametro")
    @GetMapping("/{id}")
    FederacaoResponseDto buscarById(@PathVariable Integer id);
}
