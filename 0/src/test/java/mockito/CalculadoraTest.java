package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockedStatic;
import org.mockito.stubbing.Answer;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.verification.VerificationMode;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

public class CalculadoraTest {

    @Test
    public void testSomar() {
        // Criando o mock da interface ServicoMatematico
        ServicoMatematico servicoMock = Mockito.mock(ServicoMatematico.class);

        // Configurando o mock para retornar 5 quando somar(2, 3) for chamado
        Mockito.when(servicoMock.somar(2, 3)).thenReturn(5);

        // Criando a Calculadora com o mock como dependência
        Calculadora calculadora = new Calculadora(servicoMock);

        // Chamando o método somar da Calculadora
        int resultado = calculadora.somar(2, 3);

        // Verificando se o resultado é o esperado
        Assertions.assertEquals(5, resultado);

        // Verificando se o método somar foi chamado corretamente
        Mockito.verify(servicoMock).somar(2, 3);
    }
}

