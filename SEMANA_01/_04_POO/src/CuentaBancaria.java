public class CuentaBancaria {

    private String titular;
    private double balance;

    public CuentaBancaria(String titular, double balance) {
        this.titular = titular;
        this.balance = balance;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void depositarDinero (double cantidadDepositar){
        if (cantidadDepositar <= 0){
            System.out.println("No se puede depositar esa cantidad");
        } else {
            this.balance += cantidadDepositar;
        }
    }

    public void retirarDinero (double cantidadRetirar){
        if (cantidadRetirar <= 0){
            System.out.println("No se puede retirar esa cantidad");
        } else if (cantidadRetirar > this.balance) {
            System.out.println("Fondos insuficientes");
        } else {
            this.balance -= cantidadRetirar;
        }
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "titular='" + titular + '\'' +
                ", balance=" + balance +
                '}';
    }
}
