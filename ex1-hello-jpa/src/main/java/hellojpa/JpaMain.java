package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

            Team team=new Team();
            team.setName("개발팀");
            team.getMembers().add(member);
            em.persist(team);

            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally{
            em.close();
        }

        emf.close();
    }
}
