package atividade2;

public class Playlist {
    private No inicio;
    private No fim;
    private No atual;
    private int tamanho;

    public Playlist() {
        inicio = null;
        fim = null;
        atual = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void proximaMusica() {
        if (atual == null) {
            System.out.println("A playlist está vazia.");
            return;
        }
        if (atual.proximo == null) {
            atual = inicio;
        } else {
            atual = atual.proximo;
        }

        tocarMusicaAtual();
    }

    public void musicaAnterior() {
        if (estaVazia()) {
            System.out.println("A playlist está vazia.");
            return;
        }
        if (atual.anterior == null) {
            atual = fim;
        } else {
            atual = atual.anterior;
        }

        tocarMusicaAtual();
    }

    public void ordenarPorTitulo() {

        if (tamanho <= 1) return;

        No atual = inicio;
        Musica musicaAtual;
        if (atual != null) {
            musicaAtual = atual.musica;
        } else {
            musicaAtual = null;
        }


        for (int i = 0; i < tamanho - 1; i++) {

            No menor = atual;
            No musicas = atual.proximo;

            for (int j = i + 1; j < tamanho; j++) {

                if (musicas.musica.getTitulo()
                        .compareToIgnoreCase(menor.musica.getTitulo()) < 0) {
                    menor = musicas;
                }

                musicas = musicas.proximo;
            }

            Musica temp = atual.musica;
            atual.musica = menor.musica;
            menor.musica = temp;

            atual = atual.proximo;
        }

        if (musicaAtual != null) {
            No auxiliar = inicio;

            while (auxiliar != null) {
                if (auxiliar.musica == musicaAtual) {
                    atual = auxiliar;
                    break;
                }
                auxiliar = auxiliar.proximo;
            }
        }

        System.out.println("Playlist ordenada por título.");
    }

    public void ordenarPorArtista() {

        if (tamanho <= 1) return;

        No atual = inicio;
        Musica musicaAtual;
        if (atual != null) {
            musicaAtual = atual.musica;
        } else {
            musicaAtual = null;
        }

        for (int i = 0; i < tamanho - 1; i++) {

            No menor = atual;
            No musicas = atual.proximo;

            for (int j = i + 1; j < tamanho; j++) {

                if (musicas.musica.getArtista()
                        .compareToIgnoreCase(menor.musica.getArtista()) < 0) {
                    menor = musicas;
                }

                musicas = musicas.proximo;
            }

            Musica temp = atual.musica;
            atual.musica = menor.musica;
            menor.musica = temp;

            atual = atual.proximo;
        }

        if (musicaAtual != null) {
            No auxiliar = inicio;

            while (auxiliar != null) {
                if (auxiliar.musica == musicaAtual) {
                    atual = auxiliar;
                    break;
                }
                auxiliar = auxiliar.proximo;
            }
        }

        System.out.println("Playlist ordenada por artista.");
    }

    public void tocarMusicaAtual() {

        if (atual == null) {
            System.out.println("Nenhuma música selecionada.");
            return;
        }

        System.out.println("Tocando agora:");
        System.out.println(atual.musica.toString());

    }

    public void adicionarNoInicio(Musica musica) {

        No novo = new No(musica);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
            atual = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }

        tamanho++;

        System.out.println("Música '" + musica.getTitulo() + "' adicionada no início.");
    }

    public void adicionarNoFim(Musica musica) {

        No novo = new No(musica);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
            atual = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }

        tamanho++;

        System.out.println("Música '" + musica.getTitulo() + "' adicionada no fim.");

    }

    public void adicionarNaPosicao(Musica musica, int posicao) {

        if (posicao <= 0) {
            adicionarNoInicio(musica);
            return;
        }

        if (posicao >= tamanho) {
            adicionarNoFim(musica);
            return;
        }

        No novo = new No(musica);
        No musicas = inicio;

        for (int i = 0; i < posicao; i++) {
            musicas = musicas.proximo;
        }

        novo.proximo = musicas;
        novo.anterior = musicas.anterior;

        musicas.anterior.proximo = novo;
        musicas.anterior = novo;

        tamanho++;

        System.out.println("Música '" + musica.getTitulo() + "' adicionada na posição #" + posicao + ".");

    }

    public void removerPorTitulo(String titulo) {

        if (estaVazia()) {
            System.out.println("Playlist vazia.");
            return;
        }

        No musicas = inicio;

        while (musicas != null) {

            if (musicas.musica.getTitulo().equalsIgnoreCase(titulo)) {

                if (inicio == fim) {

                    inicio = null;
                    fim = null;
                    atual = null;

                    System.out.println("Música '" + titulo + "' removida.");

                }
                else if (musicas == inicio) {

                    if (musicas == atual) {
                        atual = inicio.proximo;
                    }

                    inicio = inicio.proximo;
                    inicio.anterior = null;

                    System.out.println("Música '" + titulo + "' removida do início.");

                }
                else if (musicas == fim) {

                    if (musicas == atual) {
                        atual = fim.anterior;
                    }

                    fim = fim.anterior;
                    fim.proximo = null;

                    System.out.println("Música '" + titulo + "' removida do fim.");

                }
                else {

                    if (musicas == atual) {
                        atual = musicas.proximo;
                    }

                    musicas.anterior.proximo = musicas.proximo;
                    musicas.proximo.anterior = musicas.anterior;

                    System.out.println("Música '" + titulo + "' removida do meio.");
                }

                tamanho--;
                return;
            }

            musicas = musicas.proximo;
        }

        System.out.println("Música não encontrada.");
    }

    public void listarMusicas() {
        if (estaVazia()) {
            System.out.println("A playlist está vazia.");
            return;
        }
        No musicas = inicio;
        int i = 1;

        System.out.println("\nLista de músicas:\n");
        while (musicas != null) {
            System.out.println(i + " - " + musicas.musica);
            System.out.println();

            musicas = musicas.proximo;
            i++;
        }
    }


}
