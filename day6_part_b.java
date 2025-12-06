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
            int l=0,h=-1;
            while(l<m){
                for(int x=l+1;x<m;x++){if(grid.get(n-1)[x]=='*'||grid.get(n-1)[x]=='+'||x==m-1){h=(x==m-1)?x:x-2;break;}}
                char sym=grid.get(n-1)[l];
                long cs=(sym=='+')?0:1;
                for(int j=h;j>=l;j--){
                    long num=0;
                    for(int k=0;k<n-1;k++){
                        num=(grid.get(k)[j]==' ')?num:num*10+(grid.get(k)[j]-'0');
                    }
                    if(sym=='*')cs*=num;else cs+=num;
                }
                ct+=cs;
                l=h+2;
                h=-1;
            }
            System.out.println(ct);
            }
        } 
    }
