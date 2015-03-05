  class A {
   
    String string; 
  
    public static void main(String[] args) {
      A a = args == null ? new A() : new B();
      a.setString();
      propagate(a);
    }  
     
    static void propagate(A a) {
      a.printString();
    }
    
    void setString() {
      string = secret();
    }
    
    void printString() {
      System.out.println("not secret");
    }
  }
  
  class B extends A {
    void setString() {
      string = "not secret";
    }
    
    void printString() {
      System.out.println(a);
    }
  }