package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager=emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try{

            Member member1=new Member(102L, "홍길동");
            Member member2=new Member(103L, "임꺽정");

            entityManager.persist(member1);
            entityManager.persist(member2);
            // persist 이후 쿼리 X
            System.out.println("===================================");
            transaction.commit();
            // commit 이후 쿼리 생성
        } catch (Exception e){
            transaction.rollback();
        } finally{
            entityManager.close();
        }

        emf.close();
    }
}
