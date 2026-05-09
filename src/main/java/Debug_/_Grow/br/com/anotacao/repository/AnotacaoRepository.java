package Debug_._Grow.br.com.anotacao.repository;

import Debug_._Grow.br.com.anotacao.model.Anotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {

}
