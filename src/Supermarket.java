import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Supermarket implements SupermarketOperation {
    String nome;
    String indirizzo;
    List<Reparto> reparti;
    Map<Prodotti, Reparto> prodotti;

    public Supermarket(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.reparti = new ArrayList<>();
        this.prodotti = new HashMap<>();
        SupermarketDatabase.supermarketList.add(this);
    }

    @Override
    public void aggiungiReparto(Reparto r) {
        System.out.printf("Aggiunto il reparto %s al supermarket %s\n", r, nome);
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
    public String toString() {
        return String.format("%s sito in %s", nome, indirizzo);
    }
}
