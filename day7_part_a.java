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
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i==0){
                        if(grid.get(i)[j]=='S')grid.get(i+1)[j]='|';
                        else continue;
                    }
                    else{
                        if(grid.get(i)[j]=='^'){
                            if(grid.get(i-1)[j]=='|'){
                                ct++;
                                grid.get(i)[j-1]='|';
                                grid.get(i)[j+1]='|';
                            }
                        }
                        else {
                            if(grid.get(i)[j]=='|')continue;
                            if(grid.get(i-1)[j]!='^'&&grid.get(i-1)[j]!='S')grid.get(i)[j]=grid.get(i-1)[j];
                        }
                    }
                }
            }
            System.out.println(ct);
            }
        }
    }
