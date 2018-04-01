/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;


/*******************************************************************************
 * Instance třídy Vec představují věci a jejich popis, se kterými se můžeme setkat ve hře.
 *
 *
 * @author Nikol Šímová
 * @version 2017-05-17
 */
public class Vec {
    private final boolean patri;
    //== Datové atributy (statické i instancí)======================================
    private String nazev;
    private String popis;

    //== Konstruktory a tovární metody =============================================

    /**
     * Konstruktor ....
     *
     * @param nazev        název věci
     * @param popis        popis věci
     * @param patri zda věc patří do košíčku
     */
    public Vec(String nazev, String popis, boolean patri) {
        this.nazev = nazev;
        this.popis = popis;
        this.patri = patri;
    }

    /**
     * Vrátí název věci
     *
     * @return název věci
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Nastaví název věci
     *
     * @param nazev nový název věci
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     * Vrátí popis věci
     *
     * @return popis věci
     */
    public String getPopis() {
        return popis;
    }

    /**
     * Nastaví popis věci
     *
     * @param popis nový popis věci
     */
    public void setPopis(String popis) {
        this.popis = popis;
    }

    /**
     * Vrací zda je věc přenositelná
     *
     * @return true - věc do košíčku patří, false - věc do košíčku nepatří
     */
    public boolean isPatri() {
        return patri;
    }

    /**
     * Generovaná porovnávací funkce equals
     *
     * @param obj porovnávaný objekt
     * @return true/false zda je objekt shodný
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){ return true;}
        if (obj == null || getClass() != obj.getClass()){ return false;}

        Vec vec = (Vec) obj;

        if (nazev != null ? !nazev.equals(vec.nazev) : vec.nazev != null){ return false;}
        return popis != null ? popis.equals(vec.popis) : vec.popis == null;
    }

    /**
     * Vrací hash code objektu
     *
     * @return hash kód objektu
     */
    @Override
    public int hashCode() {
        int result = nazev != null ? nazev.hashCode() : 0;
        result = 31 * result + (popis != null ? popis.hashCode() : 0);
        return result;
    }
}
