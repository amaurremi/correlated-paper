class Main {
  public static void main(String[] args) {
    String a = secret();
    String b = A.f(a);
  }

  static String secret() {
    return "secret";
  }
}

class A {  
  static String f(String s) {
    if (s == null) {
     String r = f("not secret");
     return r;    
    }
    return s;
  }
}