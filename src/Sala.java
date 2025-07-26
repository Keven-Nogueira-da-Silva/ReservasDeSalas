public class Sala {
    private String nome;
    private int capacidade;

    public Sala(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Sala: " + nome + "(Capacidade: " + capacidade + ")";
    }
}
