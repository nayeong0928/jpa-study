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

            Member member=new Member();
            member.setName("홍길동");
            member.setRoleType(RoleType.USER);
            entityManager.persist(member);

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
