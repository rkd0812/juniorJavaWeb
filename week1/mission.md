# Java 기본 다지기

## 1. 테스트 코드 작성

## 2. 페어프로그래밍 연습
- 일련의 괄호를 사용하여 괄호의 순서가 유효한지 확인하는 함수를 작성하십시오. 함수는 문자열이 유효하면 true를 반환하고 유효하지 않으면 false를 반환해야 합니다.
```text
Example
"()"              =>  true
")(()))"          =>  false
"("               =>  false
"(())((()())())"  =>  true
```

```java
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SolutionTest {
    @Test
    public void sampleTest() {
        // assertEquals("expected", "actual");
        assertEquals(true,Solution.validParentheses( "()" ));
        assertEquals(false,Solution.validParentheses( "())" ));
        assertEquals(true,Solution.validParentheses( "32423(sgsdg)" ));
        assertEquals(false,Solution.validParentheses( "(dsgdsg))2432" ));
        assertEquals(true,Solution.validParentheses( "adasdasfa" ));
    }
}

```
## 3. 문자열 계산기
### 기능 요구 사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수있는 계산기를 구현한다.
- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- 문자열 계산기는 사칙연산의 계산 우선 순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 2 + 3 * 4 / 2 와 같은 문자열을 입력 할 경우 2 + 3 * 4 / 2 실행 결과 인 10을 출력 해야 한다.

#### 프로그래밍 요구 사항
- 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다. 테스트 할 수 있는 단위로 나누어 구현 목록을 만든다.
- 덧셈
- 뺄셈
- 곱셈
- 나눗셈
- 입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- 사칙연산이 모두 포함하는 기능 구현