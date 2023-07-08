import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supermarket coop = generaSupermarket(scanner);
        Supermarket lidl = generaSupermarket(scanner);
        inizializzaSupermecatoBase(coop);
        inizializzaSupermercatoGrande(lidl);
        User user = new User();
        user.stampaProdottiSupermarket(coop);
        user.cercaReparto(coop, Reparto.SURGELATI);
        user.cercaProdotto(Prodotti.MELE);
        user.acquistaProdotto(Prodotti.MELE, coop);
        user.acquistaProdotto(Prodotti.MELE, coop);
        Cart cart1 = new Cart(user,lidl);
        cart1.aggiungiProdotti(Prodotti.MELE);
        cart1.aggiungiProdotti(Prodotti.PERE);
        cart1.stampaCarrello();
        cart1.checkoutCarrello();
    }

    private static void inizializzaSupermercatoGrande(Supermarket s) {
        s.aggiungiReparto(Reparto.FRUTTA);
        s.aggiungiReparto(Reparto.VERDURA);
        s.aggiungiReparto(Reparto.CARNE);
        s.aggiungiReparto(Reparto.PESCE);
        s.aggiungiReparto(Reparto.SURGELATI);
        s.aggiungiProdotto(Reparto.FRUTTA, Prodotti.MELE);
        s.aggiungiProdotto(Reparto.FRUTTA, Prodotti.PERE);
        s.aggiungiProdotto(Reparto.FRUTTA, Prodotti.FRAGOLE);
        s.aggiungiProdotto(Reparto.FRUTTA, Prodotti.ALBICOCCHE);
        s.aggiungiProdotto(Reparto.VERDURA, Prodotti.INSALATA);
        s.aggiungiProdotto(Reparto.VERDURA, Prodotti.CETRIOLI);
        s.aggiungiProdotto(Reparto.VERDURA, Prodotti.POMODORI);
        s.aggiungiProdotto(Reparto.CARNE, Prodotti.MAIALE);
        s.aggiungiProdotto(Reparto.CARNE, Prodotti.MANZO);
        s.aggiungiProdotto(Reparto.CARNE, Prodotti.POLLO);
        s.aggiungiProdotto(Reparto.CARNE, Prodotti.TACCHINO);
        s.aggiungiProdotto(Reparto.PESCE, Prodotti.SPIGOLA);
        s.aggiungiProdotto(Reparto.PESCE, Prodotti.CALAMARO);
        s.aggiungiProdotto(Reparto.PESCE, Prodotti.ORATA);
        s.aggiungiProdotto(Reparto.PESCE, Prodotti.SEPPIA);
        s.aggiungiProdotto(Reparto.SURGELATI, Prodotti.GELATI);
        s.aggiungiProdotto(Reparto.SURGELATI, Prodotti.PIZZA);
        s.aggiungiProdotto(Reparto.SURGELATI, Prodotti.PATATE_FRITTE);
        s.aggiungiProdotto(Reparto.SURGELATI, Prodotti.MINESTRONE);
    }

    private static void inizializzaSupermecatoBase(Supermarket s) {
        s.aggiungiReparto(Reparto.FRUTTA);
        s.aggiungiReparto(Reparto.VERDURA);
        s.aggiungiReparto(Reparto.CARNE);
        s.aggiungiProdotto(Reparto.FRUTTA, Prodotti.MELE);
        s.aggiungiProdotto(Reparto.FRUTTA, Prodotti.MELE);
        s.aggiungiProdotto(Reparto.FRUTTA, Prodotti.PERE);
        s.aggiungiProdotto(Reparto.VERDURA, Prodotti.CETRIOLI);
        s.aggiungiProdotto(Reparto.VERDURA, Prodotti.INSALATA);
        s.aggiungiProdotto(Reparto.VERDURA, Prodotti.POMODORI);
    }

    private static Supermarket generaSupermarket(Scanner scanner) {
        System.out.print("Inserisci nome supermercato: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci indirizzo supermercato: ");
        String indirizzo = scanner.nextLine();
        return new Supermarket(nome, indirizzo);
    }
}