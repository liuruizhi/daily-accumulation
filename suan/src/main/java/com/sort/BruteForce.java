package com.sort;

/**
 * @author liuruizhi
 * @since 2018/8/9
 */
public class BruteForce {
    public static void main(String[] args){
        String txt = "ABACCABCFT";
        String pat = "FT";
        int a = search(pat, txt);
        if (a == txt.length()){
            System.out.println("Not Found!");
        }else{
            System.out.println("Found: " + a);
        }
    }

    private static int search(String pat, String txt){
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i <= N - M; i++){
            int j;
            for (j = 0; j < M; j++){
                if (txt.charAt(i+j) != pat.charAt(j)){
                    break;
                }
            }
            if (j == M) return i;//Found
        }
        return N;//Not Found
    }

}
