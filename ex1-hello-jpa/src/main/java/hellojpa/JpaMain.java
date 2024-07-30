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
            // 비영속상태
            Member member=new Member();
            member.setId(101L);
            member.setName("홍길동");

            // 영속상태
            entityManager.persist(member);

            Member findMember=entityManager.find(Member.class, 101L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        } finally{
            entityManager.close();
        }

        emf.close();
    }
}
