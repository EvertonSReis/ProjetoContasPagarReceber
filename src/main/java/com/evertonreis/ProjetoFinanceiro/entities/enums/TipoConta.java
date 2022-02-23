public enum TipoConta {
    RECEBER(0),
    PAGAR(1);

    private int tipo;

    TipoConta(int tipo) {
        this.tipo = tipo;
    }
    public int getTipo(){
        return tipo;
    }
}
