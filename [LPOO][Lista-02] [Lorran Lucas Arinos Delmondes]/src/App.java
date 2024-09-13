public class App {
    public static void main(String[] args) {
        Carro carro = new Carro("Porsche", "Panamera", 2024, "Carro",false, 0);
        Moto moto = new Moto(300,"Moto",false,0);
         // Atividade part1


        System.out.println("\n");
        System.out.println("Dados iniciais da moto:");
        moto.exibirCilindrada();
        moto.exibirTipo();
        moto.exibirInformacoesMoto();

        System.out.println("\n");
        moto.abastecer(); 
        moto.acelerar(80); 

        System.out.println("\n");
        System.out.println("Dados finais da moto:");
        moto.exibirCilindrada();
        moto.exibirTipo();
        moto.exibirInformacoesMoto();


        // Atividade part2
        System.out.println("\n");
        System.out.println("Dados iniciais do carro:");
        carro.exibirInformacoes();
        
        System.out.println("\n");
        carro.abastecer();  
        carro.acelerar(60); 
        System.out.println("\n");
        System.out.println("Dados finais do carro:");
        carro.exibirInformacoes();


        
        System.out.println("\n");
        System.out.println("Status dos veiculos:");
        Veiculo[] veiculos = new Veiculo[2];
        veiculos[0] = carro;
        veiculos[1] = moto;

        for (Veiculo veiculo : veiculos) {
            veiculo.ligar();
        }
    }
}
