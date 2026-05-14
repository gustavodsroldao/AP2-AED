package atividade21;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaPendentes filaPendentes = new FilaPendentes();
        PilhaCancelados pilhaCancelados = new PilhaCancelados();
        
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("\n--- MENU DE PEDIDOS ---");
            System.out.println("1. Adicionar Novo Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Restaurar Pedido");
            System.out.println("5. Imprimir Pedidos Pendentes");
            System.out.println("6. Imprimir Pedidos Cancelados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (!scanner.hasNextInt()) {
                System.out.println("Digite apenas números!");

                scanner.next(); 
                continue;
            }
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do pedido: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    System.out.print("Digite a descrição do pedido: ");
                    String descricao = scanner.nextLine();
                    
                    Pedido novoPedido = new Pedido(id, descricao);
                    filaPendentes.enqueue(novoPedido);
                    System.out.println(" Pedido adicionado à fila de pendentes com sucesso!");
                    break;
                    
                case 2:
                    Pedido pedidoAtendido = filaPendentes.dequeue();
                    if (pedidoAtendido != null) {
                        System.out.println(" Pedido atendido: " + pedidoAtendido);
                    }
                    break;
                    
                case 3:
                    Pedido pedidoCancelado = filaPendentes.dequeue();
                    if (pedidoCancelado != null) {
                        pilhaCancelados.push(pedidoCancelado);
                        System.out.println("Pedido cancelado e movido para a pilha: " + pedidoCancelado);
                    }
                    break;
                    
                case 4:
                    Pedido pedidoRestaurado = pilhaCancelados.pop();
                    if (pedidoRestaurado != null) {
                        filaPendentes.enqueue(pedidoRestaurado);
                        System.out.println("Pedido restaurado para a fila de pendentes: " + pedidoRestaurado);
                    }
                    break;
                    
                case 5:
                    filaPendentes.printQueue();
                    break;
                    
                case 6:
                    pilhaCancelados.printStack();
                    break;
                    
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                    
                default:
                    System.out.println(" Opção inválida! Tente novamente.");
            }
        }
        
        scanner.close();
    }
}
