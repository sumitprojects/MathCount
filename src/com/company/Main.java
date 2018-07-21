package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    
    private static final Operation[] OPERATIONS = {new Addition(),
            new Subtraction(), new Multiplication(),new Division()};
    private ArrayList<String> solution = new ArrayList<>();

    public static void main (String[] args) {
        long numbers[] = {100,2,7,5,1,9};
        long total = 676;
        Main main = new Main();
            if(main.findSolution(numbers,numbers.length,total)){
                System.out.println("The count is good");
                main.printSolution();
            }else{
                System.out.println("Solution not found");
            }
    }
    
    public boolean findSolution (long[] t, int nb, long total) {
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
    
    public void printSolution () {
        for (int i = solution.size() - 1; i >= 0; i--) {
            System.out.println(solution.get(i));
        }
    }
}
