/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*; 
import static util.Texts.*;

/*******************************************************************************
 * Testovací třída KosicekTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    Nikol Šímová
 * @version   2017-05-17
 */
public class KosicekTest
{
    @Test
    public void vlozAVyberVec() throws Exception {
        Kosicek kosicek= new Kosicek();
        Prostor prostor = new Prostor("TEST1", "test1");
        Vec testovaciVec = new Vec("vec", "testovaci vec", true);
        Vec testovaciVec2 = new Vec("vec2", "druha testovaci vec", false);
        prostor.vlozVec(testovaciVec);
        prostor.vlozVec(testovaciVec2);

        assertEquals(tVEC_VLOZENA, kosicek.vlozVec(prostor.vyberVec("vec", true)));
        assertNull(prostor.vyberVec("vec", true));


        assertEquals(tNEPATRI_DO_KOSICKU, kosicek.vlozVec(testovaciVec2));
        assertEquals(testovaciVec2, prostor.vyberVec("vec2", false));

        assertEquals(testovaciVec, kosicek.vyberVec("vec", false));
        assertEquals(testovaciVec, kosicek.vyberVec("vec", true));
        assertNull(kosicek.vyberVec("vec", true));
    }
    
    @Test
    public void vlozKapicitaKosicku() throws Exception {
        Kosicek kosicek= new Kosicek();
        Prostor prostor = new Prostor("TEST1", "test1");
        Vec testovaciVec = new Vec("vec", "testovaci vec", true);
        Vec testovaciVec2 = new Vec("vec2", "druha testovaci vec", true);
        Vec testovaciVec3= new Vec("vec3", "treti testovaci vec", true);
        prostor.vlozVec(testovaciVec);
        prostor.vlozVec(testovaciVec2);
        prostor.vlozVec(testovaciVec3);

        assertEquals(tVEC_VLOZENA, kosicek.vlozVec(prostor.vyberVec("vec", true)));
        assertNull(prostor.vyberVec("vec", true));

        assertEquals(tVEC_VLOZENA, kosicek.vlozVec(testovaciVec2));
        assertNull(prostor.vyberVec("vec", true));
        
        assertEquals(tNELZE_VLOZIT, kosicek.vlozVec(testovaciVec2));
        assertEquals(testovaciVec3, prostor.vyberVec("vec3", true));

        assertEquals(testovaciVec, kosicek.vyberVec("vec", false));
        assertEquals(testovaciVec, kosicek.vyberVec("vec", true));
        assertNull(kosicek.vyberVec("vec", true));
    }

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
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

    @Test
    public void Test1()
    {
    }
}

