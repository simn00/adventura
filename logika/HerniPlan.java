package logika;

import static util.Texts.*;

/**
 * Class HerniPlan - třída představující mapu a stav adventury.
 * <p>
 * Tato třída inicializuje prvky ze kterých se hra skládá:
 * vytváří všechny prostory,
 * propojuje je vzájemně pomocí východů
 * a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 * @author Nikol Šímová
 * @version 2017-05-17
 */
public class HerniPlan {

    private Prostor aktualniProstor;

    /**
     * Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }

    /**
     * Vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
       Prostor pokojicek = new Prostor(POKOJICEK, pPOKOJICEK);
        Prostor loznice = new Prostor(LOZNICE, pLOZNICE);
        Prostor satna = new Prostor(SATNA, pSATNA);
        Prostor spiz = new Prostor(SPIZ, pSPIZ);
        Prostor kuchyne = new Prostor(KUCHYNE, pKUCHYNE);
        Prostor chodba = new Prostor(CHODBA, pCHODBA);
        Prostor dvorek = new Prostor(DVOREK, pDVOREK);
        Prostor cesta1 = new Prostor(CESTA1, pCESTA1);
        Prostor cesta2 = new Prostor(CESTA2, pCESTA2);
        Prostor babicka = new Prostor(BABICKA, pBABICKA);
  



        // přiřazují se průchody mezi prostory (sousedící prostory)
        pokojicek.setVychod(loznice);
        loznice.setVychod(pokojicek);
        loznice.setVychod(satna);
        satna.setVychod(loznice);
        loznice.setVychod(chodba);
        chodba.setVychod(loznice);
        chodba.setVychod(kuchyne);
        kuchyne.setVychod(chodba);
        kuchyne.setVychod(spiz);
        spiz.setVychod(kuchyne);
        chodba.setVychod(dvorek);
        dvorek.setVychod(chodba);
        dvorek.setVychod(cesta1);
        cesta1.setVychod(dvorek);
        dvorek.setVychod(cesta2);
        cesta2.setVychod(dvorek);
        cesta2.setVychod(babicka);
        //cesta2.setVychod(babicka) POTŘEBUJU SE DOSTAT Z CESTY2 K BABIČCE;//cest
        
     
      
        // umístíme věci do světa
        pokojicek.vlozVec(new Vec(MEDVIDEK, pMEDVIDEK, true));
        satna.vlozVec(new Vec(SKRIN, pSKRIN, false));
        satna.vlozVec(new Vec(BRYLE, pBRYLE, true));
        spiz.vlozVec(new Vec(UHERAK, pUHERAK, true));
        spiz.vlozVec(new Vec(JAHODY, pJAHODY, true));
        spiz.vlozVec(new Vec(VINO, pVINO, true));
        kuchyne.vlozVec(new Vec(BABOVKA, pBABOVKA, true));
        loznice.vlozVec(new Vec(POSTEL, pPOSTEL, false));
        chodba.vlozVec(new Vec(MAMINKA, pMAMINKA, false));
        cesta2.vlozVec(new Vec(RUZE, pRUZE, true));


        aktualniProstor = pokojicek;  // hra začíná ve tvém pokoji
    }

    /**
     * Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     * @return aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     * Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     * @param prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }


}
