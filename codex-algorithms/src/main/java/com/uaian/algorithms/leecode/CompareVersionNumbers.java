package com.uaian.algorithms.leecode;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int index = 0;
        while (index < split1.length || index < split2.length){
            int v1 = 0, v2 = 0;
            if(index < split1.length)
                v1 = Integer.valueOf(split1[index]);
            if(index < split2.length)
                v2 = Integer.valueOf(split2[index]);

            if(v1 > v2){
                return 1;
            } else if (v1 < v2) {
                return -1;
            }

            index++;
        }

        return 0;
    }
}
