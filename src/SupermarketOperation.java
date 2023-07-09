public interface SupermarketOperation {
    void aggiungiReparto(Reparto r);
    void aggiungiProdotto(Reparto r,Prodotti p);
    boolean cercaProdotto(Prodotti p);
    void rimuoviProdotto(Prodotti p);
}
