package hard;

/**
 * @author zhangjun
 * @version 2021/9/18
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {

        return dfs(s.toCharArray(),p.toCharArray(),0,0,new Boolean[s.length() + 1][p.length() + 1]);
    }

    private boolean dfs(char [] s,char [] p,int indexS,int indexP,Boolean [][] map){
        if(indexP == p.length){
            return indexS == s.length;
        }

        if(map[indexS][indexP] != null){
            return map[indexS][indexP];
        }

        //单个匹配
        boolean result = indexS < s.length && (s[indexS] == p[indexP] || p[indexP] == '.');

        //通配,匹配或者放弃匹配
        if(indexP + 1 < p.length && p[indexP + 1] == '*'){
            result = (result && dfs(s,p,indexS + 1,indexP,map)) || dfs(s,p,indexS,indexP + 2,map);
        }else{
            result = result && dfs(s,p,indexS + 1,indexP + 1,map);
        }
        map[indexS][indexP] = result;
        return result;
    }
}
