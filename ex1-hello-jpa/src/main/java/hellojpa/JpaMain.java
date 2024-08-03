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
            Member member=new Member();
            member.setName("홍길동");
            member.setRoleType(RoleType.USER);

            System.out.println("=persist() 시작=");
            em.persist(member);
            System.out.println("member.getId() = " + member.getId());
            System.out.println("=persist() 끝=");

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
