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

            Team team=new Team();
            team.setName("개발1팀");
            em.persist(team);

            Member member=new Member();
            member.setName("강감찬");
            member.setTeam(team);
            em.persist(member);

            em.clear();

            Member m = em.find(Member.class, member.getId());
            System.out.println("멤버의 팀 타입: "+m.getTeam().getClass());

            System.out.println("=======멤버의 팀 조회할 때==========");
            m.getTeam().getName();
            System.out.println("=================================");

            tx.commit();
        } catch (Exception e){

            e.printStackTrace();
        } finally{
            em.close();
        }

        emf.close();
    }
}
