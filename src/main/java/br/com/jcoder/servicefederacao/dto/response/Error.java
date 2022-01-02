package br.com.jcoder.servicefederacao.dto.response;

import lombok.Getter;
import org.springframework.cloud.sleuth.http.HttpServerRequest;
import org.springframework.lang.NonNull;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class Error {

    @Getter
    private final String codigo;
    @Getter
    private final String mensagem;
    @Getter
    private final String documentacao;

    public Error(@NonNull String codigo, @NonNull String mensagem, @NonNull String urlDocumentation) {
        this.codigo = Objects.requireNonNull(codigo);
        this.mensagem = Objects.requireNonNull(mensagem);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        documentacao = url + urlDocumentation;
    }
}
