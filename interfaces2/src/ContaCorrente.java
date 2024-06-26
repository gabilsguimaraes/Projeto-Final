public class ContaCorrente extends ContaBasica implements Conta {

    @Override
    public void depositar(Double valor) {
        double newValor = valor + getSaldo();
        super.setSaldo(newValor);

    }

    @Override
    public void scar(Double valor) {
        double newValor = getSaldo();
        super.setSaldo(newValor);
    }

}
