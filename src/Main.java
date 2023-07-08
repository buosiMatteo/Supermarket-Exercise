import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supermarket coop = generaSupermarket(scanner);
        Supermarket tosano = generaSupermarket(scanner);
        coop.aggiungiReparto(Reparto.FRUTTA);
        coop.aggiungiReparto(Reparto.VERDURA);
        coop.aggiungiReparto(Reparto.CARNE);
        coop.aggiungiProdotto(Reparto.FRUTTA, Prodotti.MELE);
        coop.aggiungiProdotto(Reparto.FRUTTA, Prodotti.MELE);
        coop.aggiungiProdotto(Reparto.FRUTTA, Prodotti.PERE);
        coop.aggiungiProdotto(Reparto.VERDURA, Prodotti.CETRIOLI);
        coop.aggiungiProdotto(Reparto.VERDURA, Prodotti.INSALATA);
        coop.aggiungiProdotto(Reparto.VERDURA, Prodotti.POMODORI);
        User utente = new User();
        utente.stampaProdottiSupermarket(coop);
        utente.cercaReparto(coop, Reparto.SURGELATI);
        utente.cercaProdotto(Prodotti.MELE);
        utente.acquistaProdotto(Prodotti.MELE, coop);
        utente.acquistaProdotto(Prodotti.MELE, coop);
    }

    private static Supermarket generaSupermarket(Scanner scanner) {
        System.out.print("Inserisci nome supermercato: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci indirizzo supermercato: ");
        String indirizzo = scanner.nextLine();
        return new Supermarket(nome, indirizzo);
    }
}