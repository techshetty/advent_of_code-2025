public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long ct=0;
        ArrayList<char[]>grid=new ArrayList<>();
        int dir[][]={{-1,-1},{1,1},{-1,0},{1,0},{0,-1},{0,1},{-1,1},{1,-1}};
        try{
            while(true){
                char tmp[]=sc.nextLine().toCharArray();
                grid.add(tmp);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            int n=grid.size(),m=grid.get(0).length;
            System.out.println(n+" "+m);
            int tct=-1;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    tct=0;
                    if(grid.get(i)[j]!='@')continue;
                    for(int d[]:dir){
                        if(isV(i+d[0],j+d[1],grid)){if(tct==-1)tct=1;else tct++;}
                    }
                    if(tct<4&&tct!=-1){ ct++;}
                }
            }
            System.out.println(ct);
        }
    }
    public static boolean isV(int i,int j,ArrayList<char[]>grid){
        int m=grid.size(),n=grid.get(0).length;
        if(i<0||j<0||i>=m||j>=n)return false;
        return grid.get(i)[j]=='@';
    }
}
