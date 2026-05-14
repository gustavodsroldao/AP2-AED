package atividade1;

public class FilaPendentes {

    private No inicio;
    private No fim;

    public FilaPendentes() {
        this.inicio = null;
        this.fim = null;
    }


    public void enqueue(Pedido pedido) {
        No novoNo = new No(pedido);
        
        if (this.fim == null) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            this.fim.proximo = novoNo;
            this.fim = novoNo;
        }
    }

   
    public Pedido dequeue() {
        if (this.inicio == null) {
            System.out.println("A fila está vazia!");
            return null;
        }
        
        Pedido pedidoRemovido = this.inicio.pedido;
        this.inicio = this.inicio.proximo;
        

        if (this.inicio == null) {
            this.fim = null;
        }
        
        return pedidoRemovido;
    }

    
    public void printQueue() {
        if (this.inicio == null) {
            System.out.println("A fila está vazia!");
            return;
        }
        
        No atual = this.inicio;
        System.out.println("Fila de Pedidos Pendentes:");
        while (atual != null) {
            System.out.println(atual.pedido);
            atual = atual.proximo;
        }
    }
}
