/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static util.Texts.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class HraTest
{
    private Hra hra1;
    
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void Vyhra()
    {
        hra1 = new Hra();
        
    }

    /***************************************************************************
     * 
     */
    @After
    public void vyhra()
    {
        this.hra1.zpracujPrikaz("jdi loznice");
        this.hra1.zpracujPrikaz("jdi chodba");
        this.hra1.zpracujPrikaz("jdi kuchyne");
        this.hra1.zpracujPrikaz("seber babovka");
        this.hra1.zpracujPrikaz("jdi spiz");
        this.hra1.zpracujPrikaz("jdi sklad");
        this.hra1.zpracujPrikaz("seber vino");
        this.hra1.zpracujPrikaz("jdi chodba");
        this.hra1.zpracujPrikaz("jdi dvorek");
        this.hra1.zpracujPrikaz("jdi cesta2");
        assertFalse(this.hra1.konecHry());
        assertEquals(this.hra1.getHerniPlan().getAktualniProstor()
                        .vratSousedniProstor(BABICKA).dlouhyPopis(),
                this.hra1.zpracujPrikaz("jdi babicka"));
        assertTrue(this.hra1.konecHry());
        assertEquals(BABICKA, this.hra1.getHerniPlan().getAktualniProstor().getNazev());
        
    }
    
    
    
  

    //== VLASTNÍ TESTY =========================================================
    //
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXxx()
    //     {
    //     }
}
