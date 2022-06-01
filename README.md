# Fila Estática em Java

Atividade proposta na matéria Estruturas de Dados. Estrutura Fila Estática explicada linha por linha.

#

# Interface

Interface: definindo o conjunto de operações (métodos) que uma fila deve ter para que seja considerada uma fila.

Todas as classes que implementarem essa interface vão ter que obrigatoriamente implementar esses métodos:

```java
public interface Enfileiravel {
        // métodos principais:
    void enfileirar(Object elemento);
    Object desenfileirar();
    Object verificar();

        // métodos auxiliares:
    boolean estaCheia();
    boolean estaVazia();
    String imprimir();
}
```
Para um elemento se considerar uma fila, ele tem que ter um comportamento enfileiravel, ou seja, tem que ter pelo menos esses métódos acima

# Classe Fila Estática

FilaEstatica implementando o comportamento Enfileiravel, ou seja, é necessário implementar todos os métodos na interface Enfileiravel aqui.

```java
public class FilaEstatica implements Enfileiravel {

       // definindo variáveis. "inicioFila" e "finalFila" controlam respectivamente o começo e o fim da fila
    private int inicioFila, finalFila;
       // os dois ponteiros acima vão guardar as posições no array "dados" abaixo
    private Object[] dados;
    
    // Construtor que recebe uma variável inteira "tamanho" e passa esse tamanho para criar o array
       // Também define o inicio e o fim da fila como -1 (que é 1º posição inválida do array, pois o array inicia no 0)
    public FilaEstatica(int tamanho) {
        inicioFila = -1;
        finalFila = -1;
        dados = new Object[tamanho];
    }

    // Metódo enfileirar: primeiro verifica se a fila não está cheia.
        // Se não estiver cheia, incrementa o ponteiro final em + 1 e passa o elemento inserido para o final da fila
        // Se estiver cheia, retorna uma mensagem de erro
    public void enfileirar(Object elemento){
        if (!estaCheia()) {
            finalFila++;
            dados[finalFila] = elemento;
        } else {
            System.err.println("A fila está cheia!");
        }
    }

    // Método desenfileirar: primeiro verificamos se a fila não está vazia.
        // Se não estiver vazia, incrementa o ponteiro inicial, pega o elemento que está nessa posição e atribui ele à elementoInicio
        // Se estiver vazia vai retornar uma mensagem de erro.
    public Object desenfileirar(){
        //  variável "elementoInicio" guarda o elemento que foi desenfileirado
        Object elementoInicio = null;
        if (!estaVazia()) {
            inicioFila++;
            elementoInicio = dados[inicioFila];
        } else {
            System.err.println("A fila está vazia!");
        }
        return elementoInicio;
    }

    // Método verificar: é bem parecido com o desenfileirar, porém, ele não vai mexer nos ponteiros, pois só queremos  que ele espie o elemento que está na 1ª posição da fila
    public Object verificar(){
        Object elementoInicio = null;
        if (!estaVazia()) {
            elementoInicio = dados[inicioFila+1];
        } else {
            System.err.println("A fila está vazia!");
        }
        return elementoInicio;
    }

    // Fila cheia: quando o ponteiro de fim chegou ao tamanho do meu array - 1  (a última posição válida do meu array)
    public boolean estaCheia(){
        return (finalFila == dados.length-1);
    }

    // Fila vazia: quando os ponteiros de inicio e fim apontam para o mesmo valor (não necessariamente -1), pois, significa que foram feitos a mesma quantidade de enfileiramentos e desenfileiramentos
    public boolean estaVazia(){
        return (inicioFila == finalFila);
    }

    // Imprime todos os elementos restantes da minha fila
    public String imprimir(){
        String resultado = "[";
        for (int i = inicioFila+1; i <= finalFila; i++) {
            if (i == finalFila)
                resultado += dados[i];
            else
                resultado += dados[i] + ",";

        }
        return resultado + "]";
    }
}
```


# Classe Principal

```java
public class Main {
    public static void main(String[] args) {
        //criando objeto fila do tipo FilaEstatica
        // passando o tamanho da fila no FilaEstatica
        Enfileiravel fila = new FilaEstatica(4);

        System.out.println("===================");
        System.out.println("  Fila Estática  ");
        System.out.println("===================");

        fila.enfileirar("Elemento 1");
        fila.enfileirar("Elemento 2");
        fila.enfileirar("Elemento 3");
        fila.enfileirar("Elemento 4");
        System.out.println(fila.imprimir());
        fila.desenfileirar();
        System.out.println(fila.verificar());
        fila.desenfileirar();
        System.out.println(fila.verificar());
    }
}


```
