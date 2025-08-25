public class ArvoreBinaria implements Arvore {

    private NodoArvore raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    @Override
    public void inserir(int valor) {
        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    private NodoArvore inserirRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null) {
            return new NodoArvore(valor);
        }
        if (valor < noAtual.chave) {
            noAtual.filhoEsquerdo = inserirRecursivo(noAtual.filhoEsquerdo, valor);
        } else if (valor > noAtual.chave) {
            noAtual.filhoDireito = inserirRecursivo(noAtual.filhoDireito, valor);
        }
        return noAtual;
    }

    @Override
    public NodoArvore pesquisa(int valor) {
        return pesquisaRecursivo(this.raiz, valor);
    }

    private NodoArvore pesquisaRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null || noAtual.chave == valor) {
            return noAtual;
        }
        if (valor < noAtual.chave) {
            return pesquisaRecursivo(noAtual.filhoEsquerdo, valor);
        } else {
            return pesquisaRecursivo(noAtual.filhoDireito, valor);
        }
    }

    @Override
    public void remover(int valor) {
        this.raiz = removerRecursivo(this.raiz, valor);
    }

    private NodoArvore removerRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null) {
            return null;
        }

        if (valor < noAtual.chave) {
            noAtual.filhoEsquerdo = removerRecursivo(noAtual.filhoEsquerdo, valor);
        } else if (valor > noAtual.chave) {
            noAtual.filhoDireito = removerRecursivo(noAtual.filhoDireito, valor);
        } else {
            // Caso 1: sem filhos
            if (noAtual.filhoEsquerdo == null && noAtual.filhoDireito == null) {
                return null;
            }
            // Caso 2: apenas um filho
            else if (noAtual.filhoEsquerdo == null) {
                return noAtual.filhoDireito;
            } else if (noAtual.filhoDireito == null) {
                return noAtual.filhoEsquerdo;
            }
            // Caso 3: dois filhos
            else {
                NodoArvore sucessor = encontrarMenor(noAtual.filhoDireito);
                noAtual.chave = sucessor.chave;
                noAtual.filhoDireito = removerRecursivo(noAtual.filhoDireito, sucessor.chave);
            }
        }

        return noAtual;
    }

    private NodoArvore encontrarMenor(NodoArvore no) {
        while (no.filhoEsquerdo != null) {
            no = no.filhoEsquerdo;
        }
        return no;
    }

    @Override
    public void imprimePreFixado() {
        imprimePreFixadoRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimePreFixadoRecursivo(NodoArvore no) {
        if (no != null) {
            System.out.print(no.chave + " ");
            imprimePreFixadoRecursivo(no.filhoEsquerdo);
            imprimePreFixadoRecursivo(no.filhoDireito);
        }
    }

    @Override
    public void imprimeEmOrdem() {
        imprimeEmOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimeEmOrdemRecursivo(NodoArvore no) {
        if (no != null) {
            imprimeEmOrdemRecursivo(no.filhoEsquerdo);
            System.out.print(no.chave + " ");
            imprimeEmOrdemRecursivo(no.filhoDireito);
        }
    }

    @Override
    public void imprimePosFixado() {
        imprimePosFixadoRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimePosFixadoRecursivo(NodoArvore no) {
        if (no != null) {
            imprimePosFixadoRecursivo(no.filhoEsquerdo);
            imprimePosFixadoRecursivo(no.filhoDireito);
            System.out.print(no.chave + " ");
        }
    }
}
