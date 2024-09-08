public abstract class Veiculo {
    protected String tipo;

    public Veiculo(String tipo) {
        this.tipo = tipo;
    }

    public void exibirTipo() {
        System.out.println("Tipo: " + tipo);
    }

    public abstract void ligar();
}
