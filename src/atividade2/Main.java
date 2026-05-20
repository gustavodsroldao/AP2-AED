package atividade2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\nMenu de opções da playlist: \n");
            System.out.println("1 - Adicionar no início");
            System.out.println("2 - Adicionar no fim");
            System.out.println("3 - Adicionar na posição");
            System.out.println("4 - Remover por título");
            System.out.println("5 - Tocar música atual");
            System.out.println("6 - Próxima música");
            System.out.println("7 - Música anterior");
            System.out.println("8 - Listar músicas");
            System.out.println("9 - Ordenar por título");
            System.out.println("10 - Ordenar por artista");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista = sc.nextLine();

                    System.out.print("Álbum: ");
                    String album = sc.nextLine();

                    System.out.print("Duração (segundos): ");
                    int duracao = sc.nextInt();
                    sc.nextLine();

                    playlist.adicionarNoInicio(new Musica(titulo, artista, album, duracao));
                }

                case 2 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista = sc.nextLine();

                    System.out.print("Álbum: ");
                    String album = sc.nextLine();

                    System.out.print("Duração (segundos): ");
                    int duracao = sc.nextInt();
                    sc.nextLine();

                    playlist.adicionarNoFim(new Musica(titulo, artista, album, duracao));
                }

                case 3 -> {
                    System.out.print("Posição: ");
                    int pos = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista = sc.nextLine();

                    System.out.print("Álbum: ");
                    String album = sc.nextLine();

                    System.out.print("Duração (segundos): ");
                    int duracao = sc.nextInt();
                    sc.nextLine();

                    playlist.adicionarNaPosicao(new Musica(titulo, artista, album, duracao), pos);
                }

                case 4 -> {
                    System.out.print("Título para remover: ");
                    String titulo = sc.nextLine();
                    playlist.removerPorTitulo(titulo);
                }

                case 5 -> playlist.tocarMusicaAtual();

                case 6 -> playlist.proximaMusica();

                case 7 -> playlist.musicaAnterior();

                case 8 -> playlist.listarMusicas();

                case 9 -> playlist.ordenarPorTitulo();

                case 10 -> playlist.ordenarPorArtista();

                case 0 -> System.out.println("Encerrando player...");

                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
