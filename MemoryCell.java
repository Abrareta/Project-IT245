public class MemoryCell {
    private Object storedvalue;
    public Object read(){
        return storedvalue;
    }
    public void write(Object x){
        storedvalue= x;
    }
}
