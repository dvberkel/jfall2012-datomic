package org.effrafax.connect;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datomic.Connection;
import datomic.Peer;

public class ConnectTest {
	private static final String URI = "datamic:mem://exploratory-tdd";

	@BeforeClass
	public static void createDatabase() {
		Peer.createDatabase(URI);
	}

	@Test
	public void shouldBeAbleToConnectToADatabase() {
		Connection conn = Peer.connect(URI);

		assertTrue(conn != null);
	}

	@AfterClass
	public static void destroyDatabase() {
		Peer.deleteDatabase(URI);
	}
}
