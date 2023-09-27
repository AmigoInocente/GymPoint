package Main;

import Entities.Usuario;
import Enums.Funcao;
import Utils.JpaManager;
import io.github.cdimascio.dotenv.Dotenv;
import javax.persistence.EntityManager;

public class Main {

    public static Dotenv dotenv = Dotenv.load();
    
    public static void main(String[] args) {
        EntityManager m = JpaManager.getEntityManager();
        
        Usuario u = new Usuario("Gustavo", "gustavo@gmail.com", "123", Funcao.USUARIO);
        try {
            m.getTransaction().begin();
            m.persist(u);
            m.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Deu ruim...");
        }finally{
            m.close();
        }
    }
    
}
