public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<long[]>rang=new ArrayList<>();
        int ct=0;
        try{
            while(true){
                String tmp[]=sc.nextLine().split("-");
                if(tmp.length==2){long l=Long.parseLong(tmp[0]),r=Long.parseLong(tmp[1]);
                rang.add(new long[]{l,r});}
                else{
                    if(tmp[0].length()==0)continue;
                    long cur=Long.parseLong(tmp[0]);
                    boolean f=false;
                    for(long r[]:rang){
                        if(cur>=r[0]&&cur<=r[1]){f=true;break;}
                    }
                    if(f)ct++;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println(ct);
        }
    }
}
