public class Main {
    public static void main(String[] args) {

        Veiculo meuCarro = new Veiculo();


        meuCarro.setChassi("1234567890");
        meuCarro.setModelo("Porsche 911");
        meuCarro.setCor("ROXA");


        System.out.println("Chassi: " + meuCarro.getChassi());
        System.out.println("Modelo: " + meuCarro.getModelo());
        System.out.println("Cor: " + meuCarro.getCor());
    }
}
