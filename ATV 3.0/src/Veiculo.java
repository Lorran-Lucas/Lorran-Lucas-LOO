public class Veiculo {
    private String chassi;
    private String modelo;
    private String cor;

    public String getChassi() {
        return this.chassi;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getCor() {
        return this.cor;
    }

    public void setChassi(String chassiNovo) {
        this.chassi = chassiNovo;
    }

    public void setModelo(String modeloNovo) {
        this.modelo = modeloNovo;
    }

    public void setCor(String corNovo) {
        this.cor = corNovo;
    }
}