package com.company;

import java.util.ArrayList;

public class Main {

    private static final Operation[] OPERATIONS = {new Addition(),
            new Subtraction(), new Multiplication(), new Division()};
    long ans[] = new long[2];
    private ArrayList<String> solution = new ArrayList<>();

    public static void main(String[] args) {
        long numbers[] = {4, 3, 2, 1};
        long total = 676;
        Main main = new Main();
/*            if(main.findSolution(numbers,numbers.length,total)){
                System.out.println("The count is good");
                main.printSolution();
            }else{
                System.out.println("Solution not found");
            }*/
        main.generateSolution(numbers, numbers.length, 0);
        main.printSolution();
    }

    public boolean findSolution(long[] t, int nb, long total) {
        for (int i = 0; i < nb; i++) {
            if (t[i] == total) {
                return true;
            }

            for (int j = i + 1; j < nb; j++) {
                for (int k = 0; k < OPERATIONS.length; k++) {
                    long res = OPERATIONS[k].eval(t[i], t[j]);

                    if (res != 0) {
                        long savei = t[i], savej = t[j];
                        t[i] = res;
                        t[j] = t[nb - 1];

                        if (findSolution(t, nb - 1, total)) {
                            solution.add(Math.max(savei, savej) + " " +
                                    OPERATIONS[k].operator() + " " +
                                    Math.min(savei, savej) + " = " + res);
                            return true;
                        }

                        t[i] = savei;
                        t[j] = savej;
                    }
                }
            }
        }

        return false;
    }

    public void generateSolution(long[] t, int nb, int low) {
        long res;
        int mid, j = 0;
        long temp = 0;
        try {
            nb = (nb % 2 == 0) ? nb : nb + 1;
            low = (low % 2 == 0) ? low : low - 1;
            mid = (nb + low) / 2;
            for (int k = 0; k < OPERATIONS.length; k++) {
                if (mid % 2 == 0) {
                    res = evaluate(t, mid - 1, low, OPERATIONS[k]);
                    t[--mid] = res;
                    if (mid < nb) {
                        try {
                            generateSolution(t, nb, mid);
                        } catch (Exception e) {
                            System.out.println("rec " + e);
                        }
                    }
                    evaluate(t, nb, mid, OPERATIONS[k]);
                    t[mid] = temp;
                } else if (mid > low) {
                    try {
                        generateSolution(t, mid, low);
                    } catch (Exception e) {
                        System.out.println("rec " + e);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ourec " + e);
        }
    }

    private long evaluate(long[] t, int nb, int mid, Operation op) {
        int i;
        long res = 0;
        for (i = mid; i < nb; i++) {
            res = op.eval(t[i], t[i + 1]);
            if (res != 0) {
                solution.add(Math.max(t[i], t[i + 1]) + " " +
                        op.operator() + " " +
                        Math.min(t[i], t[i + 1]) + " = " + res);
            } else {
                continue;
            }
        }
        return res;
    }

    public void printSolution() {
        for (int i = 0; i < solution.size(); i++) {
            System.out.println(solution.get(i));
        }
    }
}
