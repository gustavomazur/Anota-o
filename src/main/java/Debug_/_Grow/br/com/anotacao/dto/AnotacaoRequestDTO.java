package Debug_._Grow.br.com.anotacao.dto;

import jakarta.validation.constraints.NotBlank;

public record AnotacaoRequestDTO(

        @NotBlank
        String titulo,

        @NotBlank
        String anotacao
) {
}

