public class Carro extends Veiculo {
    private String marca;
    private String modelo;
    private int ano;

    public Carro(String marca, String modelo, int ano, String tipo, boolean abastecido, int velocidade) {
        super(tipo, abastecido, velocidade);
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void exibirInformacoes() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Combustivel: " + abastecido);
        System.out.println("Km: " + velocidade);
    }

    @Override
    public void ligar() {
        System.out.println("Carro: Ligado");
    }

}
