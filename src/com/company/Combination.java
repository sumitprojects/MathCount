package com.company;

import java.util.Arrays;

public class Combination {
    private Long n[];
    
    public Long[] getN () {
        return n;
    }
    
    public void setN (Long[] n) {
        this.n = n;
    }
    
    public Combination (Long[] n) {
        this.n = n;
    }
    
    @Override
    public String toString () {
        return "Combination{" +
                "n=" + Arrays.toString(n) +
                '}';
    }
}
