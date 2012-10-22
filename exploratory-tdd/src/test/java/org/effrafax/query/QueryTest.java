package org.effrafax.query;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datomic.Connection;
import datomic.Database;
import datomic.Entity;
import datomic.Peer;
import datomic.Util;

public class QueryTest {
	private static final String URI = "datamic:mem://exploratory-tdd-query";

	@BeforeClass
	public static void createDatabase() throws FileNotFoundException, InterruptedException, ExecutionException {
		Peer.createDatabase(URI);
		loadAddressSchema();
		loadAddressData();
	}

	@SuppressWarnings("rawtypes")
	private static void loadAddressSchema() throws FileNotFoundException, InterruptedException, ExecutionException {
		Reader schema_rdr = new FileReader("src/test/resources/address.schema.dtm");
		List schema_tx = (List) Util.readAll(schema_rdr).get(0);

		Connection conn = Peer.connect(URI);

		conn.transact(schema_tx).get();
	}

	@SuppressWarnings("rawtypes")
	private static void loadAddressData() throws FileNotFoundException, InterruptedException, ExecutionException {
		Reader data_rdr = new FileReader("src/test/resources/address.data.dtm");
		List data_tx = (List) Util.readAll(data_rdr).get(0);

		Connection conn = Peer.connect(URI);

		conn.transact(data_tx).get();
	}

	private Connection conn;

	@Before
	public void createConnection() {
		conn = Peer.connect(URI);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void queryForStreetsInGotham() {
		String query = "[:find ?s :where [?c :address/city \"Gotham\"][?c :address/street ?s]]";

		Collection results = Peer.q(query, conn.db());

		assertEquals(2, results.size());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void queryForAddressWithASuffix() {
		Database db = conn.db();
		String query = "[:find ?c :where [?c :address/suffix]]";
		Collection results = Peer.q(query, db);

		Object id = ((List)results.iterator().next()).get(0);
		Entity address = db.entity(id);

		assertEquals("Huge Mansion", address.get(":address/street"));
		assertEquals(3L, address.get(":address/number"));
		assertEquals("Ducktown", address.get(":address/city"));
	}

	@AfterClass
	public static void destroyDatabase() {
		Peer.deleteDatabase(URI);
	}
}
