Exploritory TDD
===============

Test Driven Development ([TDD][1]) has many benefits. One of them is
exploring a third party library. It provides a means to determine how
the API is supposed to be used and builds up a set regression test
that can signal when a newer version of a API breaks the contract.

This project explores [Datomic][2] and its idiomatic usages.

Environment
-----------

We are using [Apache Maven][3] as a project management tool. It is
capable of creating project files for [Eclipse][4] by running the
goal

    mvn eclipse:eclipse

[1]: http://en.wikipedia.org/wiki/Test-driven_development "Wikipedia on Test Driven Development"
[2]: http://www.datomic.com/ "Homepage for Datomic"
[3]: http://maven.apache.org/ "Apache Maven homepage"
[4]: http://www.eclipse.org/ "The Eclipse homepage"

