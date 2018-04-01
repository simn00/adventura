package com.github.simn00.adventura.logika;

import static com.github.simn00.adventura.util.Texts.*;

/**
 * Třída Hra - třída představující logiku adventury.
 * <p>
 * Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 * a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 * Vypisuje uvítací a ukončovací text hry.
 * Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 * @author Nikol Šímová
 * @version 2017-05-17
 */

public class Hra implements IHra {
    private final SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private final HerniPlan herniPlan;
    private boolean konecHry = false;
    private Kosicek kosicek;

    /**
     * Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() {
        herniPlan = new HerniPlan();
        kosicek = new Kosicek();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan, kosicek));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazSeber(herniPlan, kosicek));
        platnePrikazy.vlozPrikaz(new PrikazProzkoumej(herniPlan, kosicek));
        platnePrikazy.vlozPrikaz(new PrikazMluv(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPomoc());
        platnePrikazy.vlozPrikaz(new PrikazOdeber(kosicek, this));


    }

    /**
     * Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        return UVODNI_TEXT +
                "\nNapište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                herniPlan.getAktualniProstor().dlouhyPopis();
    }

    /**
     * Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "Díky za hru. Doufám, že se zase brzy uvidíme.";
    }

    /**
     * Vrací true, pokud hra skončila.
     */
    public boolean konecHry() {
        return konecHry;
    }

    /**
     * Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     * Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     * Pokud ano spustí samotné provádění příkazu.
     *
     * @param radek text, který zadal uživatel jako příkaz do hry.
     * @return vrací se řetězec, který se má vypsat na obrazovkuf
     * 
     */

        public String zpracujPrikaz(String radek) {
        String[] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String[] parametry = new String[slova.length - 1];
        for (int i = 0; i < parametry.length; i++) {
            parametry[i] = slova[i + 1];
        }
        String textKVypsani;
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.proved(parametry);
            if (getHerniPlan().getAktualniProstor().getNazev().equals(BABICKA)
                    || getHerniPlan().getAktualniProstor().getNazev().equals(CESTA1)) {
                setKonecHry(true);
            }
        } else {
            textKVypsani = "Tenhle příkaz neznám, zkus to znovu.";
        }
        return textKVypsani;
    }
    
    
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }

    /**
     * Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     * kde se jejím prostřednictvím získává aktualní místnost hry.
     *
     * @return odkaz na herní plán
     */
    @Override
    public HerniPlan getHerniPlan() {
        return herniPlan;
    }

    public Kosicek getKosicek() {
        return kosicek;
    }

    
    
}

