JFall 2012 - Datomic
====================

This project is a proposal for a session for NLJUG's 
[JFall 2012][1]. The proposal was accepted and I will presenting on
[Datomic][4] in an early bird session.

The [proposal][2] as sent with the call for paper app can be found on
GitHub. Want to see where I am working on? See the [Trello Board][3].

Obtaining Datomic
-----------------

There a two editions of [Datomic][4], a free edition and a pro edition. The
difference between the editions can be found on the [Datomic
website][5]. The presentation will use the [free edition][6].

Instead of following these instructions and performing the commands
you can perfom them automatically by invoking

    curl -L https://raw.github.com/dvberkel/jfall2012-datomic/master/lib/installer.sh | bash

See [installer.sh][12] for the details.

### Downloading

Datomic Free can be obtained from the [download page][6]. By
downloading Datomic Free you indicate to accept the 
[Datomic Free Edition License][7].

The following code will download `dataomic-free-0.8.3551.zip` to the
`lib` directory.

    wget -P lib http://downloads.datomic.com/0.8.3551/datomic-free-0.8.3551.zip

For an a complete list of possible downloads see [Datomic Free][8]

### Unpacking

    unzip -d lib lib/datomic-free-0.8.3551.zip

uncompresses the downloaded library. Examine the 
[directory listing][9] if you want to know what will get unpacked.

### Checking

If all went well the following command should start the datomic shell.

    cd lib/datomic-free-0.8.3551/; bin/shell

It should greet you with the following message.

    Datomic Java Shell
    Type Shell.help(); for help.
    datomic % 

With this shell you could follow along with the [getting started][10]
section of the Datomic documentation.

### Installing in maven repository

The code examples in this project use [Apache Maven][15] as a project
managment tool. In order to use Datomic with maven the Datomic library
needs to be installed into the maven repository.

The following command install the free 0.8.3551 version into the
repository

    mvn install:install-file -DgroupId=com.datomic -DartifactId=datomic-free -Dfile=lib/datomic-free-0.8.3551/datomic-free-0.8.3551.jar -DpomFile=lib/datomic-free-0.8.3551/pom.xml

and should produce the following [directory listing][11].

What to do next?
----------------

I would advice you to look into the following projects

1. [exploratory-tdd][13] is a project that explores the Datomic's
   library API via [TDD][14].

[1]: http://www.nljug.org/jfall/ "JFall homepage"
[2]: https://github.com/dvberkel/jfall2012-datomic/blob/master/proposal.md "The proposal for this talk on GitHub"
[3]: https://trello.com/board/jfall-2012-datomic/4ff6d141731da3d517067900 "Trello board for the JFall 2012 Datomic Session Proposal."
[4]: http://www.datomic.com/ "Homepage for Datomic""
[5]: http://www.datomic.com/pricing.html "Editions and Pricing documentation for Datomic"
[6]: http://downloads.datomic.com/free.html "Datomic free download page"
[7]: http://www.datomic.com/datomic-free-edition-license.html "Details of the Datomic Free Edition License"
[8]: http://downloads.datomic.com/free.html "Datomic Free download page"
[9]: https://github.com/dvberkel/jfall2012-datomic/blob/master/datomic-free.md "directory listing for datomic-free-0.8.3551.zip"
[10]: http://docs.datomic.com/getting-started.html "Getting Started guide for Datomic"
[11]: https://github.com/dvberkel/jfall2012-datomic/blob/master/datomic-repository.md "directory listing for datomic maven repository"
[12]: https://github.com/dvberkel/jfall2012-datomic/blob/master/lib/installer.sh "Install script for Datomic"
[13]: https://github.com/dvberkel/jfall2012-datomic/tree/master/exploratory-tdd "Exploring Datomic via TDD"
[14]: http://en.wikipedia.org/wiki/Test-driven_development "Wikipedia on Test Driven Development"
[15]: http://maven.apache.org/ "Apache Maven homepage"

