import java.util.ArrayList;
import java.util.Scanner;

class minhaprova {

    public static void main(String[] args) {

        ArrayList<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Alane Dias"));
        jogadores.add(new Jogador("Beatriz Reis"));
        jogadores.add(new Jogador("Davi Brito"));
        jogadores.add(new Jogador("Deniziane Ferreira"));
        jogadores.add(new Jogador("Fernanda Bande"));
        jogadores.add(new Jogador("Giovanna Lima"));
        jogadores.add(new Jogador("Giovanna Pitel"));
        jogadores.add(new Jogador("Isabelle Nogueira"));
        jogadores.add(new Jogador("Juninho"));
        jogadores.add(new Jogador("Leidy Elin"));
        jogadores.add(new Jogador("Lucas Henrique"));
        jogadores.add(new Jogador("Lucas Luigi"));
        jogadores.add(new Jogador("Lucas Pizane"));
        jogadores.add(new Jogador("Marcus Vinicius"));
        jogadores.add(new Jogador ("Matteus Amaral"));
        jogadores.add(new Jogador ("Maycon Cosmer"));
        jogadores.add(new Jogador ("MC Bin Laden"));
        jogadores.add(new Jogador ("Michel Nogueira"));
        jogadores.add(new Jogador ("Nizam"));
        jogadores.add(new Jogador ("Raquele Cardozo"));
        jogadores.add(new Jogador ("Rodriguinho"));
        jogadores.add(new Jogador ("Thalyta Alves"));
        jogadores.add(new Jogador ("Vanessa Lopes"));
        jogadores.add(new Jogador ("Vinicius Rodrigues"));
        jogadores.add(new Jogador ("Wanessa Camargo"));
        jogadores.add(new Jogador ("Yasmin Brunet"));


        Scanner scanner = new Scanner(System.in);


        while (true) {
            // Apresentar menu de opções
            System.out.println("\n\nVotação BBB - Modo Eliminação");
            System.out.println("-----------------------------");
            System.out.println("1. Em Quem você Vota");
            System.out.println("2. Exibir participante com mais votos");
            System.out.println("3. Sair");
            System.out.print("Digite sua opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    votarEmParticipante(jogadores, scanner);
                    break;
                case 2:
                    exibirParticipanteMaisVotado(jogadores);
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void votarEmParticipante(ArrayList<Jogador> jogadores, Scanner scanner) {
        System.out.println("\nLista de Participantes:");
        for (int i = 0; i < jogadores.size(); i++) {
            System.out.println((i + 1) + ". " + jogadores.get(i).getNome());
        }

        System.out.print("Digite o número do participante em que deseja votar: ");
        int numeroParticipante = scanner.nextInt() - 1;

        if (numeroParticipante >= 0 && numeroParticipante < jogadores.size()) {
            jogadores.get(numeroParticipante).adicionarVoto();
            System.out.println("Voto registrado com sucesso para " + jogadores.get(numeroParticipante).getNome() + "!");
        } else {
            System.out.println("Número de participante inválido. Tente novamente.");
        }
    }

    private static void exibirParticipanteMaisVotado(ArrayList<Jogador> jogadores) {
        Jogador maisVotado = null;
        int maiorVotos = 0;

        for (Jogador jogador : jogadores) {
            int votos = jogador.getVotos();
            if (votos > maiorVotos) {
                maiorVotos = votos;
                maisVotado = jogador;

            }
        }

        if (maisVotado != null) {
            System.out.println("\nParticipante com mais votos para eliminação:");
            System.out.println("Nome: " + maisVotado.getNome());
            System.out.println("Votos: " + maisVotado.getVotos());
            System.out.println("Mensagem de eliminação: Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir\n" +
                    "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu\n" +
                    "conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu\n" +
                    "vou conseguir te eliminar com alegria. " +maisVotado.getNome() + maisVotado.getVotos());

        } else {
            System.out.println("Ainda não há votos registrados.");
        }
    }
}

class Jogador {
    private String nome;
    private int votos;

    public Jogador(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }

    public void adicionarVoto() {
        votos++;
    }
}



