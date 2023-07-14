package Cart;

import Supermarket.*;
import User.*;
import Exception.*;

import java.util.ArrayList;
import java.util.List;

public class Cart implements CartOperation {

    private final User owner;

    private final Supermarket supermarket;
    private final List<Prodotti> prodotti;

    public Cart(User owner, Supermarket supermarket) {
        this.owner = owner;
        this.supermarket = supermarket;
        this.prodotti = new ArrayList<>();
    }

    @Override
    public void stampaCarrello() {
        System.out.println("nel tuo carrello ci sono questi prodotti:");
        for (Prodotti p : prodotti) {
            System.out.printf("\t - %s \n", p);

        }
    }

    @Override
    public void rimuoviProdotto(Prodotti p) {
        System.out.printf("Hai rimosso %s dal tuo carrello:", p);
        prodotti.remove(p);

    }

    @Override
    public void aggiungiProdotti(Prodotti p) {
        try {
            if (supermarket.cercaProdotto(p)) {
                System.out.printf("Hai aggiunto %s al tuo carrello\n", p);
                prodotti.add(owner.acquistaProdotto(p, supermarket));
                supermarket.rimuoviProdotto(p);
            } else {
                System.out.println("Prodotto non disponibile");
            }
        } catch (UnvailableProductException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void checkoutCarrello() {
        System.out.println("Elenco dei prodotti nel carrello:");
        for (Prodotti p : prodotti) {
            System.out.printf("\t - %s\n", p);
        }
        System.out.print("Valore prodotti nel carrello: ");
        int valoreTotale = 0;
        for (Prodotti p : prodotti) {
            valoreTotale += p.getPrezzo();
        }
        System.out.print(valoreTotale);
        System.out.println();
    }
}
