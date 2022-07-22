package GUI�ε����ͺ��̽�����ǥ���ϱ�;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//statement ��ü�� �����ϱ� ���ؼ��� connection�� ���� �����ؾ��Ѵ�.
class MyFrame extends JFrame {
	JTextField id, title, p, year, price, author;
	JButton previousButton, nextButton, InsertButton, deleteButton, searchButton;
	ResultSet rs;
	Statement stmt;
	
	public MyFrame() throws SQLException {
		super("Database Viewer");
		Connection con = makeConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM books"); //resultset�� ��ȯ insert, delete, update ����
		setLayout(new GridLayout(0, 2));
		add(new JLabel("ID", JLabel.CENTER));
		add(id = new JTextField());
		add(new JLabel("TITLE", JLabel.CENTER));
		add(title = new JTextField());
		add(new JLabel("PUBLISHER", JLabel.CENTER));
		add(p = new JTextField());
		add(new JLabel("YEAR", JLabel.CENTER));
		add(year = new JTextField());
		add(new JLabel("PRICE", JLabel.CENTER));
		add(price = new JTextField());
		add(new JLabel("���� �˻�", JLabel.CENTER));
		add(author = new JTextField());
		
		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.previous();
					id.setText("" + rs.getInt("book_id"));
					title.setText("" + rs.getString("title"));
					p.setText("" + rs.getString("publisher"));
					year.setText("" + rs.getString("year"));
					price.setText("" + rs.getInt("price"));
					} catch (SQLException e) {
					e.printStackTrace();
					}
			}
		});
		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		try {
			rs.next();
			id.setText("" + rs.getInt("book_id"));
			title.setText("" + rs.getString("title"));
			p.setText("" + rs.getString("publisher"));
			year.setText("" + rs.getString("year"));
			price.setText("" + rs.getInt("price"));
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		});
		add(nextButton);
		add(previousButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);		
	}
	
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/book_db?characterEncoding=UTF-8&serverTimezone=UTC";
		String id = "root";
		String password = "Bong0531";
		Connection con = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("����̹� ���� ����");
		con = DriverManager.getConnection(url, id, password);
		System.out.println("�����ͺ��̽� ���� ����");
		} catch (ClassNotFoundException e) {
		System.out.println("����̹��� ã�� �� �����ϴ�.");
		} catch (SQLException e) {
		System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
		return con;
	}
}

public class SQLSelectionTest{
	public static void main(String[] args) throws SQLException {
		new MyFrame();
	}
}

