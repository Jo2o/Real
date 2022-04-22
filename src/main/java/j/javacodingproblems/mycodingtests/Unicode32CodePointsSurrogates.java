package j.javacodingproblems.mycodingtests;

import java.util.HashMap;
import java.util.Map;

public class Unicode32CodePointsSurrogates {

  public static void main(String[] args) {
      Map<String, Integer> result = new HashMap<>();
      String str = "abc Ӝ \uD83D\uDC95 \uD83C\uDFBC"; // str = "abc Ӝ 💕 🎼"
      for (int i = 0; i < str.length(); i++) {
          int codePoint = str.codePointAt(i);
          String ch = String.valueOf(Character.toChars(codePoint));
          if(Character.charCount(codePoint) == 2) { // 2 means a surrogate pair
              i++;
          }
          result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
      }
      System.out.println(result);
  }

}
