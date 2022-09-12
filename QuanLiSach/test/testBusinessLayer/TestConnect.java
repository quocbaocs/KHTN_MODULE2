package testBusinessLayer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import businessLayer.CSDL;
import businessLayer.QLCSDL;
import dataTransferObject.Sach;

public class TestConnect extends CSDL {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Test
	public void testConnection() {
		
		Connection conn = CSDL.connect();
		assertNotNull(conn);
	}
	@Test
	public void testThem() {
		Sach s = new Sach(null, null, null, 50000.0);
		QLCSDL dl = new QLCSDL();
		List<Sach> list = dl.dsSach("Online");
		assertTrue(list.size()==2);
	}

}
