class A {
  String foo {
    return secret();
  }
  
  void bar(String s) {}
}

class B extends A {
  String foo {
    return "not secret";
  }
  
  void bar(String s) {
    System.out.println(s);
  }
}

class Main {
  public static void main(String[] args) {
    A a = args == null ? new A() : new B();
    String v = a.foo();
    a.bar(v);
  }
}