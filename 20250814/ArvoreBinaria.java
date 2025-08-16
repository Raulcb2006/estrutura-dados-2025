public class ArvoreBinaria implements Arvore {

    private NodoArvore raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }  

    // --- MÉTODO DE INSERÇÃO ---
    @Override
    public void inserir(int valor) {
        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    // Método auxiliar recursivo
    private NodoArvore inserirRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null) {
            return new NodoArvore(valor); // cria um novo nó
        }

        if (valor < noAtual.chave) {
            noAtual.filhoEsquerda = inserirRecursivo(noAtual.filhoEsquerda, valor);
        } else if (valor > noAtual.chave) {
            noAtual.filhoDireita = inserirRecursivo(noAtual.filhoDireita, valor);
        } else {
            // se for igual, não insere (árvore de busca não aceita duplicados por padrão)
        }

        return noAtual;
    }

    // --- MÉTODO DE PESQUISA ---
    @Override
    public NodoArvore pesquisa(int valor) {
        return pesquisaRecursivo(this.raiz, valor);
    }

    private NodoArvore pesquisaRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null || noAtual.chave == valor) {
            return noAtual;
        }

        if (valor < noAtual.chave) {
            return pesquisaRecursivo(noAtual.filhoEsquerda, valor);
        } else {
            return pesquisaRecursivo(noAtual.filhoDireita, valor);
        }
    }

    // --- NÃO IMPLEMENTADOS AINDA ---
    @Override
    public void remover(int valor) {
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public void imprime_preFixado() {
        throw new UnsupportedOperationException("Unimplemented method 'imprime_preFixado'");
    }
}
