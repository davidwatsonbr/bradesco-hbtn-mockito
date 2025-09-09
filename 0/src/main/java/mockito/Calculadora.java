package mockito;

public class Calculadora {
    private ServicoMatematico servicoMatematico;

    public Calculadora(ServicoMatematico servicoMatematico) {
        this.servicoMatematico = servicoMatematico;
    }

    public int somar(int a, int b) {
        return servicoMatematico.somar(a, b);
    }
}
