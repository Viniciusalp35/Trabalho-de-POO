package pagamento;

public class PagamentoPrime extends PagamentoAbstrato {
    private double taxaDesconto = 0.15;
    private double taxaDiaria = 70.0;

    public PagamentoPrime(int dias, int parcelas) {
        super(dias, parcelas);
    }

    @Override
    public double calcularValorTotal(int dias) {
        totalAPagar = dias * taxaDiaria;
        totalAPagar -= calcularDesconto();

        return totalAPagar;
    }

    @Override
    public double calcularDesconto() {
        return (totalAPagar * taxaDesconto);
    }

    public double calcularValorParcelado(double totalAPagar, int parcelas) {
        return (totalAPagar / parcelas);
    }

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
