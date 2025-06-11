
 class try2 <anytype>{
    private anytype value;
    // private anytype val2;
    public anytype getAnytype(){
return value;
    }  
    public void bring(anytype s){
value = s;
    }
 }


public class Boxing {
    public static void main(String[] args){
        try2 <String> obj = new try2<>();
        obj.bring("ss");
System.out.println(obj.getAnytype());  
  }
    
}
