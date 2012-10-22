package org.effrafax.add;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
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

public class AddDatomsTest {
	private static final String URI = "datamic:mem://exploratory-tdd-add";

	@BeforeClass
	public static void createDatabase() throws FileNotFoundException, InterruptedException, ExecutionException {
		Peer.createDatabase(URI);
		loadAddressSchema();
	}

	private static void loadAddressSchema() throws FileNotFoundException, InterruptedException, ExecutionException {
		Reader schema_rdr = new FileReader("src/test/resources/address.schema.dtm");
		List schema_tx = (List) Util.readAll(schema_rdr).get(0);

		Connection conn = Peer.connect(URI);

		ATxReport txResult = (ATxReport) conn.transact(schema_tx).get();
	}

	private Connection conn;

	@Before
	public void createConnection() {
		conn = Peer.connect(URI);
	}

	@Test
	public void addAnAddressToTheDatabase() throws InterruptedException, ExecutionException {
		List add_address_tx = Util.list(Util.map(
			":db/id", Peer.tempid(":db.part/user"),
			":address/street", "Imaginary Boulevard",
			":address/number", 37,
			":address/suffix", "b",
			":address/city", "Cloud"
		));

		ATxReport txResult = (ATxReport) conn.transact(add_address_tx).get();
	}

	@Test
	public void addAnSubsetOfAllAddressAttributesToTheDatabase() throws InterruptedException, ExecutionException {
		List add_address_tx = Util.list(Util.map(
			":db/id", Peer.tempid(":db.part/user"),
			":address/street", "Imaginary Boulevard",
			":address/number", 51,
			":address/city", "Cloud"
		));

		ATxReport txResult = (ATxReport) conn.transact(add_address_tx).get();
	}

	@AfterClass
	public static void destroyDatabase() {
		Peer.deleteDatabase(URI);
	}
}
