public class Main {
    public static void main(String[] args) {
        Arvore arvore = new ArvoreBinaria();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Caminhamento Pré-fixado:");
        arvore.imprimePreFixado();  
        System.out.println("Caminhamento Em Ordem:");
        arvore.imprimeEmOrdem();    

        System.out.println("Caminhamento Pós-fixado:");
        arvore.imprimePosFixado();  
      
        System.out.println("\nRemovendo 20 (nó folha):");
        arvore.remover(20);
        arvore.imprimeEmOrdem();    

        System.out.println("\nRemovendo 30 (nó com um filho):");
        arvore.remover(30);
        arvore.imprimeEmOrdem();    

        System.out.println("\nRemovendo 50 (nó com dois filhos):");
        arvore.remover(50);
        arvore.imprimeEmOrdem();    
    }
}
