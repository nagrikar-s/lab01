package com.nagrikar.algorithm;

import javax.print.DocFlavor.STRING;

public class MinimumAddition {
    public int getAddition(String numberString, int target, int addition) {
        char[] prefix, sufix;
        int i, j;
        int[] totalAddition;
        if (Integer.valueOf(numberString) == target) {
            return 0;
        }
        if (Integer.valueOf(numberString) < target) {
            return Integer.MAX_VALUE;
        }
        prefix = new char[numberString.length()];
        for (i = 0; i < numberString.length(); i++) {
            for (j = 0; j < i; j++) {
                prefix[j] = numberString.charAt(i);
            }
            int prefixValue = Integer.valueOf(prefix[i]);
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
