package logika;


import java.util.HashMap;
import java.util.Map;

import static util.Texts.*;

/**
 * Trida Kosicek
 *
 * @author Nikol Šímová
 * @version 2017-05-17
 */

class Kosicek {
    private static final int KAPACITA = 2;
    private final Map<String, Vec> seznamVeci;   // seznam věcí v košíčku

    public Kosicek() {
        seznamVeci = new HashMap<>();
    }

    /**
     * Vkládání věcí do košíčku
     *
     * @param vec instance věci, která se má vložit
     * @return odpověĎ programu, zda se povedlo vložit věc
     */
    public String vlozVec(Vec vec) {
        if (!vec.isPatri()) {
            return tNEPATRI_DO_KOSICKU;
        }
        if (vec.getNazev().equals ("babovka")) {
            seznamVeci.put(vec.getNazev(), vec);
            return tBABOVKA_SEBRANA;
        }
        if (seznamVeci.size() < KAPACITA) {
            seznamVeci.put(vec.getNazev(), vec);
            return tVEC_VLOZENA;
        }
        
        return tNELZE_VLOZIT;
    }

    /**
     * Vrátí námm názvy věcí, které jsou v košíčku
     *
     * @return řetězec názvů
     */
    public String nazvyVeci() {
        String nazvy = "věci v košíčku: ";
        for (String jmenoVeci : seznamVeci.keySet()) {
            nazvy += jmenoVeci + " ";
        }
        return nazvy;
    }


    /** 
     * Hledá věc daného jména a pokud je v košíčku, tak ji vrátí a vymaže ze seznamu
     *
     * @param jmeno Jméno věci
     * @param odebrat zdali se má věc odebrat
     * @return věc nebo hodnota null, pokud tam věc daného jména není
     */
    
    public Vec vyberVec(String jmeno, boolean odebrat) {
        Vec nalezenaVec = null;
        if (seznamVeci.containsKey(jmeno)) {
            nalezenaVec = seznamVeci.get(jmeno);
            if (odebrat) {
                seznamVeci.remove(jmeno);
            }
        }
        return nalezenaVec;
    }
   

}



