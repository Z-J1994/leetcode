package medium;

public class Solution792 {
    public int numMatchingSubseq(String s, String[] words) {
        int[] alphabet = new int[26];
        for (int i = 0, l = s.length(); i < l; i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        int[][] list = new int[26][];
        for (int i = 0; i < 26; i++) {
            list[i] = new int[alphabet[i]];
            alphabet[i] = 0;
        }
        for (int i = 0, l = s.length(), k; i < l; i++) {
            k = s.charAt(i) - 'a';
            list[k][alphabet[k]++] = i;
        }

        int count = 0;
        for (String word : words) {
            int j = 0;
            int[] indexes = new int[26];
            for (int l = word.length(), t = -1, k; j < l; j++, indexes[k]++) {
                k = word.charAt(j) - 'a';
                int[] temp = list[k];
                indexes[k] = upperbound(temp,indexes[k],t);
                if (indexes[k] >= temp.length) {
                    break;
                }
                t = temp[indexes[k]];
            }
            if (j == word.length()) {
                count++;
            }
        }
        return count;
    }

    private int upperbound(int[] data, int lo, int target) {
        int hi = data.length, mid;
        while (lo < hi) {
            mid = (lo + hi) >>> 1;
            if (data[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Solution792 s = new Solution792();
        System.out.println(s.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
        System.out.println(s.numMatchingSubseq("ricogwqznwxxcpueelcobbbkuvxxrvgyehsudccpsnuxpcqobtvwkuvsubiidjtccoqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoiundjscnlhbrhookmioxqighkxfugpeekgtdofwzemelpyjsdeeppapjoliqlhbrbghqjezzaxuwyrbczodtrhsvnaxhcjiyiphbglyolnswlvtlbmkrsurrcsgdzutwgjofowhryrubnxkahocqjzwwagqidjhwbunvlchojtbvnzdzqpvrazfcxtvhkruvuturdicnucvndigovkzrqiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqnhrewhagldzhryzdmmrwnxhaqfezeeabuacyswollycgiowuuudrgzmwnxaezuqlsfvchjfloczlwbefksxsbanrektvibbwxnokzkhndmdhweyeycamjeplecewpnpbshhidnzwopdjuwbecarkgapyjfgmanuavzrxricbgagblomyseyvoeurekqjyljosvbneofjzxtaizjypbcxnbfeibrfjwyjqrisuybfxpvqywqjdlyznmojdhbeomyjqptltpugzceyzenflfnhrptuugyfsghluythksqhmxlmggtcbdddeoincygycdpehteiugqbptyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjckmaptilrbfpjxiarmwalhbdjiwbaknvcqovwcqiekzfskpbhgxpyomekqvzpqyirelpadooxjhsyxjkfqavbaoqqvvknqryhotjritrkvdveyapjfsfzenfpuazdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzqfgqwhgobwyhxltligahroyshfndydvffd", new String[]{"iowuuudrgzmw"}));
    }
}
