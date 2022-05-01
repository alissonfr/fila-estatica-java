// FilaEstatica implementando o comportamento Enfileiravel, ou seja,
// é necessário implementar todos os métodos na interface Enfileiravel aqui.
public class FilaEstatica implements Enfileiravel {

        // definindo variáveis. "inicioFila" e "finalFila" controlam respectivamente o começo e o fim da fila
    private int inicioFila, finalFila;
        // os dois ponteiros acima vão guardar as posições no array "dados" abaixo
    private Object[] dados;

    // Construtor que definine o tamanho padrão da fila
    public FilaEstatica() {
        this(4);
    }

    // Construtor que recebe uma variável inteira "tamanho" e passa esse tamanho para criar o array
    // Também é define o inicio e o fim da fila como -1 (que é 1º posição inválida do array, pois o array inicia no 0)
    public FilaEstatica(int tamanho) {
        inicioFila = -1;
        finalFila = -1;
        dados = new Object[tamanho];
    }

    // Metódo enfileirar: primeiro verifica se a fila não está cheia.
        // Se não estiver cheia, incrementa o ponteiro final para uma posição válida, e passa o elemento inserido para o final da fila
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

    // Fila vazia: quando os ponteiros de inicio e fim apontam para o mesmo valor (não necessáriamente -1), pois, significa que foram feitos a mesma quantidade de enfileiramentos e desenfileiramentos
    public boolean estaVazia(){
        return (inicioFila == finalFila);
    }

    // imprime todos os elementos restantes da minha fila
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