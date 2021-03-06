# Legacy Code Refactoring

비디오 대여점에서 고객의 대여료 내역을 계산하고 출력하는 프로그램이 있다. 이 프로그램을 리팩토링해보자.

### 프로그램 설명
비디오 종류는 일반용, 어린이용, 최신용 세 종류이다.
이 프로그램은 고객이 대여한 비디오와 대여 기간을 표시한 후, 비디오 종류와 대여 기간을 토대로 대여료를 계산한다.
대여료 계산과 더불어 내역을 바탕으로 적립 포인트도 계산되는데, 이 포인트는 비디오가 최신물인지 아닌지에 따라 달라진다.

> 짧은 샘플이라 리팩토링이 과하다고 느낄 수 있지만 대규모 어플리케이션의 일부라고 가정해보자.
거기에 기능 추가가 빈번하게 일어난다면?
이 코드의 구조가 결코 좋은 구조가 아님을 알 수 있다.

기능 추가 예시 

1. 결과물을 html 버전으로도 보여주고 싶다.
2. 비디오의 종류가 추가된다. 이에 따라 계산 로직도 변경된다.

### 1. 견고한 Test Suite 작성

- 리팩토링시 기존 기능이 정상적으로 동작하는 것을 보장하는 테스트 셋을 작성 
- Test Coverage 체크

### 2. Statement 메서드 분해와 기능 재분배

Code Smell 파악하기

- 너무 긴 메소드
    - 메소드 추출, 동일한 레벨의 추상화 유지 - 임시 변수
    - 메서드 호출로 변경
    - 성능 이슈 존재하지만 다음을 고려할 것
        - 성능 vs 설계를 잘 따져볼 것
        - 기능 구현 후 성능 최적화 단계에서 성능을 개선하는 방법도 있음
- 과다한 책임
    - 메소드 책임분배 (Move Method)