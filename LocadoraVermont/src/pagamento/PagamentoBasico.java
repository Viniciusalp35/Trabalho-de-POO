package pagamento;

public class PagamentoBasico extends PagamentoAbstrato {
    public PagamentoBasico(double totalApagar, int dias, int parcelas){
        super(totalApagar, dias, parcelas);
    }

    @Override
    public void taxaDePagamento(int dias) {

    }
}
