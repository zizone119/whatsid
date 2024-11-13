import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SungjukInsert {
	public void SungjukInsert() {
		String name = "";
		int kuk, eng, mat, tot, avg;
		String etc = "";
		Scanner in = new Scanner(System.in);
		System.out.println("이름 입력:");
		name = in.nextLine();
		System.out.println("국어 점수:");
		kuk = in.nextInt();
		System.out.println("영어 점수:");
		eng = in.nextInt();
		System.out.println("수학 점수:");
		mat = in.nextInt();
		in.nextLine();
		System.out.println("기타:");
		etc = in.nextLine();
		Connection con = null;
		tot = kuk + eng + mat;
		avg = tot / 3;
		PreparedStatement pstmt = null;
		try {
			con = DBConnect.getConnection();
			String sql = "insert into sungjuk values (?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, kuk);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, mat);
			pstmt.setInt(5, tot);
			pstmt.setInt(6, avg);
			pstmt.setString(7, etc);
			int ret = pstmt.executeUpdate();
			if (ret < 1) {
				System.out.println("Insert failed");
			} else {
				System.out.println(ret + " data(s) inserted");
			}
		} catch (SQLException e) {
		} finally {
			DBConnect.close(con, pstmt);
		}
	}
}
