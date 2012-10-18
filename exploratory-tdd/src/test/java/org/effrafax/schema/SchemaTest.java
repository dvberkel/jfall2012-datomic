package org.effrafax.schema;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datomic.Connection;
import datomic.Peer;
import datomic.Util;
import datomic.peer.ATxReport;

public class SchemaTest {
	private static final String URI = "datamic:mem://exploratory-tdd";

	@BeforeClass
	public static void createDatabase() {
		Peer.createDatabase(URI);
	}

	private Connection conn;

	@Before
	public void createConnection() {
		conn = Peer.connect(URI);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void shouldBeAbleToloadAmEmptySchema() throws FileNotFoundException, InterruptedException, ExecutionException {
		Reader schema_rdr = new FileReader("src/test/resources/empty.schema.dtm");
		List schema_tx = (List) Util.readAll(schema_rdr).get(0);

		ATxReport txResult = (ATxReport) conn.transact(schema_tx).get();

		List<String> names = new ArrayList<String>();
		for (Object key : txResult.keySet()) {
			names.add(Util.name(key));
		}

		assertTrue(names.contains("db-before"));
		assertTrue(names.contains("db-after"));
		assertTrue(names.contains("tempids"));
		assertTrue(names.contains("tx-data"));
	}

	@AfterClass
	public static void destroyDatabase() {
		Peer.deleteDatabase(URI);
	}
}
