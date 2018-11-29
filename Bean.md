Bean
=====
Container에 의해 관리되는 객체

ApplicatonContext
----
인터페이스.
구현한 클래스에 의해 생성될 수 있고,
xml 리소스를 읽어서 bean객체를 인스턴스화하는 기능이 있다.
scope = {싱글톤, prototype}에 따라서
메모리에 올리는 시점, 인스턴스 개수 제한 등이 달라진다.

다음 메서드를 가지고 있다.
1. getbean(); -> bean객체를 참조할 수 있다.
