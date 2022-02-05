import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Application {

    void printRatiosOfPositivesNegativesAndZeroes(List<Integer> listToOperate) {
        printer(formatListToNoMoreThan6Decimals(
                getRatiosOfPositivesNegativesAndZeroes(listToOperate)));
    }

    List<Double> getRatiosOfPositivesNegativesAndZeroes(List<Integer> listToOperate) {
        int sizeOfList = listToOperate.size();
        List<Integer> splitList = getSplitOfPositivesNegativesAndZeroes(listToOperate);
        List<Double> ratiosList = new ArrayList<>();
        for (int splitNumber: splitList) {
            ratiosList.add(calculateRatio(sizeOfList,splitNumber));
        }
        return ratiosList;
    }

    void printer(List<String> listToPrint) {
        for(String ratio: listToPrint) System.out.println(ratio + " ");
        System.out.println();
    }

    List<Integer> getSplitOfPositivesNegativesAndZeroes(List<Integer> listToOperate) {
        int sumOfPositives = 0, sumOfNegatives = 0, sumOfZeros = 0;
        for(int number:listToOperate){
            if (number == 0 ) sumOfZeros++;
            if (number > 0 ) sumOfPositives++;
            if (number < 0 ) sumOfNegatives++;
        }
        return new ArrayList<>(List.of(sumOfPositives,sumOfNegatives,sumOfZeros));
    }

    List<String> formatListToNoMoreThan6Decimals(List<Double> listToFormat) {
        DecimalFormat formatter = new DecimalFormat("#0.000000");

        List<String> formattedList = new ArrayList<>();
        for (double numberToFormat: listToFormat) {
            formattedList.add(formatter.format(numberToFormat));
        }
        return formattedList;
    }

    double calculateRatio(int total, int partial) {
        return (double) partial / (double) total;
    }




    public static void main(String[] args) {

        Application app = new Application();
        app.printRatiosOfPositivesNegativesAndZeroes(List.of(0,1,2,3,0,-1,-2,-3,0));
        app.printRatiosOfPositivesNegativesAndZeroes(List.of(1,2,3,-1));
    }
}
