package hellojpa;

import hellojpa.embedded.Location;

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
            member.getLocations().add(new Location("addr", "street", "zipcode"));
            member.getLocations().add(new Location("addr2", "street", "zipcode"));
            em.persist(member);
            
            em.flush();
            em.clear();

            System.out.println("===== member 조회 ====");
            Member findMember = em.find(Member.class, member.getId());
            System.out.println("===== member의 location 조회 =====");
            findMember.getLocations().forEach(location -> {
                System.out.println("location: "+location.getAddr());
            });
            System.out.println("==============================");

            tx.commit();
        } catch (Exception e){

            e.printStackTrace();
        } finally{
            em.close();
        }

        emf.close();
    }
}
