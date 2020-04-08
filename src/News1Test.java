import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class News1Test {
    @BeforeEach
    void setUp() {
        emFactory = Persistence.createEntityManagerFactory("derby-persistence-unit");
    }

    @Test
    void sessionOk() {
        Persistence.createEntityManagerFactory("derby-persistence-unit");
    }

    private EntityManagerFactory emFactory;
    {
        emFactory = Persistence.createEntityManagerFactory("derby-persistence-unit");
    }
    public EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }
    public void close(){
        emFactory.close();
    }

    @AfterEach
    void tearDown() {

    }
}
//class News1Test {
//
//    @org.junit.jupiter.api.Test
//    void main() {
//    }
//
//}