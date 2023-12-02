import pagamento.PagamentoAbstrato;
import pagamento.PagamentoBasico;
import pagamento.PagamentoPrime;

public class Main{
    public static void main(String[] args) {
        System.out.println("Olá, mundo");
        PagamentoAbstrato pagamento = new PagamentoPrime(60, 12);
        double valor = pagamento.calcularValorTotal();
        double valorParcelado = ((PagamentoPrime) pagamento).calcularValorParcelado(pagamento.getTotalAPagar(), pagamento.getParcelas());
        System.out.println(valor  + " e " + valorParcelado);
    }
}