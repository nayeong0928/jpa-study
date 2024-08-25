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

            tx.commit();
        } catch (Exception e){

            e.printStackTrace();
        } finally{
            em.close();
        }

        emf.close();
    }
}
