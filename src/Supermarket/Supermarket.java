package Supermarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Supermarket implements SupermarketOperation {
    private String nome;
    private String indirizzo;
    public List<Reparto> reparti;
    public Map<Prodotti, Reparto> prodotti;

    public Supermarket(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.reparti = new ArrayList<>();
        this.prodotti = new HashMap<>();
        SupermarketDatabase.supermarketList.add(this);
    }

    @Override
    public void aggiungiReparto(Reparto r) {
        reparti.add(r);
    }

    @Override
    public void aggiungiProdotto(Reparto r, Prodotti p) {
        prodotti.put(p, r);
    }

    @Override
    public boolean cercaProdotto(Prodotti p) {
        return prodotti.containsKey(p);
    }

    @Override
    public void rimuoviProdotto(Prodotti p) {
        if (!prodotti.containsKey(p)) {
            return;
        } else {
            prodotti.remove(p);
            return;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    @Override
    public String toString() {
        return String.format("%s sito in %s", nome, indirizzo);
    }
}
