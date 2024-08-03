package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em=emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try{
//            Member member1=new Member();
//            Member member2=new Member();
            Member member3=new Member();

//            member1.setName("홍길동");
//            member1.setRoleType(RoleType.USER);

//            member2.setName("길동무");
//            member2.setRoleType(RoleType.MANAGER);

            member3.setName("이영순");
            member3.setRoleType(RoleType.USER);

//            System.out.println("=persist() 시작=");
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("member1.getId() = " + member1.getId());
//            System.out.println("member2.getId() = " + member2.getId());
//            System.out.println("=persist() 끝");

//            member1, member2를 insert하고 나서 실행하기
            System.out.println("=persist(): member3 데이터 넣기");
            em.persist(member3);
            System.out.println("member3.getId() = " + member3.getId());
            System.out.println("=persist() 끝=");
//
            System.out.println("=commit() 시작=");
            transaction.commit();
            System.out.println("=commit() 끝=");

        } catch (Exception e){
            transaction.rollback();
        } finally{
            em.close();
        }

        emf.close();
    }
}
