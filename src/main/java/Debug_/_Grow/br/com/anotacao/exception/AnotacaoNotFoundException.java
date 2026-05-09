package Debug_._Grow.br.com.anotacao.exception;

public class AnotacaoNotFoundException extends RuntimeException{
    public AnotacaoNotFoundException(String id) {
        super("Anotação não encontrada com o id: " + id);
    }
}
