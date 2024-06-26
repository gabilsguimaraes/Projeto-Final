//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente();
        cc.setSaldo(200.00);
        depositar(cc, 300.00);
        System.out.println(cc.getSaldo());
    }
    public static void depositar(Conta conta, double valor) {
        conta.depositar(valor);
    }
}
