package com.github.simn00.adventura.logika;

/**
 * Třída implementující toto rozhraní bude ve hře zpracovávat jeden konkrétní příkaz.
 * Toto rozhraní je součástí jednoduché textové hry.
 *
 * @author Nikol Šímová
 * @version 2017-05-17
 */
interface IPrikaz {

    /**
     * Metoda pro provedení příkazu ve hře.
     * Počet parametrů je závislý na konkrétním příkazu,
     * např. příkazy konec a napoveda nemají parametry
     * příkazy jdi, seber, mluv, zahod, prozkoumej mají jeden parametr
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     *                  @return odpověď hry
     */
    String proved(String... parametry);

    /**
     * Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     * @return nazev prikazu
     */
    String getNazev();

}
