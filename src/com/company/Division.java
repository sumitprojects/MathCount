package com.company;

public class Division implements Operation {
    @Override
    public Long eval (Long x, Long y) {
        if (x < y) {
            long t = x;
            x = y;
            y = t;
        }
        if (x % y == 0) {
            return x / y;
        } else {
            return 0l;
        }
    }
    
    @Override
    public String operator () {
        return "/";
    }
}
