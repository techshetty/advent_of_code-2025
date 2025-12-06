public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String[]>grid=new ArrayList<>();
        long ct=0;
        try{
            while(true){
                String tmp[]=sc.nextLine().trim().split("\\s+");
                grid.add(tmp);
                char sym=tmp[0].charAt(0);
                if(sym=='+'||sym=='*')break;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            int n=grid.size(),m=grid.get(0).length;
            for(int i=0;i<m;i++){
                char sym=grid.get(n-1)[i].charAt(0);
                // System.out.println(sym);
                long cs=(sym=='+')?0:1;
                if(sym=='+'){
                    for(int j=0;j<n-1;j++){cs+=Integer.parseInt(grid.get(j)[i]);}
                }
                else if(sym=='*'){
                    for(int j=0;j<n-1;j++){cs*=Integer.parseInt(grid.get(j)[i]);}
                }
                ct+=cs;
            }
            System.out.println(ct);
        }
    }
}
