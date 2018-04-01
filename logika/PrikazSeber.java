package logika;


import static util.Texts.*;

/**
 * Třída PrikazSeber implementuje pro hru příkaz seber.
 *
 * @author Nikol Šímová
 * @version 2017-05-17
 */
public class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";
    private final HerniPlan plan;
    private final Kosicek kosicek;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude hledat aktuální místnost
     * @param kosicek inventář hráče
     */
    public PrikazSeber(HerniPlan plan, Kosicek kosicek) {
        this.plan = plan;
        this.kosicek = kosicek;
    }

    /**
     * Provádí příkaz "seber". V aktuální místnosti hledá věc, která je předána jako parametr
     *
     * @param parametry - jako  parametr obsahuje jméno věci,
     *                  která se má sebrat.
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo , tak ....
            return tVEC_NEZADANA;
        }

        String jmenoVeci = parametry[0];

        // vybereme věc
        Vec vec = plan.getAktualniProstor().vyberVec(jmenoVeci, false);

        if (vec == null) {
            return tVEC_TU_NENI;
        } else {
            // uložíme věc do batohu
            return (vec.isPatri() ? kosicek.vlozVec(vec) : tNEMOHU_VZIT);
        }
    }

    /**
     * Vrací název příkazu
     *
     * @return název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}

