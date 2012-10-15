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

[1]: http://www.nljug.org/jfall/ "JFall homepage"
[2]: https://github.com/dvberkel/jfall2012-datomic/blob/master/proposal.md "The proposal for this talk on GitHub"
[3]: https://trello.com/board/jfall-2012-datomic/4ff6d141731da3d517067900 "Trello board for the JFall 2012 Datomic Session Proposal."
[4]: http://www.datomic.com/ "Homepage for Datomic""
[5]: http://www.datomic.com/pricing.html "Editions and Pricing documentation for Datomic"
[6]: http://downloads.datomic.com/free.html "Datomic free download page"
[7]: http://www.datomic.com/datomic-free-edition-license.html "Details of the Datomic Free Edition License"
[8]: http://downloads.datomic.com/free.html "Datomic Free download page"
[9]: https://github.com/dvberkel/jfall2012-datomic/blob/master/datomic-free.md "directory listing for datomic-free-0.8.3551.zip"

