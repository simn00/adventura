package logika;


import static util.Texts.*;

/**
 * Třída PrikazSeber implementuje pro hru příkaz seber.
 *
 * @author Nikol Šímová
 * @version 2017-05-17
 */
public class PrikazMluv implements IPrikaz {
    private static final String NAZEV = "mluv";
    private final HerniPlan plan;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude hledat aktuální místnost
     */
    public PrikazMluv(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Promluví s herním objektem
     *
     * @param parametry - jako  parametr obsahuje jméno osoby,
     *                  se kterou má mluvit.
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo , tak ....
            return tS_KYM_MLUVIT;
        }

        String jmenoVeci = parametry[0];
        // vybereme věc
        Vec vec = plan.getAktualniProstor().vyberVec(jmenoVeci, false);

        if (vec == null) {
            return tS_KYM_MLUVIT;
        }
        switch (parametry[0]) {
            case MAMINKA:
                return oMAMINKA;
            case MEDVIDEK:
                return oMEDVIDEK;
            default:
                return tMEDVIDEK_NEMLUVI;

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

