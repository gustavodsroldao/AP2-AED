package atividade3;

public class CarrosselCircular {
    private Anuncio anuncioAtual;

    public void adicionarAnuncio(int id, String empresa, String descricao) {
        Anuncio novoAnuncio = new Anuncio(id, empresa, descricao);

        if (anuncioAtual == null) {
            anuncioAtual = novoAnuncio;
            novoAnuncio.proximo = novoAnuncio;
        } else {
            novoAnuncio.proximo = anuncioAtual.proximo;
            anuncioAtual.proximo = novoAnuncio;
        }
    }

    public void exibirEAvancar() {
        if (anuncioAtual == null) {
            System.out.println("Não foi possível encontrar o anúncio atual.");  
        } else {
            System.out.println("ID: " + anuncioAtual.id);
            System.out.println("Empresa: " + anuncioAtual.empresa);
            System.out.println("Descrição: " + anuncioAtual.descricao);

            anuncioAtual = anuncioAtual.proximo;
        }
    }

    public void listarCicloCompleto() {
        Anuncio inicio = anuncioAtual;        
        Anuncio atual = anuncioAtual;     

        if (anuncioAtual == null) {
            System.out.println("Não há nenhum anúncio");
            return;
        }
        
        do {
            System.out.println("ID: " + atual.id);
            System.out.println("Empresa: " + atual.empresa);
            System.out.println("Descrição: " + atual.descricao);
            atual = atual.proximo;
        } while (atual != inicio);

    }

    public void removerAnuncio(int id) {

        if (anuncioAtual == null) {
            System.out.println("Não é possível remover um anúncio que não existe.");          
            return;  
        }

        if (anuncioAtual.proximo == anuncioAtual && anuncioAtual.id == id) {
            anuncioAtual = null;
            return;
        }

        Anuncio anterior = anuncioAtual;

        do {
            if (anterior.proximo.id == id) {

                if (anterior.proximo == anuncioAtual) {
                    anuncioAtual = anuncioAtual.proximo;
                }
    
                anterior.proximo = anterior.proximo.proximo;
                return;
            }
            anterior = anterior.proximo;
        } while (anterior != anuncioAtual);

        System.out.println("Anúncio com ID " + id + " não encontrado");
    }
}
