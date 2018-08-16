package com.company;

import java.util.*;

public class Main {
    
    private static final Operation[] OPERATIONS = {new Addition(),
            new Subtraction(), new Multiplication(), new Division()};
    private ArrayList<String> solution = new ArrayList<>();
    
    public static void main (String[] args) {
        Long numbers[] = {5l, 4l, 3l, 2l};
        long total = 10;
        Main main = new Main();
  /*          if(main.findSolution(numbers,numbers.length,total)){
                System.out.println("The count is good");
                main.printSolution();
            }else{
                System.out.println("Solution not found");
            }
  */
        main.generateSolution(main.generateCombination(numbers, numbers.length));
        main.printSolution();
        //main.forloops(0,3,3,new char[]{'k','j','i'},1);
    }
    
/*    public boolean findSolution (long[] t, int nb, long total) {
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
    }*/
    
    List<Long> generateCombination (Long[] numbers, int length) {
        int i = 0, k = 0;
        Long ans = 0l;
        Combination c;
        length = (length % 2 == 0) ? length : length + 1;
        Map<Combination, String> map = new LinkedHashMap<>();
        List<Long> list = new ArrayList<>();
        do {
            k = 0;
            do {
                if (i == numbers.length - 1) {
                    c = new Combination(new Long[]{numbers[i]});
                    map.put(c, OPERATIONS[k].operator());
                } else {
                    
                    try {
                        ans = OPERATIONS[k].eval(numbers[i], numbers[i + 1]);
                        solution.add(Math.max(numbers[i], numbers[i + 1]) + " " +
                                OPERATIONS[k].operator() + " " +
                                Math.min(numbers[i], numbers[i + 1]) + " = " + ans);
                        c = new Combination(new Long[]{numbers[i], numbers[i + 1], ans});
                        map.put(c, OPERATIONS[k].operator());
                    } catch (Exception e) {
                        System.out.println("Msg: " + e);
                    }
                }
                k++;
            } while (k < OPERATIONS.length);
            i += 2;
        } while (i < length);
        
        Iterator trav = map.entrySet().iterator();
        while (trav.hasNext()) {
            Map.Entry record = (Map.Entry) trav.next();  //will give next (Key, Value) pair
            c = (Combination) record.getKey();
            //System.out.println(c.getN()[c.getN().length-1]+ "–>" + record.getValue());
            list.add(c.getN()[c.getN().length - 1]);
        }
        return list;
    }
    
    public void printSolution () {
       /* System.out.println(solution.size());
        for (int i = 0; i < solution.size(); i++) {
            System.out.print(solution.get(i) + "\t");
            if ((i + 1) % 4 == 0) System.out.println();
        }*/
        forloops(0, 4, 3, solution, 1);
    }
    
    void forloops (int low, int end, int loops, ArrayList<String> name, int inc) {
        int i = low, j = low + 4, l = low, e = end, k = end + 4, count = 0;
        while (count < 4) {
            while (i < 4) {
                while (j < 8) {
                    while (k < name.size()) {
                        System.out.println("--------------------------------------------");
                        System.out.println(name.get(i));
                        System.out.println(name.get(j));
                        System.out.println(name.get(k));
                        if(name.get(i).endsWith("10")){
                            System.out.println("answer in " + count + " counts");
                        }else if(name.get(j).endsWith("10")){
                            System.out.println("answer in " + count + " counts");
                        }else if(name.get(k).endsWith("10")){
                            System.out.println("answer in " + count + " counts");
                        }
                        System.out.println("--------------------------------------------");
                        k++;
                        if (k % 4 == 0) break;
                    }
                    j++;
                }i++;j = 4;
            }
            count++;
        }
    }
    
    
    public void generateSolution (List<Long> answer) {
        int i, j = 4, k, m = 0, size = answer.size();
        //Long ans = 0l;
        Long[] com = new Long[answer.size()];
        if (answer.size() / 4 > 2) {
            size = size - 4;
        }
        while (m < 4) {
            while (j < size) {
                i = 0;
                
                com[i] = answer.get(m);
                i++;
                for (k = j; k < answer.size(); k += 4) {
                    com[i] = answer.get(k);
                    i++;
                    //System.out.println(generateCombination(com, i));
                }
                /*System.out.print("[");
                for (int l = 0; l < i; l++) {
                    System.out.print(com[l] + " ");
                }
                System.out.println("]");
                */
                generateCombination(com, i);
                j++;
            }
            m++;
            j = 4;
        }
        System.out.println(answer);
        
    }
}
