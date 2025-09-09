package java.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BancoServiceTest {

    @Test
    public void testConsultarSaldo() {
        // Criando mock do repositório
        ContaRepository contaRepository = Mockito.mock(ContaRepository.class);

        // Criando conta simulada
        Conta contaSimulada = new Conta("123-X", 200.99);

        // Definindo comportamento do mock
        when(contaRepository.buscarConta("123-X")).thenReturn(contaSimulada);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepository);

        // Testando consulta de saldo
        double saldo = bancoService.consultarSaldo("123-X");

        // Verificando se o saldo está correto
        assertEquals(200.99, saldo);

        // Verificando se o método buscarConta foi chamado
        verify(contaRepository).buscarConta("123-X");
    }


    @Test
    public void testDepositar() {
        // Criando mock do repositório
        ContaRepository contaRepository = Mockito.mock(ContaRepository.class);

        // Criando conta simulada
        Conta contaSimulada = new Conta("456-X", 300.05);

        // Definindo comportamento do mock
        when(contaRepository.buscarConta(contaSimulada.getNumero())).thenReturn(contaSimulada);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepository);

        // Executando depósito
        bancoService.depositar(contaSimulada.getNumero(), 800.00);

        // Verificando se o saldo foi atualizado
        assertEquals(1100.05, contaSimulada.getSaldo());

        // Verificando se os métodos foram chamados corretamente
        verify(contaRepository).buscarConta(contaSimulada.getNumero());
        verify(contaRepository).salvar(contaSimulada);
    }
}