package pagamento;

public class PagamentoPrime extends PagamentoAbstrato {
    public PagamentoPrime(double totalAPagar, int dias, int parcelas) {
        super(totalAPagar, dias, parcelas);
    }

    @Override
    public void taxaDePagamento(int dias) {

    }
}
