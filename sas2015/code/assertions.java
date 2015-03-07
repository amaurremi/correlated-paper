  public static void main(String[] args) {
    String n = "not secret";
    notSecret(n);  // assert that n is not secret
    String s1 = f(n);
    isSecret(s1);
    String s2 = f(secret());
  }

  static String f(String str) {
    isSecret(str);
    return str;
  }
  
  public static String secret() {  // the secret source
    return "secret";
  }