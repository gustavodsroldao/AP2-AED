package atividade2;

public class PilhaCancelados {

    private class No {
        Pedido pedido;
        No proximo;
        
        public No(Pedido pedido) {
            this.pedido = pedido;
            this.proximo = null;
        }
    }

    private No topo;

    public PilhaCancelados() {
        this.topo = null;
    }

    public void push(Pedido pedido) {
        No novoNo = new No(pedido);
        novoNo.proximo = this.topo;
        this.topo = novoNo;
    }

    public Pedido pop() {
        if (this.topo == null) {
            System.out.println("A pilha está vazia!");
            return null;
        }
        
        Pedido pedidoRemovido = this.topo.pedido;
        this.topo = this.topo.proximo;
        
        return pedidoRemovido;
    }

    public void printStack() {
        if (this.topo == null) {
            System.out.println("A pilha está vazia!");
            return;
        }
        
        No atual = this.topo;
        System.out.println("Pilha de Pedidos Cancelados:");
        while (atual != null) {
            System.out.println(atual.pedido);
            atual = atual.proximo;
        }
    }
}
