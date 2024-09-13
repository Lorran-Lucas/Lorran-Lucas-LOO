public class Moto extends Veiculo {
    private int cilindrada;

    public Moto(int cilindrada, String tipo, boolean abastecido, int velocidade) {
        super(tipo, abastecido, velocidade); 
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

    public void exibirInformacoesMoto() {
        System.out.println("Combustivel: " + abastecido);
        System.out.println("Km: " + velocidade);
    }

    @Override
    public void ligar() {
        System.out.println("Moto: Ligada");
    }
}
