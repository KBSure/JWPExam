package my.examples.guestbook.dao;

import my.examples.guestbook.servlet.Guestbook;

import java.sql.*;
import java.util.List;

public class GuestbookDao {
    private String url = "jdbc:mysql://localhost:3306/guestbook";
    private String id = "connect";
    private String password = "connect";
    List<Guestbook> getList(){
        Connection conn = DBUtil.connect(url, id, password);
        String sql = "select id, name, content, regdate from guestbook order by id desc;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                long id = rs.getLong(1);
                String name = rs.getString(2);
                String content = rs.getString(3);
                Timestamp timestamp = rs.getTimestamp(4);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    int addGuestbook(Guestbook){

        return 0;
    }
    int deleteGuestbook(Long id){

        return 0;
    }
}
