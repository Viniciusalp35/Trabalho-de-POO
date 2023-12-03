package pagamento;

public abstract class PagamentoAbstrato {
    protected double totalAPagar;
    protected int dias;
    protected int parcelas;


    public PagamentoAbstrato(int dias, int parcelas) {
        this.dias = dias;
        this.parcelas = parcelas;
    }

    public abstract double calcularValorTotal();

    public abstract double calcularDesconto();

    public int getDias() {
        return this.dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getTotalAPagar() {
        return this.totalAPagar;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public int getParcelas() {
        return this.parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public abstract double getTaxaDesconto();

    public abstract double calcularValorParcelado();
}