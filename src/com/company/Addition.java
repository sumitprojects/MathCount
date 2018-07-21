package com.company;

public class Addition implements Operation {
    @Override
    public Long eval (Long x, Long y) {
        int add = 0;
        if(x < 0 && y <0){
            return 0l;
        }else{
            return x + y;
        }
    }
    
    @Override
    public String operator () {
        return "+";
    }
}
