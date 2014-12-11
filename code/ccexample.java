class A {
  String foo { return secret(); } /*@\label{line:Afoo}@*/
  void bar(String s) {} /*@\label{line:Abar}@*/
}
class B extends A {
  String foo { return "not secret"; } /*@\label{line:Bfoo}@*/
  void bar(String s) { System.out.println(s); } /*@\label{line:Bbar}@*/
}

class Main {
  public static void main(String[] args) {
    A a = (args == null) ? new A() : new B(); /*@\label{line:createObject}@*/
    String v = a.foo(); /*@\label{line:callfoo}@*/
    a.bar(v); /*@\label{line:callbar}@*/
  }
}