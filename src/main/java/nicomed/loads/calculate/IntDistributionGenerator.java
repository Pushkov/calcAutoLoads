package nicomed.loads.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntDistributionGenerator implements IIntDistributionGenerate {
    int[] iArr;
    List<List<Integer>> varList = new ArrayList<>();

    @Override
    public List<List<Integer>> getIntegerRaspredList(int qty, int inRow) {
        iArr = new int[qty];
        currentIntVariant(qty, inRow, 0);
        return varList;
//        return getCompositions(qty);
    }

    private List<Integer> getShortedList(int[] array) {
        return Arrays.stream(array)
                .filter(value -> value != 0)
                .boxed()
                .collect(Collectors.toList());
    }

    public void currentIntVariant(int qty, int inRow, int i) {
        if (qty < 0) return;
        if (qty == 0) {
            varList.add(getShortedList(iArr));
        } else {
            if (qty >= inRow) {
                iArr[i] = inRow;
                currentIntVariant(qty - inRow, inRow, i + 1);
            }
            if (inRow > 1) currentIntVariant(qty, inRow - 1, i);
        }
    }

    /** ЕЩЕ НЕ РАЗБИРАЛ КАК РАБОТАЕТ, НО РАБОТАЕТ СРАЗУ С ПЕРЕМЕШИВАНИЕМ СЛАГАЕМЫХ **/
    private List<List<Integer>> getCompositions(int n) {
        List<List<Integer>> listOfCompositions = new ArrayList<>();
        List<Integer> composition = new ArrayList<>();
        composition.add(n);
        while (composition != null) {
            System.out.println(composition);
            listOfCompositions.add(composition);
            composition = getComposition(composition, n);
        }
        return listOfCompositions;
    }

    private static List<Integer> getComposition(List<Integer> previousComposition, int n) {
        List<Integer> currentComposition = new ArrayList<>(previousComposition);
        for (int i = currentComposition.size() - 1; i >= 0; i--) {
            if (currentComposition.get(i) != 1) {
                currentComposition.set(i, currentComposition.get(i) - 1);
                if (currentComposition.size() > i + 1) {
                    if (((currentComposition.size() - (i + 1)) > 1)) {
                        int sumOfOnes = 0;
                        for (int j = currentComposition.size() - 1; j >= i + 1; j--) {
                            sumOfOnes += currentComposition.get(j);
                            if (j != i + 1) currentComposition.remove(j);
                        }
                        currentComposition.set(i + 1, sumOfOnes + 1);
                    } else currentComposition.set(i + 1, currentComposition.get(i + 1) + 1);
                } else currentComposition.add(1);
                return currentComposition;
            }
        }
        return null;
    }


}
