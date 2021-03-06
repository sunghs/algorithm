package sunghs.algorithm.woowaBrothers;

/**
 * 어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었습니다.
 * 청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였습니다.
 * <p>
 * 엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록
 * solution 메서드를 완성해주세요.
 * <p>
 * A	B	C	D	E	F	G	H	I	J	K	L	M	N	O	P	Q	R	S	T	U	V	W	X	Y	Z
 * Z	Y	X	W	V	U	T	S	R	Q	P	O	N	M	L	K	J	I	H	G	F	E	D	C	B	A
 * 제한사항
 * word는 길이가 1 이상 1,000 이하인 문자열입니다.
 * 알파벳 외의 문자는 변환하지 않습니다.
 * 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환합니다.
 * 입출력 예
 * word	result
 * I love you	R olev blf
 * 입출력 예 설명
 * 입출력 예 #1
 * <p>
 * 'I'는 알파벳 대문자이므로 'R'로 변환할 수 있습니다.
 * 공백(스페이스 바)은 알파벳 외의 문자이므로 변환하지 않습니다.
 * 'l'은 알파벳 소문자이므로 'o'로 변환할 수 있습니다.
 * 'o'은 알파벳 소문자이므로 'l'로 변환할 수 있습니다.
 * 'v'은 알파벳 소문자이므로 'e'로 변환할 수 있습니다.
 * 'e'은 알파벳 소문자이므로 'v'로 변환할 수 있습니다.
 * 공백(스페이스 바)은 알파벳 외의 문자이므로 변환하지 않습니다.
 * 'y'은 알파벳 소문자이므로 'b'로 변환할 수 있습니다.
 * 'o'은 알파벳 소문자이므로 'l'로 변환할 수 있습니다.
 * 'u'은 알파벳 소문자이므로 'f'로 변환할 수 있습니다.
 */
public class Woowa2 {

    public static String solve(String word) {
        // A = 65, Z = 90
        // a = 97, z = 122

        // 원래문자 (A,B,C,D,E...Z) : 65,66,67,68,69....90
        // 반전문자 (Z,Y,X,W,V...A) : 90,89,88,87,86....65

        // 90 - 원래대문자 + 65 = 반전대문자
        // 122 - 원래소문자 + 97 = 반전소문자

        // 155 - 원래대문자 = 반전대문자
        // 219 - 원래소문자 = 반전소문자

        String result = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result += (char) (155 - c);
            } else if (c >= 'a' && c <= 'z') {
                result += (char) (219 - c);
            } else {
                // 대소문자가 아니면 그냥 더함
                result += String.valueOf(c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String result = Woowa2.solve("I love you");
        System.out.println(result);
    }
}
