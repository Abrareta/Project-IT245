import java.util.List;
import java.util.ArrayList;

public class Generic {
    public static void main(String[] args){
        List<String> coffeeLst = new ArrayList<>();
coffeeLst.add("Espresso");
coffeeLst.add("Latte");
coffeeLst.add("Tea");
for(String coffee: coffeeLst)
System.out.println(coffee.toUpperCase());
}
    }

