package User;

import Supermarket.*;
import Exception.*;

import java.util.List;

public interface UserOperation {

    List<Supermarket> cercaProdotto(Prodotti p);

    boolean cercaProdottoSupermarket(Supermarket s, Prodotti p);

    void stampaProdottiSupermarket(Supermarket s);

    boolean cercaReparto(Supermarket s, Reparto r);

    Prodotti acquistaProdotto(Prodotti p, Supermarket s) throws UnvailableProductException;
}
