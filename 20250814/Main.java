public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(8);
        arvore.inserir(3);
        arvore.inserir(10);
        arvore.inserir(1);
        arvore.inserir(6);
        arvore.inserir(14);

        // Teste da pesquisa
        NodoArvore resultado = arvore.pesquisa(6);
        if (resultado != null) {
            System.out.println("Encontrado: " + resultado.chave);
        } else {
            System.out.println("Não encontrado!");
        }
    }
}

