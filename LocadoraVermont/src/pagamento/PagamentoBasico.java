package pagamento;

public class PagamentoBasico extends PagamentoAbstrato {
    private double taxaDesconto = 0.03;
    public PagamentoBasico(double totalAPagar, int dias, int parcelas){
        super(totalAPagar, dias, parcelas);
    }

    @Override
    public void calculaDesconto(int dias) {

    }

    public double getTaxaDesconto() {
        return this.taxaDesconto;
    }

    public void setTaxaDesconto(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public void setParcelas() {
        this.parcelas = parcelas;
    }
}
