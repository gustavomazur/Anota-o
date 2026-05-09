package Debug_._Grow.br.com.anotacao.dto;

import java.time.LocalDateTime;

public record AnotacaoDTO(
        long id,

        String titulo,

        String anotacao,

        LocalDateTime criadoEm
) {
}
