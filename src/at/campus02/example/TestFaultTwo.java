package at.campus02.example;

import org.junit.Assert;
import org.junit.Test;

public class TestFaultTwo {
    // (a) Identify the fault.
    // for (int i = x.length - 1; i > 0; i--)
    // should be
    // for (int i = x.length - 1; i >= 0; i--) {

    // (b) If possible, identify a test case that does not execute the fault.
    @Test(expected = NullPointerException.class)
    public void expectException() {
        // Fault (Bug) vorhanden
        // Error: nein (wird nicht ausgeführt)
        // Failure: nein (Exception wie erwartet)
        int pos = FaultTwo.findLast(null, 2);
    }

    // (c) If possible, identify a test case that executes the fault, but does not
    //     result in an error state.
    @Test
    public void correctDespiteBug() {
        // Fault (Bug) vorhanden
        // Error: nein (wird ausgeführt, aber i immer richtig)
        // Failure: nein
        int pos = FaultTwo.findLast(new int[] {2, 3, 5, 8}, 5);
        Assert.assertEquals(2, pos);
    }

    // (d) If possible identify a test case that results in an error,
    // but not a failure.
    @Test
    public void errorButNoFailure() {
        // Fault (Bug) vorhanden
        // Error: ja (i ist nie 0)
        // Failure: nein
        int pos = FaultTwo.findLast(new int[] {2, 3, 5, 8}, 11);
        Assert.assertEquals(-1, pos);
    }

    @Test
    public void failure() {
        // Fault (Bug) vorhanden
        // Error: ja (i ist nie 0)
        // Failure: ja (falsches Ergebnis retourniert)
        int pos = FaultTwo.findLast(new int[] {2, 3, 5, 8}, 2);
        Assert.assertEquals(0, pos);
    }
}
