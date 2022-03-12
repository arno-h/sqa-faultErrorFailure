package at.campus02.example;

import org.junit.Assert;
import org.junit.Test;

public class TestFaultOne {

    @Test(expected = NullPointerException.class)
    public void expectException() {
        // Fault (Bug) vorhanden
        // Error nicht vorhanden: Exception wird vorher ausgelöst
        // Failure: nein
        int res = FaultOne.numZero(null);
        // we never reach this line
    }

    @Test
    public void zeroAtEnd() {
        // Fault (Bug) vorhanden
        // Error vorhanden: i startet bei 1, nicht bei 0
        // Failure: nein (weil Resultat trotzdem stimmt)
        int res = FaultOne.numZero(new int[] {1, 2, 3, 0});
        Assert.assertEquals(1, res);
    }

    @Test
    public void zeroAtStart() {
        // Fault (Bug) vorhanden
        // Error vorhanden: i startet bei 1, nicht bei 0
        // Failure: ja (weil Resultat falsch)
        int res = FaultOne.numZero(new int[] {0, 1, 2, 3});
        Assert.assertEquals(1, res);
    }
}
