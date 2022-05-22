# 객체지향 생활체조(Object Calisthenics) - The ThoughtWorks Anthology
***
## 1.한 메서드에 오직 한 단계의 들여쓰기만 한다.
```java
public class SomeObject {
    
    public String makeCSV() {
        StringBuilder stringBuilder = new StringBuilder();
        int raw = 10;
        int repeat = 5;
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                stringBuilder.append("some string");
                stringBuilder.append(", ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
        
    }
}
```

```java
public class SomeObject {

    public String makeCSV() {
        int raw = 10;
        int repeat = 5;
        StringBuilder stringBuilder = new StringBuilder();
        repeatNewLine(stringBuilder, 10, 5);
        return stringBuilder.toString();
    }

    private void repeatNewLine(StringBuilder stringBuilder, int raw, int repeat) {
        for (int i = 0; i < raw; i++) {
            repeatData(repeat);
            stringBuilder.append(", ");
        }
    }

    private void repeatData(StringBuilder stringBuilder, int repeat) {
        for(int i = 0; i < repeat; i++) {
            stringBuilder.append("some string");
            stringBuilder.append(", ");
        }
    }
}
```
***
## 2.else 예약어를 쓰지 않는다.
```java
public class SomeObject {
    public void login(String username, String password) {
        if (userRepository.isValid(username, password)) {
            redirect("homepage");
        } else {
            addFlash("error", "Bad credentials");

            redirect("login");
        }
    }
}
```
```java
public class SomeClass {
    public void login(String username, String password) {
        if (userRepository.isValid(username, password)) {
            redirect("homepage");
        } else {
            addFlash("error", "Bad credentials");

            redirect("login");
        }
    }
}
```
error 조건이 있다면 에러 케이스에 해당할 경우 조기 반환으로 메서드가 종료되고, 나머지 코드는 기본 로직을 따라가는 방법을 쓸 수 있다. 아니면 방어적 접근법을 적용할 수도 있다. 기본 로직를 조건으로 걸고, 조건에 만족하지 않는 경우 에러 상태를 리턴하는 방법이다.   
개발자가 미처 생각하지 못한 잠재적 에러를 예방하는 좋은 방법이 될 수 있다.
***
## 3. 모든 원시값과 문자열을 포장(wrap) 한다.
int 값 하나 자체는 아무 의미 없는 스칼라 값일 뿐이다. 어떤 메서드가 int 값을 매개변수로 받는다면 (int 값 자체는 아무 의미가 없기 때문에) 그 의도를 나타내는 메서드 이름과 매개변수 이름을 짓기 위해 노력해야 한다.  
시간이나 돈을 나타내는 원시 값들도 오브젝트로 만들면 프로그래머에게 그 값이 어떤 값이며 왜 쓰이고 있는지 정보를 전할 수 있다.  
***
## 4.한 줄에 점 하나만 사용
```java
class Location {
    public Piece current;
}

class Piece {
    public String representation;
}

class Board {
    public String boardRepresentation() {
        StringBuilder buf = new StringBuilder();

        for (Location loc : squares()) {
            // 주목!
            buf.append(loc.current.representation.substring(0, 1));
        }

        return buf.toString();
    }
}
```
```java
class Location {
    private Piece current;

    public void addTo(StringBuilder buf) {
        current.addTo(buf);
    }
}

class Piece {
    private String representation;

    public String character() {
        return representation.substring(0, 1);
    }

    public void addTo(StringBuilder buf) {
        buf.append(character());
    }
}
class Board {
    public String boardRepresentation() {
        StringBuilder buf = new StringBuilder();

        for (Location location : squares()) {
            location.addTo(buf);
        }

        return buf.toString();
    }
}
```
***
## 5. 줄여쓰지 않는다.
누구나 실은 클래스, 메서드, 또는 변수의 이름을 줄이려는 유혹에 곧잘 빠진다. 그런 유혹을 뿌리쳐라. 축약은 혼란을 야기하며, 더 큰 문제를 숨기는 경향이 있다. 
- 계속 반복해서 똑같은 단어를 치기 때문이면, 메서드가 너무 대대적으로 사용되고 있는지 확인하라.
- 메서드 이름이 길어지고 있기 때문이면 책임소재의 오류나 클래스의 부재라는 신호탄일지 모른다.
클래스와 메서드 이름을 한 두 단어로 유지하려 애쓰고 문맥을 중복하는 이름을 피하자.  
***
## 6. 일급 컬렉션 사용
콜렉션을 포함한 클래스는 반드시 다른 멤버 변수가 없어야 한다. 각 콜렉션은 그 자체로 포장 되어 있으므로 이제 콜렉션과 관련된 동작의 근거지가 마련된 셈이다.
***
## 7. 모든 엔티티를 작게 유지
50줄 이상 되는 클래스와 10개 파일 이상 되는 패키지는 없어야 한다. 보통 50줄 이상의 클래스는 한 가지 이상의 일을 하는 것이며 코드의 이해와 재사용을 점점 더 어렵게 끌고 간다. 클래스를 작게 작성할 때 난관은 같이 있어야 말이 되는 동작의 묶음이 종종 있는 경우이다.   
이는 패키지를 최대한 활용해야 하는 곳이기도 하다. 패키지도 클래스처럼 응집력 있고 단일한 목표가 있어야 한다. 패키지를 작게 유지함으로써 패키지 자체로 진정한 정체성을 지니기에 이른다.
***
## 8. 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
대부분의 클래스들이 하나의 상태 변수를 처리하는 일을 맡아야 마땅하지만, 몇몇 경우 둘이 필요할 때가 있다. 새로운 인스턴스 변수를 하나 더 기존 클래스에 추가하면 그 클래스의 응집도는 즉시 떨어진다. 많은 인스턴스를 가진 클래스로 응집력 있는 단일 작업을 하기란 어렵다.
## 9. 게터(Getter) / 세터(Setter) / 프로퍼티(Property) 를 사용하지 않는다.
**"말을 건네라. 묻지 말고"** 
객체의 상태를 가져오는 접근자(accessor)를 사용하는 것은 괜찮지만, 객체 바깥에서 그 결과값을 사용해 객체에 대한 결정을 내리는 것은 안된다. 한 객체의 상태에 대한 결정은 어떤 것이든 그 객체 안에서만 이루어져야 한다. 이 때문에 종종 getter/setter가 나쁜 것으로 여겨지곤 하는 것이다.  
다시 말하면 getter/setter 는 OCP 를 위반한다.