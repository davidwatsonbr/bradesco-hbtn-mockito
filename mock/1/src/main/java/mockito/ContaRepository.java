package mockito;

public interface ContaRepository {
    Conta buscarConta(String numero);
    void salvar(Conta conta);
}
