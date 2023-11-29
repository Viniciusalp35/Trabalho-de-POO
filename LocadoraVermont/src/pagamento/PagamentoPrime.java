package pagamento;

public class PagamentoPrime extends PagamentoAbstrato {
    private double taxaDesconto = 0.20;

    public PagamentoPrime(double totalAPagar, int dias, int parcelas) {
        super(totalAPagar, dias, parcelas);
    }

    @Override
    public void calculaDesconto(int dias) {

    }

    public double precoParcelado(int parcelas) {
        valorParcelas = totalAPagar/parcelas;
        return valorParcelas;
    }

    public double getTaxaDesconto() {
        return this.taxaDesconto;
    }
    public void setTaxaDesconto(double taxaDePagamento) {
        this.taxaDesconto = taxaDesconto;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}
