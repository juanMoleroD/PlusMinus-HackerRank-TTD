import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    Application testApp = new Application();

    @Test
    void doesAppCountsPositives(){
        List<Integer> arrayWithOnly3PositiveNumbers = new ArrayList<>(List.of(1,2,3));
        assertEquals( List.of(3,0,0), testApp.getSplitOfPositivesNegativesAndZeroes(arrayWithOnly3PositiveNumbers));
    }

    @Test
    void doesAppCountsNegatives(){
        List<Integer> arrayWithOnly3NegativesNumbers = new ArrayList<>(List.of(-1,-2,-3));
        assertEquals( List.of(0,3,0), testApp.getSplitOfPositivesNegativesAndZeroes(arrayWithOnly3NegativesNumbers));
    }

    @Test
    void doesAppCountsZeroes(){
        List<Integer> arrayWithOnly3Zeroes = new ArrayList<>(List.of(0,0,0));
        assertEquals( List.of(0,0,3), testApp.getSplitOfPositivesNegativesAndZeroes(arrayWithOnly3Zeroes));
    }

    @Test
    void doesAppCountsPositivesNegatives(){
        List<Integer> arrayWithPositiveAndNegativeNumbers = new ArrayList<>(List.of(1,2,3,-1,-2,-3));
        assertEquals( List.of(3,3,0), testApp.getSplitOfPositivesNegativesAndZeroes(arrayWithPositiveAndNegativeNumbers));
    }

    @Test
    void doesAppCountsPositivesNegativesAndZeroes(){
        List<Integer> arrayWithPositiveNegativeAndZeroes = new ArrayList<>(List.of(0,1,2,3,0,-1,-2,-3,0));
        assertEquals( List.of(3,3,3), testApp.getSplitOfPositivesNegativesAndZeroes(arrayWithPositiveNegativeAndZeroes));
    }

    @Test
    void canAppCalculateOneRatio(){
        assertEquals(0.5, testApp.calculateRatio(10,5));
    }


    @Test
    void doesAppCalculateRatios(){
        List<Integer> arrayWithPositiveNegativeAndZeroes = new ArrayList<>(List.of(1,2,3,4,-1,-2,-3,-4,0,0));
        assertEquals(List.of(0.4,0.4,0.2), testApp.getRatiosOfPositivesNegativesAndZeroes(arrayWithPositiveNegativeAndZeroes));

    }

    @Test
    void doesAppCalculateSeveralDecimalRatios() {
        List<Integer> arrayWithPositiveNegativeAndZeroes = new ArrayList<>(List.of(0,1,2,3,0,-1,-2,-3,0));
        assertEquals(List.of(0.3333333333333333,0.3333333333333333,0.3333333333333333),
                testApp.getRatiosOfPositivesNegativesAndZeroes(arrayWithPositiveNegativeAndZeroes));
    }

    @Test
    void doesAppFormatsTo6DecimalPlaces() {
        List<Integer> arrayWithPositiveNegativeAndZeroes = new ArrayList<>(List.of(0,1,2,3,0,-1,-2,-3,0));
        assertEquals(List.of("0.333333","0.333333","0.333333"),
                testApp.formatListToNoMoreThan6Decimals(testApp.getRatiosOfPositivesNegativesAndZeroes(arrayWithPositiveNegativeAndZeroes)));
    }

    @Test
    void doesAppKeepFormatWithSmallerDecimals() {
        List<Integer> arrayWithPositiveNegativeAndZeroes = new ArrayList<>(List.of(1,2,3,-1));
        assertEquals(List.of("0.750000","0.250000","0.000000"),
                testApp.formatListToNoMoreThan6Decimals(testApp.getRatiosOfPositivesNegativesAndZeroes(arrayWithPositiveNegativeAndZeroes)));
    }

}