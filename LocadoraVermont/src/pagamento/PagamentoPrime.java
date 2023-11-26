package pagamento;

public class PagamentoPrime extends PagamentoAbstrato {
    private double taxaDePagamento = 0.04;

    public PagamentoPrime(double totalAPagar, int dias, int parcelas) {
        super(totalAPagar, dias, parcelas);
    }

    @Override
    public void calculaTaxaDePagamento(int dias) {

    }

    public double precoParcelado(int parcelas) {
        valorParcelas = totalAPagar/parcelas;
        return valorParcelas;
    }

    public double getTaxaDePagamento() {
        return this.taxaDePagamento;
    }
    public void setTaxaDePagamento(double taxaDePagamento) {
        this.taxaDePagamento = taxaDePagamento;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}
