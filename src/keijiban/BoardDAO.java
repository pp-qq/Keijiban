package keijiban;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	// データベース接続と結果取得のための変数
	  private Connection con;
	  private PreparedStatement pstmt;
	  private ResultSet rs;

	  //全件取得用メソッド
	  public List<Board> selectAllBoard() {
	    // メソッドの結果として返すリスト
	    List<Board> results = new ArrayList<Board>();

	    try {
	      //ドライバを読み込み、DBに接続
	      this.getConnection();

	      // Statementオブジェクトの作成
	      pstmt = con.prepareStatement("select * from board");

	      //Select文実行
	      rs = pstmt.executeQuery();

	      // 6. 結果を表示する
	      while (rs.next()) {
	        // 1件ずつCountryオブジェクトを生成して結果を詰める
	        Board Board = new Board();
	        Board.setId(rs.getInt("id"));
	        Board.setName(rs.getString("name"));
	        Board.setContent(rs.getString("content"));

	        // リストに追加
	        results.add(Board);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    } finally {
	      this.close();
	    }

	    return results;
	    }

	//1件登録用メソッド
	  public void insertBoard(Board board) {

	    try {
	      //ドライバを読み込み、DBに接続
	      this.getConnection();

	      // Statementオブジェクトの作成
	      pstmt = con.prepareStatement("insert into board(name,content) values(?,?)");

	      pstmt.setString(1, board.getName());
	      pstmt.setString(2, board.getContent());



	      //Select文実行
	      pstmt.executeUpdate();



	    } catch (SQLException e) {
	      e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    } finally {
	      this.close();
	    }
	  }



	  public void getConnection() throws SQLException, ClassNotFoundException {
	    //ドライバクラス読込
	    Class.forName("com.mysql.jdbc.Driver");

	    // DBと接続
	    con = DriverManager.getConnection("jdbc:mysql://localhost/sample?useSSL=false&characterEncoding=utf8", "ユーザ", "パスワード");
	    // ※ユーザとパスワードはMySQLに設定済みのものを記載してください。
	  }

	  private void close() {
	    // 接続を閉じる
	    if (rs != null) {
	      try {
	        rs.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    if (pstmt != null) {
	      try {
	        pstmt.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    if (con != null) {
	      try {
	        con.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	  }


}
