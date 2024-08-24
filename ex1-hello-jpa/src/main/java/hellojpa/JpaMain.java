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

            Child child1=new Child();
            child1.setName("홍길동");
            Child child2=new Child();
            child2.setName("강감찬");

            Parent parent=new Parent();
            parent.setName("김유신");
            parent.addChildren(child1);
            parent.addChildren(child2);

            em.persist(parent);

            tx.commit();
        } catch (Exception e){

            e.printStackTrace();
        } finally{
            em.close();
        }

        emf.close();
    }
}
