Datomic Repository
==================

After installing Datomic into the maven repository with the following
command

    mvn install:install-file -DgroupId=com.datomic -DartifactId=datomic-free -Dfile=lib/datomic-free-0.8.3551/datomic-free-0.8.3551.jar -DpomFile=lib/datomic-free-0.8.3551/pom.xml

The repository listing should

    .m2/repository/com/datomic/
    `-- datomic-free
        |-- 0.8.3551
        |   |-- _maven.repositories
        |   |-- datomic-free-0.8.3551.jar
        |   `-- datomic-free-0.8.3551.pom
        `-- maven-metadata-local.xml
    
    2 directories, 4 files
