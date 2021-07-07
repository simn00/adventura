/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HerniPlanTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    Nikol Šímová
 * @version   2017-05-17
 */
public class HerniPlanTest
{
    private HerniPlan plan;
    
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp() throws Exception 
    {
        plan = new HerniPlan();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void setAktualniProstor() throws Exception 
    {
         Prostor prostor = plan.getAktualniProstor().vratSousedniProstor("loznice");
        plan.setAktualniProstor(prostor);
        assertEquals(prostor, plan.getAktualniProstor());
    }

   
}
