# schema-multitenancy

* Issues with gradle
  https://intellij-support.jetbrains.com/hc/en-us/community/posts/360004383639-How-to-add-Gradle-options

* Querie Used

select * from tenant1.product

select * from tenant1.warehouse

select * from tenant1.flyway_schema_history


--delete from tenant1.flyway_schema_history where installed_rank = 2
--delete from tenant2.flyway_schema_history where installed_rank = 2


SELECT MAX(id) FROM tenant1.product;   
SELECT nextval('tenant1.product_seq');

SELECT setval('tenant1.product_seq', (SELECT MAX(id) FROM tenant1.product)+1);
SELECT setval('tenant2.product_seq', (SELECT MAX(id) FROM tenant2.product)+1);



select * from tenant2.product
select * from tenant2.warehouse

select * from tenant2.flyway_schema_history
