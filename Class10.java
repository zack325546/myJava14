import java.io.*;
public class Class10{
   public static void main(String args[]) throws IOException{
      FileWriter fw=new FileWriter("c:\\java\\rand.txt");
      FileWriter fw2=new FileWriter("c:\\java\\rand2.txt");
      FileReader fr=new FileReader("c:\\java\\rand.txt");
      BufferedWriter bfw=new BufferedWriter(fw);
      BufferedWriter bfw2=new BufferedWriter(fw2);
      BufferedReader bfr=new BufferedReader(fr);
      String str;
      int i,max,min,arr[]=new int[1000];
      long sum=0L;

     for(i=1;i<=1000;i++){
         Double num=new Double(Math.random()*100000);
         str=Integer.toString(num.intValue());
         bfw.write(str);
         bfw.newLine();
      }
      bfw.flush();
      fw.close();

      i=0;
      max=0;
      min=100000;
     while((str=bfr.readLine())!=null){
         arr[i]=Integer.parseInt(str);
         sum+=arr[i];
         if(max<arr[i])
            max=arr[i];
         if(min>arr[i])
            min=arr[i];
         i++;
      }
     System.out.println("Maximum="+max+",Minimum="+min);
     System.out.println("Average="+sum/1000);

     bubble_sort(arr);
     for(i=0;i<1000;i++){
         str=Integer.toString(arr[i]);
         bfw2.write(str);
         bfw2.newLine();
      }
      bfw2.flush();
      fw2.close();
   }

   public static void bubble_sort(int a[]){
      int i,j,temp;
      boolean flag=true;

     for(i=1;(i<a.length)&&(flag==true);i++){
         flag=false;             // 將flat設為flase
         for(j=0;j<(a.length-i);j++)
             if(a[j]>a[j+1]){
               temp=a[j];        // 對換陣列內的值
               a[j]=a[j+1];
               a[j+1]=temp;
               flag=true;        // 對調後將flag設為true
            }
      }
       return;
   }
}
