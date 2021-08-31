package nicomed.loads.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntDistributionGenerator implements IIntDistributionGenerate {
    private int kol;
    private int inRow = 2;
    int[] variant;
    List<int[]> varList = new ArrayList<>();

    @Override
    public List<int[]> getIntegerRaspredList(int qty, int inRow) {
        return generate(qty, inRow);
    }

    private List<int[]> generate(int kol, int inRow) {
        int sum = 0;
        int m = inRow;
        int n = kol;
        variant = new int[n];
        boolean yes;

        do {
            sum = 0;
            for (int x : variant) {
                sum += x;
            }
            if (sum == n) {
//                System.out.println("sum " + sum);
//                for (int x:variant) System.out.print(" "+ x);           // Тестовая пропечатка массива
//                System.out.println("");                                 // Тестовая пропечатка массива
//                varList.add(Arrays.copyOf(variant,variant.length));
                varList.add(variant.clone());
            }
            int i = n - 1;
            while (i >= 0 && variant[i] == m) {
                variant[i] = 1;
                i--;
            }
            if (i >= 0) {
                variant[i]++;
                yes = true;
            } else {
                yes = false;
            }
        } while (yes);
//         System.out.println("Вариантов " + varList.size());
        return varList;
    }
}
