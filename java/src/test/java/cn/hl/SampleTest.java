package cn.hl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class SampleTest {

    @Test
    void testPlusOne() {
        int[] digits = { 9, 9, 9 };
        for (int i : plusOne(digits)) {
            System.out.println(i);
        }
        System.out.println("-----------------");
        for(int i : po(digits)) {
            System.out.println(i);
        }
    }

    private int[] po(int[] arr) {
        int flag = 1;
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i] + flag == 10){
                arr[i] = 0;
                flag = 1;
            }
            else{
                arr[i] = arr[i] + flag;
                flag = 0;
                break;
            }
        }
        if(flag == 1){
            int[] temp = new int[arr.length+1];
            temp[0] = 1;
            return temp;
        }
        return arr;
    }

    @Test
    void testLengthOfLongestSubstring() {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println("-----------------");
        System.out.println(ll(s));
    }

    private int ll(String s) {
        int count=0;
        Set<Character>set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }else{
                if(count<set.size()) {
                    count=set.size();
                }
                set.clear();
                set.add(c);
            }
        }
        if(count==0) {
            count=set.size();
        }
        return count;
    }

    private int[] plusOne(int[] digits) {
        int l = digits.length;
        for (int i = l - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[l + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    private int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }
}
