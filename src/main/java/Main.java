import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Object[]> list = null;
        try {
            session.beginTransaction();
            //Группируем имя клиента и имя продукта и выводи где количесва продукта
            Query<Object[]> query = session.createSQLQuery("select cl.name as name, pr.name as product, count(pr.name) as count\n" +
                    "from client cl\n" +
                    "         inner join booking bk on cl.id = bk.ID_Client\n" +
                    "         inner join product pr\n" +
                    "                    on pr.id = bk.ID_Product\n" +
                    "group by pr.name, cl.name");
            list = query.list();

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        } finally {
            session.close();
            sessionFactory.close();
        }

        list.forEach(p -> System.out.println("Name: " + p[0] + " product: " + p[1] + " count: " + p[2]));
    }
}

