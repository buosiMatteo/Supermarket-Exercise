import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supermarket coop = generaSupermarket(scanner);
        Supermarket lidl = generaSupermarket(scanner);
        inizializzaSupermecatoBase(coop);
        inizializzaSupermercatoGrande(lidl);
        User user = new User();
        Cart cart1 = new Cart(user, lidl);
        menuUtente(user, scanner);
        menuCarrello(cart1, scanner);
    }

    private static void menuCarrello(Cart cart1, Scanner scanner) {
        boolean hasNextLine = true;
        while (hasNextLine) {
            System.out.println("Menu carrello:");
            System.out.println("\t - A = aggiungi prodotto al carrello");
            System.out.println("\t - B = stampa prodotti nel carrello");
            System.out.println("\t - C = esegui checkout del carrello");
            System.out.println("\t - X = esci dal menu");
            System.out.print("Esegui una scelta: ");
            String choose = scanner.nextLine();
            char option = choose.trim().toUpperCase().charAt(0);
            switch (option){
                case 'A':
                    try {
                        Prodotti p = selezionaProdotto(scanner);
                        cart1.aggiungiProdotti(p);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 'B':
                    cart1.stampaCarrello();
                    break;
                case 'C':
                    cart1.checkoutCarrello();
                    break;
                case 'X':
                    hasNextLine=false;
                    break;
                default:
                    System.out.println("Scelta non riconosciuta");
            }
        }
    }

    private static void menuUtente(User user, Scanner scanner) {
        boolean hasNextLine = true;
        while (hasNextLine) {
            System.out.println("Menu utente:");
            System.out.println("\t - A = cerca prodotto tra i supermercati");
            System.out.println("\t - B = cerca prodotto in un supermercato");
            System.out.println("\t - C = stampa prodotti di un supermercato");
            System.out.println("\t - D = cerca reparto in un supermercato");
            System.out.println("\t - E = acquista prodotto in un supermercato");
            System.out.println("\t - X = esci dal menu");
            System.out.print("Esegui una scelta: ");
            String choose = scanner.nextLine();
            char option = choose.trim().toUpperCase().charAt(0);
            switch (option) {
                case 'A':
                    try {
                        Prodotti p = selezionaProdotto(scanner);
                        user.cercaProdotto(p);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 'B':
                    try {
                        Supermarket s1 = selezionaSupermarket(scanner);
                        Prodotti p1 = selezionaProdotto(scanner);
                        user.cercaProdottoSupermarket(s1, p1);
                        break;
                    } catch (SupermarketNotExistException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 'C':
                    try {
                        Supermarket s1 = selezionaSupermarket(scanner);
                        user.stampaProdottiSupermarket(s1);
                        break;
                    } catch (SupermarketNotExistException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 'D':
                    try {
                        Reparto r2 = selezionaReparto(scanner);
                        Supermarket s2 = selezionaSupermarket(scanner);
                        user.cercaReparto(s2, r2);
                        break;
                    } catch (IllegalArgumentException | SupermarketNotExistException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 'E':
                    try {
                        Prodotti p3 = selezionaProdotto(scanner);
                        Supermarket s3 = selezionaSupermarket(scanner);
                        user.acquistaProdotto(p3, s3);
                        break;
                    } catch (SupermarketNotExistException | UnvailableProductExeption |
                             IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 'X':
                    hasNextLine = false;
                    break;
                default:
                    System.out.println("Scelta non riconosciuta");
            }
        }
    }

    private static Reparto selezionaReparto(Scanner scanner) throws IllegalArgumentException {
        System.out.println("Seleziona reparto:");
        String r1 = scanner.nextLine();
        return Reparto.valueOf(r1.trim().toUpperCase());
    }


    private static Prodotti selezionaProdotto(Scanner scanner) throws IllegalArgumentException {
        System.out.print("Quale prodotto vuoi cercare? ");
        String str = scanner.nextLine();
        str = str.toUpperCase().trim();
        return Prodotti.valueOf(str);
    }


    private static Supermarket selezionaSupermarket(Scanner scanner) throws SupermarketNotExistException {
        System.out.print("Seleziona supermercato: ");
        String s1 = scanner.nextLine().trim().toUpperCase();
        for (Supermarket s : SupermarketDatabase.supermarketList) {
            if (s.nome.equals(s1)) {
                return s;
            }
        }
        throw new SupermarketNotExistException();
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