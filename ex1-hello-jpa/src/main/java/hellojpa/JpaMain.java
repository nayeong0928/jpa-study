package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em=emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member member=new Member();
            member.setName("홍길동");
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.getReference(Member.class, member.getId());
            System.out.println("findMember.getClass() = " + findMember.getClass());
//            System.out.println("findMember.getName() = " + findMember.getName());

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally{
            em.close();
        }

        emf.close();
    }
}
