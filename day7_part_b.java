import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<char[]>grid=new ArrayList<>();
        long ct=0;
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
            long dp[][]=new long[n+1][m+1];
            for(long d[]:dp)Arrays.fill(d,-1L);
            for(int i=0;i<m;i++){
                if(grid.get(0)[i]=='S'){ct+=helper(1,i,grid,n,m,dp);break;}
            }
            System.out.println(ct);
            }
        }
    public static long helper(int i,int j,ArrayList<char[]>grid,int n,int m,long dp[][]){
        // System.out.println(i+" "+j);
        if(i==n)return 1L;
        if(i<0||j<0||j>=m)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        long res=0;
        if(grid.get(i)[j]=='^'){
            res+=helper(i+2,j-1,grid,n,m,dp);
            res+=helper(i+2,j+1,grid,n,m,dp);
        }
        else res+=helper(i+1,j,grid,n,m,dp);
        return dp[i][j]=res;
    }
    }
