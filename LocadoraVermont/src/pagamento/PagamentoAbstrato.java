package pagamento;

public abstract class PagamentoAbstrato {
    protected double totalAPagar;
    protected int dias;
    protected int parcelas;

    public PagamentoAbstrato(double totalAPagar, int dias, int parcelas) {
        this.totalAPagar = totalAPagar;
        this.dias = dias;
        this.parcelas = parcelas;
    }

    public abstract void taxaDePagamento(int dias);

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
}