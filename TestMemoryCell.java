public class TestMemoryCell {
    public static void main(String[] args){
        MemoryCell m = new MemoryCell();
        m.write("mmmm");
        // String val = (String) m.read();
        System.out.println("contents are: "+ m.read());

    }
}
