package com.gainjavaknowledge.springBootGenericResponseExample;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringUtilsMethods {

    public static void main(String[] args) {
       //1. IsEmpty/IsBlank - checks if a String contains text
        String text1 = " ";
        System.out.println(StringUtils.isBlank(text1));//null, "", "   "
        System.out.println(StringUtils.isEmpty(text1));// null,""

        //2. Trim/Strip - removes leading and trailing whitespace
        String text2 = "   abc";
        String response1 = StringUtils.trim(text2);
        System.out.println("without trim:"+text2);
        System.out.println("trim:"+response1);

        //3. Equals/Compare - compares two strings in a null-safe manner
        String test4 = "myvalue1";
        String test5 = "myvalue";
        boolean res5 = test4.equals(test5);
        int i = test4.compareTo(test5);
        System.out.println("equals:"+res5+",compareTo:"+i);

        //4. startsWith - check if a String starts with a prefix in a null-safe manner
        String test6 = "myvalue";
        boolean res6 = test6.startsWith("my");
        System.out.println("startsWith:"+res6);

        //5. endsWith - check if a String ends with a suffix in a null-safe manner
        String test7 = "myvalue";
        boolean res7 = test7.endsWith("my");
        System.out.println("endsWith:"+res7);

        //6. IndexOf/LastIndexOf/Contains - null-safe index-of checks
        String test8 = "myvalue";
        int i2 = test8.indexOf('a'); //3
        int i3 = test8.lastIndexOf('a'); //3
        boolean res8 = test8.contains("a");  // true
        System.out.println("indexOf:"+i2);
        System.out.println("lastIndexOf:"+i3);
        System.out.println("contains:"+res8);

    //7. IndexOfAny/LastIndexOfAny/IndexOfAnyBut/LastIndexOfAnyBut - index-of any of a set of Strings
        String t7 = "mayvalaue";
        int index = StringUtils.indexOfAny(t7, 'a');  //1
        System.out.println("indexOfAny:"+index);

    //8. ContainsOnly/ContainsNone/ContainsAny - checks if String contains only/none/any of these characters
        String t8 = "man";
        boolean ContainsOnly = StringUtils.containsOnly(t8, 'a','m','n');
        System.out.println("ContainsOnly:"+ContainsOnly);
        boolean ContainsAny = StringUtils.containsAny(t8, 'c','b');
        System.out.println("ContainsAny:"+ContainsAny);
        boolean ContainsNone = StringUtils.containsNone(t8, 'd','o','p');
        System.out.println("ContainsNone:"+ContainsNone);


        //9. Substring/Left/Right/Mid - null-safe substring extractions
        String t9 = "man";
        String substring = StringUtils.substring(t9, 1);
        System.out.println("substring:"+substring);

        //10. SubstringBefore/SubstringAfter/SubstringBetween - substring extraction relative to other strings
        String t10 = "man";
        String SubstringBefore = StringUtils.substringBefore(t10, 0);
        System.out.println("SubstringBefore:"+SubstringBefore);

        //11. Split/Join - splits a String into an array of substrings and vice versa
        String t11 = "mandaty";
        String[] split = StringUtils.split(t11, 'a');
        System.out.println("split:"+ Arrays.toString(split)); //[m, nd, ty]

        String join = StringUtils.join(split, 'o');
        System.out.println("join:"+join);// mondoty

        //12. Remove/Delete - removes part of a String
        String rem = "www.gainjavaknowledge";
        String removeRes = StringUtils.remove(rem, "know");
        System.out.println("remove : "+removeRes);//www.gainjavaledge

        //13. Replace/Overlay - Searches a String and replaces one String with another
        String rep = "www.gainjavaknowledge";
        String responseRep = StringUtils.replace(rep, "ge","ge.com");
        System.out.println("replace : "+responseRep); //www.gainjavaknowledge.com

        //14. Chomp/Chop - removes the last part of a String
        String part = "www.gainjavaknowledge";
        String chop = StringUtils.chop(part);
        System.out.println("chop : "+chop); //www.gainjavaknowledg

        //15. AppendIfMissing - appends a suffix to the end of the String if not present
        String url = "www.gainjavaknowledge.com";
        String response = StringUtils.appendIfMissing(url, ".com");
        System.out.println("appendIfMissing result : "+response);//www.gainjavaknowledge.com

        //16. PrependIfMissing - prepends a prefix to the start of the String if not present
        String address = "gainjavaknowledge.com";
        String response2 = StringUtils.prependIfMissing(address, "www.");
        System.out.println("prependIfMissing result : "+response2);//ww.gainjavaknowledge.com

        //17. LeftPad/RightPad/Center/Repeat - pads a String
        String pad = "123";
        String response3 = StringUtils.repeat(pad, 3); //123123123
        String response4 =StringUtils.leftPad(pad, 7,'0');
        System.out.println("Repeat result : "+response3);
        System.out.println("Left pad : "+response4);//00000123






        //18. UpperCase/LowerCase/SwapCase/Capitalize/Uncapitalize - changes the case of a String
        String case1 = "Avleen";
        String response5 = StringUtils.upperCase(case1); //AVLEEN
        System.out.println("upperCase : "+response5);

        String response6 = StringUtils.capitalize(case1);//Avleen
        System.out.println("capitalize : "+response6);

        String response7 = StringUtils.swapCase(case1);
        System.out.println("swapCase : "+response7); //aVLEEN


        //19. CountMatches - counts the number of occurrences of one String in another
        String count = "Avleen";
        Integer response8 = StringUtils.countMatches(count,'e'); // case sensitive
        System.out.println("countMatches : "+response8);  //2

        //20. IsAlpha/IsNumeric/IsWhitespace/IsAsciiPrintable - checks the characters in a String
        String test = "78";
        boolean response9 = StringUtils.isNumeric(test);
        System.out.println("Is Numeric : "+response9);

        //21. DefaultString - protects against a null input String
        String test2 = "kk";
        String response10 = StringUtils.defaultString(test2);
        System.out.println("defaultString : "+response10);

        //22. Rotate - rotate (circular shift) a String
        String tes2 = "kdbbui";
        String resp1 = StringUtils.rotate(tes2, 2);
        System.out.println("rotate : "+resp1);//uikdbb

        //23. Reverse/ReverseDelimited - reverses a String
        String tes3 = "man";
        String resp2 = StringUtils.reverse(tes3);
        System.out.println("reverse : "+resp2);//nam

        //24. Abbreviate - abbreviates a string using ellipses or another given String
// If the number of characters in str is less than or equal to maxWidth, return str.
// Else abbreviate it to (substring(str, 0, max-3) + "...").
// If maxWidth is less than 4, throw an IllegalArgumentException.
// In no case will it return a String of length greater than maxWidth.
        String tes4 = "abcdrr";
        String resp4 = StringUtils.abbreviate(tes4, 4);
        System.out.println("abbreviate : "+resp4);//a...

        //25. Difference - compares Strings and reports on their differences
        String t1 = "kkubm";//m
        String t2 = "kkubnp";//n
        String diff = StringUtils.difference(t1, t2);  //n
        System.out.println("difference : "+diff);

        //26. LevenshteinDistance - the number of changes needed to change one String into another
        String t3 = "kkubm";
        String t4 = "kkubn";
        int LevenshteinDistance = StringUtils.getLevenshteinDistance(t3, t4);
        System.out.println("LevenshteinDistance : "+LevenshteinDistance);





    }
}
