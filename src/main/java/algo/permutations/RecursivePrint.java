package algo.permutations;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecursivePrint {

    public static void main(String[] args) {
        RecursivePrint recursivePrint = new RecursivePrint();
        recursivePrint.permuteAndPrint("abc", 0, "abc".length() - 1);
    }

    private void permuteAndPrint(String str, int left, int right) {
        if (left == right) {
            log.info(str);
            return;
        }
        for (int i = left; i <= right; i++) {
            str = swap(str, left, i);
            permuteAndPrint(str, left + 1, right);
        }
    }

    private String swap(String str, int from, int to) {
        char[] strChars = str.toCharArray();
        char temp = strChars[from];
        strChars[from] = strChars[to];
        strChars[to] = temp;
        return String.valueOf(strChars);
    }
}
