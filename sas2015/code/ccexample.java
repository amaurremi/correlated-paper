class A {
  String foo { return secret(); } /*@\label{line:Afoo}@*/
  void bar(String s) {} /*@\label{line:Abar}@*/
}
class B extends A {
  String foo {
    return "not secret";
  } /*@\label{line:Bfoo}@*/
  void bar(String s) {
    System.out.println(s); 
  } /*@\label{line:Bbar}@*/
}

class Main {
  static void main(String[] args) {
    A a = (args == null) /*@\label{line:createObject}@*/
        ? new A() : new B(); 
    String v = a.foo(); /*@\label{line:callfoo}@*/
    a.bar(v); /*@\label{line:callbar}@*/
  }
}