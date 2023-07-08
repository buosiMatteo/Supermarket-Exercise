import java.util.ArrayList;
import java.util.List;

public class User implements UserOperation {
    @Override
    public List<Supermarket> cercaProdotto(Prodotti p) {
        List<Supermarket> list = new ArrayList<>();
        for (Supermarket s : SupermarketDatabase.supermarketList) {
            if (s.cercaProdotto(p)) {
                System.out.printf("Il prodotto %s si trova nel supermarket %s\n", p, s);
                list.add(s);
            }
        }
        return list;
    }

    @Override
    public boolean cercaProdottoSupermarket(Supermarket s, Prodotti p) {
        if (s.cercaProdotto(p)) {
            System.out.println("Il prodotto cercato è presente nel supermarket");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void stampaProdottiSupermarket(Supermarket s) {
        System.out.printf("Nel supermarket %s si trovano questi prodotti:\n",s.toString());
        for (Prodotti p : s.prodotti.keySet()) {
            System.out.printf("\t - %s\n",p.toString());
        }
    }

    @Override
    public boolean cercaReparto(Supermarket s,Reparto r) {
        if (s.reparti.contains(r)){
            System.out.printf("Il reparto %s è presente nel supermarket %s\n",r.toString(),s);
            return true;
        } else {
            System.out.printf("Il reparto %s non è presente nel supermarket %s\n",r.toString(),s);
            return false;
        }
    }

    @Override
    public Prodotti acquistaProdotto(Prodotti p, Supermarket s) {
        if (s.prodotti.containsKey(p)){
            System.out.println("Il prodotto è diponibile");
            s.prodotti.remove(p);
            return p;
        } else {
            System.out.println("Il prodotto non è disponibile ");
            return null;
        }
    }
}
