# Relatório Técnico - Atividade 2

## 4.1. Identificação
Responsável: Otávio Caporal

## 4.2 Introdução
A implementação manual de estruturas de dados, como listas duplamente encadeadas, é de extrema importância para a compreensão profunda de como os dados são organizados e manipulados na memória do computador. 
Diferente do uso de coleções prontas (como `ArrayList` ou `LinkedList` do Java), a construção manual exige o gerenciamento explícito de referências (ponteiros no conceito geral) entre os nós. 
Isso desenvolve a capacidade lógica do programador de controlar o ciclo de vida e a conectividade dos objetos, otimizando o uso de memória e compreendendo o custo computacional de cada operação de inserção, remoção e busca na estrutura.

## 4.3 Implementação

### Estrutura do nó
A classe `No` foi desenvolvida para compor uma lista duplamente encadeada. Cada nó possui três atributos principais:
- `musica`: O elemento de dado armazenado no nó (objeto da classe `Musica`).
- `proximo`: Referência para o próximo nó da sequência.
- `anterior`: Referência para o nó anterior da sequência.
Esses atributos permitem que a lista seja percorrida em ambas as direções (do início para o fim e do fim para o início), facilitando operações de navegação, como avançar e voltar músicas em uma playlist.

### Casos críticos tratados no código
- Remoção em lista vazia:** O método `removerPorTitulo` verifica logo no início, através do método `estaVazia()`, se a lista possui elementos. 
Caso esteja vazia, a operação é interrompida imediatamente com uma mensagem ao usuário, evitando exceções de referência nula (`NullPointerException`).

- Atualização de ponteiros (início/fim): As operações de inserção e remoção tratam cuidadosamente as extremidades da lista.
  - Ao remover o único elemento, os ponteiros `inicio`, `fim` e `atual` são redefinidos para `null`.
  - Ao remover do início, o ponteiro `inicio` é atualizado para o próximo nó e o ponteiro `anterior` deste novo início recebe `null`.
  - Ao remover do fim, o ponteiro `fim` é atualizado para o nó anterior e seu ponteiro `proximo` recebe `null`.
  - O mesmo cuidado é aplicado para reatribuir o ponteiro da música `atual` de forma segura, caso o nó selecionado para reprodução seja removido.
  - Prevenção de loops em estruturas circulares: A estrutura implementada optou por uma abordagem de lista duplamente encadeada linear (não-circular). 
  Com isso, o ponteiro `anterior` do primeiro nó (`inicio`) e o ponteiro `proximo` do último nó (`fim`) apontam sempre para `null`. 
  Isso previne naturalmente a ocorrência de loops infinitos durante a iteração da lista, pois os laços de repetição (como no método `listarMusicas`) utilizam a condição `while (musicas != null)` para garantir a parada exata ao fim da estrutura.

## 4.4 Evidências de Execução

1. Adicionando música
![Adicionar música](imagens/imgsatividade2/adicionarMusicaImg.jpeg)

2. Removendo música
![Removendo música](imagens/imgsatividade2/removerPorTituloImg.jpeg)

3. Adicionando mais de uma música, ordenando por artista e listando as músicas
![Listar ordenado por artista](imagens/imgsatividade2/ordenarPorArtistaImg.jpeg)

4. Tocando música atual
![Tocando musica atual](imagens/imgsatividade2/tocarMusicaAtualImg.jpeg)

## 5. Conclusão

Principais dificuldades e soluções:
Uma das principais dificuldades na implementação de listas duplamente encadeadas é a manutenção correta de todos os ponteiros (`proximo` e `anterior`) durante as inserções e, especialmente, nas remoções no meio da lista e nas reordenações (ordenação por título e artista). 
Pequenos descuidos podem "quebrar" a cadeia, isolando nós ou causando erros de referência nula. 
Isso foi resolvido estruturando cuidadosamente as condicionais (`if/else`) para cobrir cada cenário possível (remoção no início, no fim, no meio, ou do único elemento existente) e mapeando o fluxo das referências no papel antes de codificar, além de realizar testes exaustivos para validar as conexões.

Resumo do aprendizado:
O desenvolvimento desta atividade proporcionou um entendimento sólido sobre como as listas encadeadas operam "por baixo dos panos". Ficou evidente o quanto o gerenciamento adequado de referências é crucial para o bom funcionamento de uma aplicação. 
Além disso, a implementação manual dos métodos de ordenação e a adaptação do controle do nó `atual` para a reprodução contínua (avançar e voltar) consolidaram a lógica de programação, reforçando a importância do planejamento estrutural antes da codificação.