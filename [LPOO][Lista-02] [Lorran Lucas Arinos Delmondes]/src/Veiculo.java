public abstract class Veiculo implements IFuncoesVeiculo {
    protected String tipo;
    public boolean abastecido;
    public int velocidade;


    public Veiculo(String tipo,boolean abastecido,int velocidade) {
        this.tipo = tipo;
        this.abastecido = false;
        this.velocidade = 0;
    }


    public void exibirTipo() {
        System.out.println("Tipo: " + tipo);
    }

    public abstract void ligar();


     // Atividade part2
    @Override
    public void abastecer() {
        this.abastecido = true;
        System.out.println("Abastecido!");
    }

    
    @Override
    public void acelerar(int velocidade) {
        this.velocidade = velocidade;  
        System.out.println("Aceleração:" + this.velocidade + " km/h.");

        

        }} 
