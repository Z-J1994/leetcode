package easy;

/**
 * @author zhangjun
 * @version 2022/10/19
 */
public class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        for(int i = 0,j = -1,pl = students.length,l = 0;i < sandwiches.length;i++){
            while(students[++j] != sandwiches[i]){
                students[l++] = students[j];
                if(j + 1 == pl){
                    if(l == pl){
                        return l;
                    }
                    j = -1;
                    pl = l;
                    l = 0;
                }
            }
            if(j + 1 == pl){
                j = -1;
                pl = l;
                l = 0;
            }
        }
        return 0;
    }
}
