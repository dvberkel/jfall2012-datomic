Demonstration
=============

This file describes the demonstration script.

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

### Load Data

Afterwards the data can be loaded with

    uri = "datomic:free://localhost:4334/jfall";
    conn = Peer.connect(uri);
    data_rdr = new FileReader("samples/seattle/seattle-data0.dtm");
    data_tx = Util.readAll(data_rdr).get(0);

The database is now prepared and the demonstation can follow its
proper course.

[1]: http://docs.datomic.com/getting-started.html "Instructions for free storage protocol"
