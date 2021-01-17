import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestJavaTable {
	@Test
	public void create() {
		JavaTable jt;
		try {
			jt = new JavaTable("Select * from Tested where SSN='12042018101'");
			jt.printResult();
			Assert.assertEquals("Failure-wrong name", jt.getValueAt(0, 2).toString(), "Lekatsas");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void size() {
		JavaTable jt;
		try {
			jt = new JavaTable();
			Assert.assertEquals("Failure - wrong number", jt.getColumnCount(), 8);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
