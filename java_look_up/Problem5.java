/**
 * Created by sridharyadav on 9/21/17.
 */
//Input:  str1 = "anagram" , str2 = "grammar" , k = 3
//        Output:  Yes
//        Explanation: We can update maximum 3 values and
//        it can be done in changing only 'r' to 'n'
//        and 'm' to 'a' in str2.
//
//        Input:  str1 = "geeks", str2 = "eggkf", k = 1
//        Output:  No
//        Explanation: We can update or modify only 1
//        value but there is a need of modifying 2 characters.
//        i.e. g and f in str 2.
public class Problem5 {
    static boolean areKAnagrams(String str1, String str2,
                                int k)
    {
        // If both strings are not of equal
        // length then return false
        int n = str1.length();
        if (str2.length() != n)
            return false;

        int[] hash_str1 = new int[26];

        // Store the occurrence of all characters
        // in a hash_array
        for (int i = 0; i < n ; i++)
            hash_str1[str1.charAt(i)-'a']++;

        // Store the occurrence of all characters
        // in a hash_array
        int count = 0;
        for (int i = 0; i < n ; i++)
        {
            if (hash_str1[str2.charAt(i)-'a'] > 0)
                hash_str1[str2.charAt(i)-'a']--;
            else
                count++;

            if (count > k)
                return false;
        }

        // Return true if count is less than or
        // equal to k
        return true;
    }

    // Driver Method
    public static void main(String[] args) {
        String input1 = "geeks";
        String input2 = "eggkf";
        int k = 1;
        System.out.print(areKAnagrams(input1, input2, k));
    }
}
