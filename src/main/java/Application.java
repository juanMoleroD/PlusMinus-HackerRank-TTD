import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Application {

    List<Double> getRatiosOfPositivesNegativesAndZeroes(List<Integer> listToOperate) {
        int sizeOfList = listToOperate.size();
        List<Integer> splitList = getSplitOfPositivesNegativesAndZeroes(listToOperate);
        List<Double> ratiosList = new ArrayList<Double>();
        for (int splitNumber: splitList) {
            ratiosList.add(calculateRatio(sizeOfList,splitNumber));
        }
        return ratiosList;
    }

    void printRatios(List<String> listToPrint) {
        for(String ratio: listToPrint) System.out.println(ratio + " ");
    }

    List<Integer> getSplitOfPositivesNegativesAndZeroes(List<Integer> listToOperate) {
        int sumOfPositives = 0, sumOfNegatives = 0, sumOfZeros = 0;
        for(int number:listToOperate){
            if (number == 0 ) sumOfZeros++;
            if (number > 0 ) sumOfPositives++;
            if (number < 0 ) sumOfNegatives++;
        }
        List<Integer> splitList = new ArrayList<>(List.of(sumOfPositives,sumOfNegatives,sumOfZeros));
        return splitList;
    }

    List<String> formatListToNoMoreThan6Decimals(List<Double> listToFormat) {
        DecimalFormat formatter = new DecimalFormat("#0.000000");

        List<String> formattedList = new ArrayList<>();
        for (double numberToFormat: listToFormat) {
            formattedList.add(formatter.format(numberToFormat).toString());
        }
        return formattedList;
    }

    double calculateRatio(int total, int partial) {
        double totalDouble = total, partialDouble = partial;
        double ratio = partialDouble / totalDouble;
        return ratio;
    }




    public static void main(String[] args) {

    }
}
