Demonstration
=============

This file describes the demonstration script.

Utility
-------

The following is a utility function for clearing a number of lines

    void clear(int lines) {
    	 for (int index = 0; index < lines; index++) {
	     System.out.println();
	 }
    }

Preparation
-----------

Most of the preparation is done inside the Datomic library directory.

    cd ../lib/datomic-free-0.8.3551

### Start a transactor

Make sure that a [transactor with free storage protocol][1] is
running. Execute the following command to perform this.

    bin/transactor ../../presentation/src/main/resources/free.transactor.properties

### Create database

The database should be created once with the following commands in a
Datomic BeanShell. Start on by executing

    bin/shell

the proceed with the following commands

    uri = "datomic:free://localhost:4334/jfall";
    Peer.createDatabase(uri);

### Load Schema

The demonstrations uses the Datomic sample data. The data depends on a
scheme that must be loaded with the BeanShell by executing

    uri = "datomic:free://localhost:4334/jfall";
    conn = Peer.connect(uri);
    schema_rdr = new FileReader("samples/seattle/seattle-schema.dtm");
    schema_tx = Util.readAll(schema_rdr).get(0);
    txResult = conn.transact(schema_tx).get();

### Load Data

Afterwards the data can be loaded with

    uri = "datomic:free://localhost:4334/jfall";
    conn = Peer.connect(uri);
    data_rdr = new FileReader("samples/seattle/seattle-data0.dtm");
    data_tx = Util.readAll(data_rdr).get(0);
    txResult = conn.transact(data_tx).get();

The database is now prepared and the demonstation can follow its
proper course.

Demonstration Proper
--------------------

The following section should be demonstrated in one go and in order.

### Connecting

You first need a connection to the database. You connect with the
databse by requestion a connection from Peer.

    uri = "datomic:free://localhost:4334/jfall";
    conn = Peer.connect(uri);

### Snapshot of Database

For all operations we need a snapshot of the database. You can request
on from `conn`

    db = conn.db();

### Queries

All queries have a literal representation and return combination of
List and Maps. For example, the following query returns a list of all
entities that have a `:community/name`.

    results = Peer.q("[:find ?c :where [?c :community/name]]", db);

This returns a `Collection<List<Object>>`. The objects are id from
entities in the database. A database can convert an id into an entity
with the following method

     id = (results.iterator()).next().get(0);
     entity = db.entity(id);

An entity is basically an Map and can be used to retrieve values by
attribute.

    entity.get(":community/name");

If one is interested in an attribute instead of the entity one can
circumvent the creation of the entity and directly query for
attribute.

    results = Peer.q("[:find ?n :where [?c :community/name ?n]]", db);

This shows the power of Datalog, a Prolog derived to query over
datoms. Datalog is an declarative language that allows the
specification of what instead of how. It is logic based. it assumes
that the database is the universe of facts holds all the
truth. It can deduce new facts based on the known facts by using logic
rules.

For example, the following query returns a collection of names, url
pairs.

    results = Peer.q("[:find ?n, ?u :where [?c :community/name ?n][?c :community/url ?u]]",db);

Entities can have attributes that allow multiple values. For example
the `:community/category` can have multiple values. The following
queries shows that `belltown` is an example, for which there are
multiple values for `:community/category`.

    results = Peer.q("[:find ?e ?c :where [?e :community/name \"belltown\"][?e :community/category ?c]]",db);

The latest example is querying across multiple references

    result = Peer.q("[:find ?c_name :where [?c :community/name ?c_name][?c :community/neighborhood ?n][?n :neighborhood/district ?d][?d :district/region :region/ne]]",db);

[1]: http://docs.datomic.com/getting-started.html "Instructions for free storage protocol"
