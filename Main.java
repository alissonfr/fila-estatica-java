public class Main {
    public static void main(String[] args) {
        //criando objeto fila do tipo FilaEstatica
        // podemos passar o tamanho da fila no FilaEstatica(tamanho), como deixamos vazio vai ficar como 4, nosso valor padrão
        Enfileiravel fila = new FilaEstatica();

        System.out.println("===================");
        System.out.println("  Fila Estática  ");
        System.out.println("===================");

        fila.enfileirar("Elemento 1");
        System.out.println(fila.verificar());
        fila.enfileirar("Elemento 2");
        System.out.println(fila.verificar());
        fila.desenfileirar();
        System.out.println(fila.verificar());
        fila.enfileirar("Elemento 3");
        fila.enfileirar("Elemento 4");
        fila.desenfileirar();
        System.out.println(fila.verificar());
        System.out.println(fila.imprimir());
    }
}
