import java.io.File;
public class readfiles{
    static String[] TYPES ={"jpg", "png", "gif", "mp4", "mp3", "exe", "psd", "html", "xml"};
    static int[] TYPESCOUNT = {0,0,0,0,0,0,0,0,0};
    static long[] TYPESIZE = {0,0,0,0,0,0,0,0,0};
    static File dirtolist = new File(".");//directory to work on
    
    static void storechildren(File parent)
    {
        
      File[] children = parent.listFiles();
     
      if(children != null)
      {
          
          System.out.println(children.length + " d " + parent);
       for(int j=0; j<children.length;j++)
           {
           if(dirtolist.isDirectory())
           {
               
          storechildren(children[j]);
            }
            else{
                System.out.print("0"+" f");
                System.out.println(children[j]);
               checktype(children[j].getPath());
            }
           }
       }
      
      else
      {
         System.out.print("0"+" f");
        System.out.println(parent) ;
                        System.out.println(parent.length()) ;
        checktype(parent.getPath());
      }
    }
    
    static void checktype(String file)
    {
        File sizecheck= new File(file);
         String dd="";
         int i = file.lastIndexOf(".");
             dd=file.substring(i);
             for(int j=0 ; j<TYPES.length;j++)
             {
                 if(dd==TYPES[j] || dd.toLowerCase() == TYPES[j])
                 {
                     TYPESCOUNT[j]=TYPESCOUNT[j]+1;
                     TYPESIZE[j]=TYPESIZE[j] + sizecheck.length();
                     break;
                 }
             }
             
         
       
    }
    
    public static void main(String arg[])
    {
    
        storechildren(dirtolist);
        System.out.println("Files by type and size");
        for (int i =0;i<TYPES.length;i++)
        {
            System.out.print(TYPES[i] + "-");
            System.out.print(TYPESCOUNT[i]);
            System.out.print(TYPESIZE[i]);
            System.out.println();
        }
       long time= System.currentTimeMillis();
       System.out.println("Program executed in " + time + " milliseconds");
    }
}
