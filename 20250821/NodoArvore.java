public class NodoArvore {
    int chave;
    NodoArvore filhoEsquerdo;
    NodoArvore filhoDireito;

    public NodoArvore(int chave) {
        this.chave = chave;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }
}
