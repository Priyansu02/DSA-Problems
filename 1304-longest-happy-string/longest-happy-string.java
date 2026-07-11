class Solution {
    public String longestDiverseString(int a, int b, int c) {
       StringBuilder ans = new StringBuilder();
        int curra=0,currb=0,currc=0;
        int total= a+b+c;

        for(int i=0; i< total;i++){
            if(a>= b && a>=c && curra != 2 || (a>0 && (currb==2 || currc==2))){
                ans.append('a');
                a--;
                curra++;
                currb=0;
                currc=0;
            }else if(b>=a && b>=c && currb!=2 || (b>0 &&(curra==2 || currc==2))) {
                ans.append('b');
                b--;
                currb++;
                curra=0;
                currc=0;
            } else if(c>=a && c>=b && currc!=2 || (c>0 &&(currb==2 || curra==2))) {
                ans.append('c');
                c--;
                currc++;
                currb=0;
                curra=0;
            }
        }
        return ans.toString();
    }
}