package atividade3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarrosselCircular carrosselCircular = new CarrosselCircular();
        int opcao;

        do {
            System.out.println("1 - Exibir e avançar");
            System.out.println("2 - Adicionar anúncio");
            System.out.println("3 - Remover Anúncio");
            System.out.println("4 - Listar Ciclo Completo");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: carrosselCircular.exibirEAvancar(); break;
                case 2: 
                    System.out.println("Digite o ID da empresa:");
                    int idEmpresa = scanner.nextInt();

                    System.out.println("Digite o nome da empresa: ");
                    scanner.nextLine();
                    String empresa = scanner.nextLine();

                    System.out.println("Digite uma descrição do anúncio: ");
                    String descricao = scanner.nextLine();

                    carrosselCircular.adicionarAnuncio(idEmpresa, empresa, descricao);
                    break;
                case 3: 
                    System.out.println("Digite o ID do anúncio no qual deseja remover: ");    
                    int idAnuncio = scanner.nextInt();

                    carrosselCircular.removerAnuncio(idAnuncio);                 
                    break;
                case 4: carrosselCircular.listarCicloCompleto(); break;
                case 0: System.exit(0);
                default:
                    break;
            }
        } while (opcao != 0);
    }
}
