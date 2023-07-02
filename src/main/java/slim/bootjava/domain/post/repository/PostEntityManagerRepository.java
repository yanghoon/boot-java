package slim.bootjava.domain.post.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import slim.bootjava.domain.post.entity.Post;
import slim.bootjava.domain.post.entity.PostSummary;

@Repository
public class PostEntityManagerRepository implements PostRepository {

    @PersistenceContext
    private EntityManager em;
    
    public List<Post> findAll() {
        return em.createNamedQuery(Post.FIND_ALL, Post.class).getResultList();
    }

    public List<Post> findAllWithUser() {
        return em.createNamedQuery(Post.FIND_ALL_WITH_USER, Post.class).getResultList();
    }

    @Override
    public Post findById(Long id) {
        TypedQuery<Post> query = em.createNamedQuery(Post.FIND_BY_ID, Post.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<PostSummary> findAllPostSummaries() {
        String jpql =
            "select new slim.bootjava.domain.post.entity.PostSummary(p.title, p.body, u.username, u.email) " +
            "  from Post p " +
            "left join p.user u ";
        return em.createQuery(jpql, PostSummary.class).getResultList();
    }
}
