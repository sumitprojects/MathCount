package com.company;

public class Subtraction implements Operation {
    @Override
    public Long eval (Long x, Long y) {
        int add = 0;
        if(x < 0 && y < 0){
            return 0l;
        }else{
            if(x < y){
                long temp = x;
                x = y;
                y = temp;
                return x - y;
            }else {
                return x - y;
            }
        }
    }
    
    @Override
    public String operator () {
        return "-";
    }
}
