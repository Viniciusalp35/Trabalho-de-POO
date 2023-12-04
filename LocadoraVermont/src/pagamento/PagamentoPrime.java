package pagamento;

public class PagamentoPrime extends PagamentoAbstrato {
    private double taxaDesconto = 0.15;
    private double taxaDiaria;

    public PagamentoPrime(int dias, int parcelas, double taxaDiaria) {
        super(dias, parcelas);
        this.taxaDiaria = taxaDiaria;
    }

    @Override
    public double calcularValorTotal() {
        totalAPagar = dias * taxaDiaria;
        totalAPagar -= calcularDesconto();

        return totalAPagar;
    }

    @Override
    public double calcularDesconto() {
        return (totalAPagar * taxaDesconto);
    }

    @Override
    public double calcularValorParcelado() {
        return (totalAPagar / parcelas);
    }

    @Override
    public double getTaxaDesconto() {
        return this.taxaDesconto;
    }

    public void setTaxaDesconto(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public double getTaxaDiaria() {
        return this.taxaDiaria;
    }

    public void setTaxaDiaria(double taxaDiaria) {
        this.taxaDiaria = taxaDiaria;
    }

}
