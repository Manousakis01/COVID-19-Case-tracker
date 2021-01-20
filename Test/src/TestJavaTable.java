import java.sql.SQLException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class TestJavaTable {
	private String [] queries = {"SELECT * FROM Tested",//8 Column
			"SELECT * FROM Positive", //1 Column
			"SELECT * FROM Meth", //2
			"SELECT * FROM Death",//2
			"SELECT * FROM Healed",//2
			"SELECT * FROM Users"};//2
	@Test
	public void create() {
		JavaTable jt;
		try {
			jt = new JavaTable("Select * from Tested where SSN='12042018101'");
			jt.printResult();
			Assert.assertEquals("Failure-wrong name", jt.getValueAt(0, 2).toString(), "Haycroft");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void ColumnNumber() {
		JavaTable jt;
		try {
			jt = new JavaTable(queries[0]);
			Assert.assertEquals("Failure - wrong number", jt.getColumnCount(), 8);
			jt = new JavaTable(queries[1]);
			Assert.assertEquals("Failure - wrong number", jt.getColumnCount(), 1);
		for(int i=2; i<queries.length; i++) {

				jt = new JavaTable(queries[i]);
				Assert.assertEquals("Failure - wrong number", jt.getColumnCount(), 2);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
