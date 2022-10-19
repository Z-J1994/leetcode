package easy;

/**
 * @author zhangjun
 * @version 2022/10/19
 */
public class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int c = students.length;
        for(int i = 0,j = 0,t;i < sandwiches.length;i++,c--){
            if(sandwiches[i] != students[j]){
                for(t = (j + 1) % students.length; t != j && sandwiches[i] != students[t];t = (t + 1)% students.length);
                if(t == j){
                    break;
                }
                students[t] = -1;
                j = (t + 1) % students.length;
            }else{
                students[j] = -1;
                j = (j + 1) % students.length;
            }
        }
        return c;
    }
}
