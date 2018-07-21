package com.company;

public class Multiplication implements Operation {
    @Override
    public Long eval (Long x, Long y) {
        long r = x * y;
    
        if (r <= x || r <= y) {
            return 0l;
        } else {
            return r;
        }
    }
    
    @Override
    public String operator () {
        return "*";
    }
}
