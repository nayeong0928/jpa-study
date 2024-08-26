package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("hello");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();

        try {

            Member member=new Member();
            member.setAge(30);
            member.setUsername("홍길동");
            em.persist(member);

            // 리턴 타입 명확
            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);

            // 리턴 타입 명확X
            Query query3 = em.createQuery("select m.username, m.age from Member m");

            // 여러 개 결과 조회
            List<Member> list = query1.getResultList();

            for(Member m: list){
                System.out.println("member: "+m.getUsername());
            }

            // 파라미터 바인딩
            Member singleResult = em.createQuery("select m from Member m where m.username=:username", Member.class)
                    .setParameter("username", "홍길동")
                    .getSingleResult();

            System.out.println("홍길동 멤버: "+singleResult.getId()+", "+singleResult.getAge());

            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
