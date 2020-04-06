//import org.apache.derby.impl.sql.catalog.SYSROUTINEPERMSRowFactory;

//import javax.lang.model.element.VariableElement;
import java.sql.*;
import java.util.Scanner;

public class News1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection cx1 = null;
        try {
            cx1 = DriverManager.getConnection("jdbc:derby:testdb;create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Saisie d'un article (pour information).");
        try {
            PreparedStatement saisie1 = cx1.prepareStatement("insert into news(id_reporter, title, contain) values (1, 'Astronomie', 'Decouverte d une planete')");
            PreparedStatement saisie2 = cx1.prepareStatement("insert into reporter(name, credit) values ('Alex',4)");
            saisie1.execute();
            saisie2.execute();
            cx1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connection cx = null;
        try {
            cx = DriverManager.getConnection("jdbc:derby:testdb;create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Rentrez l'id du reporter : ");
        int repId = input.nextInt();
        try {
            PreparedStatement preparedStatement = cx.prepareStatement("SELECT NAME FROM REPORTER WHERE ID_REPORTER = ?");
            preparedStatement.setInt(1, repId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String rs = resultSet.getString("NAME");
                System.out.println("Le nom du reporter " + repId + " est : " + rs);
            }
            cx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connection cx2 = null;
        try {
            cx2 = DriverManager.getConnection("jdbc:derby:testdb;create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Rentrez l'identifiant du reporter qui a écrit l'article : ");
     //   String repReporter = input.nextLine();
        int repReporter = input.nextInt();
        try {
            PreparedStatement preparedStatement2 = cx2.prepareStatement("SELECT TITLE, CONTAIN FROM news WHERE ID_REPORTER = ?");
    //        preparedStatement2.setString(1, repReporter);
            preparedStatement2.setInt(1, repReporter);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            while (resultSet2.next() ) {
                String rs2 = resultSet2.getString("TITLE");
                String rs2b = resultSet2.getString("CONTAIN");
                System.out.println("Le titre de l'article écrit par " + repReporter + " est : " + rs2 + " et son contenu est : "+ rs2b);
            }
            cx2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
