public class Moto extends Veiculo {
    private int cilindrada;

    public Moto(int cilindrada, String tipo) {
        super(tipo);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void exibirCilindrada() {
        System.out.println("Cilindrada: " + cilindrada);
    }

    @Override
    public void ligar() {
        System.out.println("Moto: Ligada");
    }
}
