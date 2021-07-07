/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;


import static util.Texts.*;

/*******************************************************************************
 * Instance třídy PrikazOdeber představují ...
 *
 * @author    Nikol Šímová
 * @version   2017-05-17
 */
public class PrikazOdeber implements IPrikaz {
    private static final String NAZEV = "odeber";
    private final Hra hra;
    private final Kosicek kosicek;

    /**
     * Konstruktor třídy
     *
     * @param hra hra kterou hráč aktuálně hraje
     * @param kosicek inventář hráče
     */
    public PrikazOdeber(Kosicek kosicek, Hra hra) {
        this.kosicek = kosicek;
        this.hra = hra;
    }

    /**
     * Provádí příkaz "odeber". V košíčku hledá věc, která je předána jako parametr
     *
     * @param parametry - jako  parametr obsahuje jméno věci,
     *                  která se má odebrat.
     * @return zpráva, kterou vypíše hra hráči
     */
     @Override
    public String proved(String... parametry){
        if (parametry.length < 1) {
            // pokud chybí druhé slovo , tak ....
            return tVEC_NEZADANA;
        }

        HerniPlan plan = hra.getHerniPlan();
        String nazevCo = parametry[0];

        // vybereme věc
        Vec vecKosicek = kosicek.vyberVec(nazevCo, false);

        if (vecKosicek == null) {
            return tNENI_V_KOSICKU; //pokud tu věc nemám, vypíšu
        } else {                    //jinak jí mám, dám jí do prostoru a vypíšu
            plan.getAktualniProstor().vlozVec(kosicek.vyberVec(nazevCo, true));
            return tVRACENO_DO_PROSTORU;
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

