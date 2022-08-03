package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution899 {
    public String orderlyQueue(String s, int k) {
        //k大于1直接按字典排序
        if (k == 1) {
            if (s.length() == 1) {
                return s;
            }
            char[] chars = s.toCharArray();
            List<Integer> list = new ArrayList<>();
            char minChar = 'z';
            //找出所有的最小字母的位置
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < minChar) {
                    minChar = chars[i];
                    list = new ArrayList<>();
                    list.add(i + 1);
                } else if (chars[i] == minChar) {
                    list.add(i + 1);
                }
            }
            int minIndex;
            //如果只有一个最小字母直接按照这个字母切割数组
            if (list.size() > 1) {
                int[] indexes = new int[list.size()];
                int g = 0;
                //存到数组中方便操作
                for (int i : list) {
                    indexes[g++] = i;
                }
                minIndex = 0x7fffffff;
                //每一轮过滤掉一部分下标,直到只剩一个下标或者字母全部相等
                for (int i = 0; i < s.length(); i++) {
                    int offset = 0;
                    //每次被淘汰的下标对应位置会被设置为-1,所以开始前需要找到不是-1的下标
                    while (offset < indexes.length && indexes[offset] == -1) {
                        offset++;
                    }
                    int m = indexes[offset]++ % s.length();
                    List<Integer> equals = new ArrayList<>();
                    equals.add(offset);
                    for (int j = offset + 1, t; j < indexes.length; j++) {
                        if (indexes[j] == -1) {
                            continue;
                        }
                        t = indexes[j]++ % s.length();
                        if (chars[t] < chars[m]) {
                            indexes[offset] = -1;
                            m = t;
                            offset = j;
                            for (int h : equals) {
                                indexes[h] = -1;
                            }
                            equals = new ArrayList<>();
                            equals.add(j);
                        } else if (chars[t] == chars[m]) {
                            equals.add(j);
                        } else {
                            indexes[j] = -1;
                        }
                    }
                    //找到唯一的数字
                    if (equals.size() == 1) {
                        minIndex = (list.get(offset) - 1 + s.length()) % s.length();
                        break;
                    }
                }
            } else {
                minIndex = (list.get(0) - 1 + s.length()) % s.length();
            }
            //如果未找到最小的字符串开始下标,则说明原字符串就是最小
            if(minIndex == 0x7fffffff){
                return s;
            }
            char[] result = new char[s.length()];
            System.arraycopy(chars, minIndex, result, 0, chars.length - minIndex);
            System.arraycopy(chars, 0, result, chars.length - minIndex, minIndex);
            return new String(result);
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        Solution899 s = new Solution899();
        System.out.println(s.orderlyQueue("cba", 1));
        System.out.println(s.orderlyQueue("baaca", 3));
        System.out.println(s.orderlyQueue("gtxlrjwkpzolcynsrgqcbvphnoradctlfjrloykccsicuxcqtgvrlegvesooadiqjgjmpojlupzphnmwtwsghewxiamusracsvevypoakmylaobzrssykhcamttaqvwukssbbiqjqtuhzoqqrerlzszzvppmjkxqeallbfijqevmbcyaqerzxllhlyamxcdvhuhavilbqvfyqofwlbyjhbabwwmcdyoubbudvylcslnxodjwncnawgszxnisoxgsdkujhjjadtsqddmmdzvwervizcudgedrguuyuzoaikzkhuxbzszqarfzywsgyvqefopkvrgapixgofzqtxlolqivjuajmxstqxsqxtawetkkelzvtqfbyxaxtceegxkolmgighpaynnkttszkcusamvyjmltsmepajibculdyilseuvmsszujnknxcxndyfamobqoocjdmjiwqcrzjurmkfkgmrxdvtqebdihviezsumcplicihjsdjtiwweqqeomgsxxcjcmrsbcqvpccpfthvxnstqqkxeesfnxjtwrcnuzlbjmybxlctddgorwpqmnrhhqqefoviebnnporwiufimntatuaoadwbxrtrttxjjqnrjkkbtoxtkubqyxihhxikigwlnkikxhsfxmhltwvdzmyeyfwhvewrdylevbatctcydoqjcmixffplhdvcxydyguilsotkbixuypimmgwbizoyavqwtzitvsuvhhkaxvdvipmlpxkawyuektwwyqdkydyjpvccmxzreujgplnzawlvwtmnpkswiyoheshvyjjhgzvwayvvykbonftzsuuveppwlgnmabemrnozcjouwqrxupakbzvicojsvpvaglmveonqabckptqcwkvejrqnyvprknqvflefadtihdokbjutzwmuukkolqvxqnfkfsodeacqqnuogtjbflpuwutpfrsgjhzsjfigvejngeyxanblcufhcznkoeuhw", 1));
        System.out.println(s.orderlyQueue("sjvcbjxtroukauekjdjeqqalowmcbwuwgqcviymaxqhajeodexqgwqymxrbghegfwmwdoayakuzavnaucpurjalxigdnnbkrzllmfkqkpvzxjapmgbiuzcwbsakwkyspeikpzhnyiqtqtfyephqhlrgsjdpelkbsruooeffnvjwtsidzwkwxinisxzthwzjynzzvreap", 1));
        System.out.println(s.orderlyQueue("aaaaa", 1));
        System.out.println(s.orderlyQueue("xitavoyjqiupzadbdyymyvuteolyeerecnuptghlzsynozeuuvteryojyokpufanyrqqmtgxhyycltlnusyeyyqygwupcaagtkuq", 1));
        System.out.println(s.orderlyQueue("aacaab", 1));
    }
}
