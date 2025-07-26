public class Reserva {
    private Sala sala;
    private String data;
    private int horaInicio;
    private int horaFim;
    private String responsavel;

    public Reserva(Sala sala, String data, int horaInicio, int horaFim, String responsavel) {
        this.sala = sala;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.responsavel = responsavel;
    }

    public Sala getSala() {
        return sala;
    }

    public String getData() {
        return data;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getHoraFim() {
        return horaFim;
    }

    public boolean conflitoCom(Reserva outra) {
        return this.sala.getNome().equals(outra.getSala().getNome()) &&
                this.data.equals(outra.getData()) &&
                !(this.horaFim <= outra.horaInicio || this.horaInicio >= outra.horaFim);
    }

    @Override
    public String toString() {
        return "Reserva: " + sala.getNome() + ", " + data + " das " + horaInicio + "h às " + horaFim + "h - Responsável: " + responsavel;
    }
}
