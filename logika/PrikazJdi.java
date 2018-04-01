package logika;

import static util.Texts.*;

/**
 * Třída PrikazJdi implementuje pro hru příkaz jdi.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Nikol Šímová
 * @version 2017-05-17
 */
class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private final HerniPlan plan;
    private final Kosicek kosicek;

    /**
     * Konstruktor třídy
     *
     * @param plan  herní plán, ve kterém se bude ve hře "chodit"
     * @param kosicek inventář hráče
     */
    public PrikazJdi(HerniPlan plan, Kosicek kosicek) {
        this.plan = plan;
        this.kosicek = kosicek;
    }

    /**
     * Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     * existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     * (východ) není, vypíše se chybové hlášení.
     *
     * @param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                  do kterého se má jít.
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Musíš napsat, kam chceš jít.";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null) {
            return "Tam cesta odtud nevede.";
        } else {
            if (sousedniProstor.getNazev().equals(DVOREK) &&
                    (kosicek.vyberVec(VINO, false) == null)) {
                return tNENI_VINO;
            }
            if (sousedniProstor.getNazev().equals(DVOREK) &&
                    (kosicek.vyberVec(BABOVKA, false) == null)) {
                return tNENI_BABOVKA;
            }

            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis();
        }
    }

    /**
     * Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     * @return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
