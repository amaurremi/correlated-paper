  public static void main(String[] args) {
    String n = "not secret";
    notSecret(n);  // assert that n is not secret
    String s1 = f(n);
    isSecret(s1);  // in the next statement, f is invoked with a secret value
                   // hence, the argument of f will always be considered secret
                   // and f will always return a secret value
    String s2 = f(secret());
  }

  static String f(String str) {
    isSecret(str); // the function is once invoked with a secret value
                   // hence, assert that str is secret
    return str;
  }
  
  public static String secret() {  // the secret source
    return "secret";
  }