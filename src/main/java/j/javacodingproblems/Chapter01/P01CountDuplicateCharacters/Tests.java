package j.javacodingproblems.Chapter01.P01CountDuplicateCharacters;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tests {

  // Ӝ -> Unicode: \u04DC, Code Point: 1244
  // 💕 -> Unicode: \uD83D\uDC95, Code Point: 128149
  // 🎼 -> \uD83C\uDFBC, Code Point: 127932
  // 😍 ->\uD83D\uDE0D, Code Point: 128525

  public static void main(String[] args) {
    log.info("{}", "\u04DC".codePointCount(0, "\u04DC".length())); // 1 (Ӝ)
    log.info("{}", "\uD83C\uDFBC".codePointCount(0, "\uD83C\uDFBC".length())); // 1 (🎼)
    log.info("{}", "\uD83D\uDC95\u04DC".codePointCount(0, "\uD83D\uDC95\u04DC".length())); // 2 (💕Ӝ)
    log.info("{}", "\uD83D\uDC95\uD83D\uDE0D".codePointCount(0, "\uD83D\uDC95\uD83D\uDE0D".length())); // 2 (💕😍)

    log.info("{}", "\uD83D\uDC95".charAt(0)); // ?
    log.info("{}", "\uD83D\uDC95".codePointAt(0)); // 128149
    log.info("{}", "\uD83D\uDC95".codePointAt(1)); // 56469

    log.info("{}", Character.charCount("\u04DC".codePointAt(0))); // 1 (Ӝ)
    log.info("{}", Character.charCount("\uD83C\uDFBC".codePointAt(0))); // 2 (🎼)
    log.info("{}", Character.charCount("\uD83D\uDC95".codePointAt(0))); // 2 (💕)

    char[] doubleHeartCharArray = Character.toChars("\uD83D\uDC95".codePointAt(0)); // char array of idx-0: '\uD83D' 55357, idx-1: '\uDC95' 56469
    log.info("{}", doubleHeartCharArray); // [?, ?]
    System.out.println(doubleHeartCharArray); // 💕

    String doubleHeartString = String.valueOf(Character.toChars("\uD83D\uDC95".codePointAt(0)));
    log.info("{}", doubleHeartString); // "💕"

    log.info("----------------");
    "ahoj".codePoints().forEach(cp -> System.out.print(cp + " ")); // 97 104 111 106
  }

}
