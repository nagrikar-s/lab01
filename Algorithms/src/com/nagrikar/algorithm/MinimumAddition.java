package com.nagrikar.algorithm;

import javax.print.DocFlavor.STRING;

public class MinimumAddition {
    public int getAddition(String numberString, int target, int addition) {
        String prefix, sufix;
        int i, j;
        int[] totalAddition;
        if (Integer.valueOf(numberString) == target) {
            return 0;
        }
        if (Integer.valueOf(numberString) < target) {
            return Integer.MAX_VALUE;
        }
        for (i = 0; i < numberString.length(); i++) {
            for (j = 0; j < i; j++) {
                prefix[j] = numberString[i];
            }
            int prefixValue = Integer.valueOf(prefix);
            if (prefixValue > target) {
                break;
            } else {
                for (j = i; j < numberString.length(); j++) {
                    sufix[j] = numberString[i];
                }
                totalAddition[i] = getAddition(sufix, target - prefixValue, addition + 1);
            }
        }
    }

}
