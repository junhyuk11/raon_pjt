## Spring JPA의 장점은?

JPA는 객체지향 프레임워크이기 때문에 비즈니스 로직이 RDBMS의 종류에 구애받지 않는다. 따라서 생산성 있는 작업이 가능하다.

- JPA의 변경 감지란?
    
    영속성 컨텍스트에 엔티티를 보관할 때 최초의 상태(스냅샷)를 저장한다. 트랜잭션이 끝나는 시점에 스냅샷과 달라진 부분을 비교하여 Update 쿼리를 날린다.
    
- 영속성 컨텍스트란?
    
    엔티티를 영구 저장하는 환경을 의미한다. 애플리케이션과 DB 사이에서 객체를 보관하는 가상의 데이터베이스 역할을 한다. 1차 캐시, lazy loading, 쓰기 지연, 변경 감지등의 기능을 제공한다.

## DB 트랜잭션이란?
> 데이터베이스의 상태를 변환시키기 위해 수행하는 작업의 논리적 단위

논리적인 작업을 모두 완벽하게 처리하면 DB에 반영하고 처리하지 못하면 원 상태로 Rollback 하여 Data anomaly 현상을 방지한다.

- 트랜잭션의 특성은? → ACID
    
    ### 원자성(Atomicity)
    
    만약 트랜잭션 중간에 어떠한 문제가 발생한다면 트랜잭션에 해당하는 어떠한 작업 내용도 수행되어서는 안되며 아무런 문제가 발생되지 않았을 경우에만 모든 작업이 수행되어야 한다.
    
    ### 일관성(Consistency)
    
    트랜잭션이 완료된 다음의 상태에서도 트랜잭션이 일어나기 전의 상황과 동일하게 데이터의 일관성을 보장해야 한다.
    
    ### 고립성(Isolation)
    
    각각의 트랜잭션은 서로 간섭없이 독립적으로 수행되어야 한다.
    
    ### 지속성(Durability)
    
    트랜잭션이 정상적으로 종료된 다음에는 영구적으로 데이터베이스에 작업의 결과가 저장되어야 한다.
    

>
- 트랜잭션과 Lock의 차이점이 무엇인가?
    
    Lock은 동시성을 제어하기 위한 기능이고, 트랜잭션은 데이터의 정합성을 보장하기 위한 기능이다.
    Lock의 경우 여러 주체에서 동시에 데이터에 접근할 경우 한 번에 하나의 주체만 접근을 허용한다.
    이와는 달리 트랜잭션의 경우 논리적인 작업 자체가 정상적으로 적용되거나 Rollback 되어 문제가 생긴데이터가 저장되는 것을 방지한다.
    