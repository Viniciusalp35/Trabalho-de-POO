import Carros.*;

import gui.TelaPagamento;
import login.Usuarios;
import login.CadastroUsuarios;
import gui.Login;
import serializador.SalvarUsuarios;

import pagamento.PagamentoAbstrato;
import pagamento.PagamentoBasico;
import pagamento.PagamentoPrime;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");

        CadastroUsuarios cadastroUsuarios = SalvarUsuarios.deserializar();
        if(cadastroUsuarios == null) {
            cadastroUsuarios = new CadastroUsuarios();
            System.out.println("nenhum usuário salvo!");
        }
        Login login = new Login(cadastroUsuarios);
        SalvarUsuarios.serializar(cadastroUsuarios);


        PagamentoAbstrato pagamento = new PagamentoPrime(60, 12);
        double valor = pagamento.calcularValorTotal();
        double valorParcelado = ((PagamentoPrime) pagamento).calcularValorParcelado();
        System.out.println(valor  + " e " + valorParcelado);

        TelaPagamento telaPagamento = new TelaPagamento();
    }
}