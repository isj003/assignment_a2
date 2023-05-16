package configs;

import java.lang.reflect.Member;
import java.sql.*;



public class DBConn {
    public static void main(String[] args) throws SQLException {

        Connection conn = null;


        try {
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "SCOTT";
            String password = "tiger";

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결이 성공되었습니다.");

            //SEELCT 문
/*            String sql = "select * from EMP2 ";
           PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery(sql);

            while(rs.next()){
                int EMPNO = rs.getInt("EMPNO");
                String ENAME = rs.getString("ENAME");
                String JOB = rs.getString("JOB");
                String MGR = rs.getString("MGR");
                String HIREDATE = rs.getString("HIREDATE");
                String SAL = rs.getString("SAL");
                String COMM = rs.getString("COMM");
                int DEPTNO = rs.getInt("DEPTNO");
                System.out.println("EMPNO : " + EMPNO +" ENAME : " +ENAME +" JOB : "+ JOB +" MGR : "+ MGR +" HIREDATE : "+ HIREDATE +" SAL : "+ SAL +" COMM : "+ COMM +" DEPTNO : "+ DEPTNO);
            }*/

            // INSERT문
       /*     String sql = "INSERT INTO EMP2(EMPNO,ENAME,JOB) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "2");
            pstmt.setString(2, "회장");
            pstmt.setString(3, "CEO");

            pstmt.executeUpdate();
            */

            //update문 코드에는 문제없어 보이나 실행 안됨
            String sql = "update EMP2 set ENAME=?,JOB=? WHERE EMPNO=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"부회장");
            pstmt.setString(2,"사장");
            pstmt.setString(3,"2");
            System.out.println(pstmt+"값이 없나요?");
            pstmt.executeUpdate();





            //DELETE
/*            String sql = "DELETE FROM EMP2 WHERE EMPNO =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "2");

            pstmt.executeUpdate();*/




        } catch (SQLException ex) {
            System.out.println("데이터베이스 연결이 실패되었습니다.<br>");
            System.out.println("SQLException: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null)
                conn.close();
        }


}
}