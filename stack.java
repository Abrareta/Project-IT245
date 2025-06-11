public class stack {
    static final int Max = 1000;
    int top;
    int a[] = new int [Max];
    boolean isEmpty(){
        return (top < 0);
    }
    stack(){
        top = -1;
    }
    boolean push (int x){
        if (top >= (Max-1)){
            System.out.println("stack is overflow");
            return false;
        }
        else {
            a [++top]= x;
            System.out.println("pushed into stack");
            return true;
        }
    }

int pop(){
    if (top < 0){
        System.out.println("stack is underflow");
        return 0;
    }
    else {
        int x = a[top --];
        return x;
    }
}
int peek(){
    if (top <0){
        System.out.println("stack is underflow");
        return 0;
    }
    else{
        int x = a[top];
        return x;
    }
}
}
