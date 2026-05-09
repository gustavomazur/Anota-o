package Debug_._Grow.br.com.anotacao.mapper;

import Debug_._Grow.br.com.anotacao.dto.AnotacaoDTO;
import Debug_._Grow.br.com.anotacao.dto.AnotacaoRequestDTO;
import Debug_._Grow.br.com.anotacao.model.Anotacao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnotacaoMapper {
    AnotacaoDTO paraDTO(Anotacao anotacao);
    Anotacao paraEntity(AnotacaoRequestDTO anotacaoDTO);

}
