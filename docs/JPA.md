# JPA (Java Persistence API)

* JPA : Concept, Annotation, Interface, Service (javax.persistence)
* Persistence Provider (Hibernate, EclipseLink, Oracle TopLink, Apache OpenJPA)
* PersistenceContext, EntityManager, JPQL(Java Persistence Query Language)
* Spring Data JPA (Repository, Specification, Criteria)
* ~~Hibernate, JDO(Java Date Objects), JPA~~
* Auditing (Hibernate Entity Versioning System, Envers)

## EntityManager

* Manage entities saved in PersistenceContext
* Created for each PersistenceUnit (each DateSource, META-INF/persistence.xml?)
* @PersistenceContext EntityManage

### EntityManagerFactory

* Local + EntityManagerFactoryBean
* Jndi + EntityManagerFactory
* LocalContainer + EntityManagerFactoryBean
  * DataSource (eg. EmbeddedDatabaseBuilder + H2)
  * JpaVendorAdapter (eg. HibernateJpaVendorAdapter)
  * JpaProperties
  * ~~PackagesToScan (META-INF/persistence.xml)~~
  * ~~JpaTransactionManager + @EnableTransactionManagement~~

## Criteria

* Strongly Typed Query Object
* Find errors in Compile Time
