public class Main {
    static int dir[][]={{-1,-1},{1,1},{-1,0},{1,0},{0,-1},{0,1},{-1,1},{1,-1}};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long ct=0;
        ArrayList<char[]>grid=new ArrayList<>();
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
            int cnt[];
            do{
                grid=helper(grid,cnt=new int[]{-1});
                if(cnt[0]!=-1)ct+=cnt[0];
            }while(cnt[0]!=-1);
            System.out.println(ct);
        }
    }
    public static boolean isV(int i,int j,ArrayList<char[]>grid){
        int m=grid.size(),n=grid.get(0).length;
        if(i<0||j<0||i>=m||j>=n)return false;
        return grid.get(i)[j]=='@';
    }
    public static ArrayList<char[]> helper(ArrayList<char[]>grid,int cnt[]){
        int n=grid.size(),m=grid.get(0).length,ct=0;
        ArrayList<char[]>grid2=new ArrayList<>();
        for(char g[]:grid)grid2.add(g.clone());
        for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int tct=0;
                    if(grid.get(i)[j]!='@')continue;
                    for(int d[]:dir){
                        if(isV(i+d[0],j+d[1],grid)){tct++;}
                    }
                    if(tct<4){grid2.get(i)[j]='.';ct++;}
                }
            }
        if(ct!=0)cnt[0]=ct;
        return grid2;
    }
}
