public interface CartOperation {
    void stampaCarrello();
    void rimuoviProdotto(Prodotti p);
    void aggiungiProdotti(Prodotti p);
    void checkoutCarrello();
}
