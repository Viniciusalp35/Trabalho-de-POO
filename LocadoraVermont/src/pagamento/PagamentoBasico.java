package pagamento;

public class PagamentoBasico extends PagamentoAbstrato {
    private double taxaDePagamento = 0.12;
    public PagamentoBasico(double totalAPagar, int dias, int parcelas){
        super(totalAPagar, dias, parcelas);
    }

    @Override
    public void calculaTaxaDePagamento(int dias) {

    }

    public void setParcelas() {
        this.parcelas = parcelas;
    }
}
