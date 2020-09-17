## Requirements

- Install Mongodb and import data

```
mongorestore --drop --gzip --uri mongodb://127.0.0.1:27017/ data
mongorestore --db=sample_mflix data
```

- Install and run project

```
mvn spring-boot:run
```
