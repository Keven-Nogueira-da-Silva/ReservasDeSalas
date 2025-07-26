import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sala> salas = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();

        salas.add(new Sala("Sala 01", 30 ));
        salas.add(new Sala("Sala 02", 60));
        salas.add(new Sala("Sala 03", 70));

        while(true) {
            System.out.println("\n=== MENU ===");
            System.out.println("""
                    1 - Fazer reserva
                    2 - Ver reservas por sala
                    0 - Sair""");
            System.out.println("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0 ) break;

            switch (opcao) {
                case 1:
                    System.out.println("Salas disponíves: ");
                    for(int i = 0; i < salas.size(); i++){
                        System.out.println(i + " - " + salas.get(i));
                    }

                    System.out.println("Escolha a sala (número): ");
                    int salaIndex = sc.nextInt();
                    sc.nextLine();

                    Sala salaEscolhida = salas.get(salaIndex);

                    System.out.println("Data (ex: 26/07/2025): ");
                    String data = sc.nextLine();

                    System.out.println("Hora início (ex: 14): ");
                    int horaInicio = sc.nextInt();

                    System.out.println("Hora fim (ex: 16:) ");
                    int horaFim = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nome do responsável: ");
                    String responsavel = sc.nextLine();

                    Reserva nova = new Reserva(salaEscolhida, data, horaInicio, horaFim, responsavel);

                    boolean conflito = false;
                    for (Reserva r : reservas) {
                        if (nova.conflitoCom(r));
                        conflito = true;
                        break;
                    }
                    if (conflito) {
                        System.out.println("\uFE0F Conflito: Já existe uma reserva nesse horário.");
            }else {
                        reservas.add(nova);
                        System.out.println("Reserva realizada com sucesso!");
                    }
                    break;

                case 2:
                    System.out.println("Digite o nome da sala: ");
                    String nomeSala = sc.nextLine();
                    System.out.println("Reservas para a sala " + nomeSala +":");
                    for (Reserva r : reservas) {
                        if (r.getSala().getNome().equalsIgnoreCase(nomeSala)) {
                            System.out.println(r);
                        }
                    }
                    break;

                default:
                    System.out.println("(ERRO!!!) Opção inválida.");
            }
        }
        sc.close();
    }
}