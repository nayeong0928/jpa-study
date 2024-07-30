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

            Member mem1=entityManager.find(Member.class, 101L);
            Member mem2=entityManager.find(Member.class, 101L);

            if(mem1==mem2){
                System.out.println("mem1과 mem2 같음: 영속 엔티티의 동일성 보장");
            }
            else {
                System.out.println("영속 엔티티의 동일성을 보장하지 않음");
            }
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        } finally{
            entityManager.close();
        }

        emf.close();
    }
}
