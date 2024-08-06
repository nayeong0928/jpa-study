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
            Team team=new Team();
            team.setName("개발팀");
            em.persist(team);

            Member member=new Member();
            member.setName("홍길동");
            member.setTeam(team);
//            team.getMembers().add(member);
            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("개발팀 멤버====");
            for(Member m: team.getMembers()){
                System.out.println("team member: "+m.getName());
            }

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally{
            em.close();
        }

        emf.close();
    }
}
