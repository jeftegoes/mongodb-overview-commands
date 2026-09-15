# MongoDB overview and commands <!-- omit in toc -->

## Contents <!-- omit in toc -->

- [1. NoSQL](#1-nosql)
- [2. Whats is MongoDb?](#2-whats-is-mongodb)
  - [2.1. How it works](#21-how-it-works)
  - [2.2. JSON (BSON) Data Format](#22-json-bson-data-format)
  - [2.3. Relationships](#23-relationships)
- [3. MongoDB Ecosystem](#3-mongodb-ecosystem)
  - [3.1. Working with MongoDB](#31-working-with-mongodb)
  - [3.2. A Closer Look](#32-a-closer-look)
  - [3.3. Using MongoDB Drivers](#33-using-mongodb-drivers)
  - [3.4. NoSQL Characteristics](#34-nosql-characteristics)
  - [3.5. SQL vs NoSQL](#35-sql-vs-nosql)
  - [3.6. Summary](#36-summary)
- [4. CRUD](#4-crud)
  - [4.1. Databases, Collections, Documents](#41-databases-collections-documents)
  - [4.2. JSON](#42-json)
  - [4.3. CRUD Operations](#43-crud-operations)
    - [4.3.1. Examples](#431-examples)
- [5. Unique IDs](#5-unique-ids)
- [6. Embedded Documents](#6-embedded-documents)
- [7. Projection](#7-projection)
- [8. Schema-less Or Not?](#8-schema-less-or-not)
  - [8.1. To Schema Or Not To Schema](#81-to-schema-or-not-to-schema)
- [9. Data Types](#9-data-types)
- [10. Data Schemas \& Data Modelling](#10-data-schemas--data-modelling)
- [11. Relations](#11-relations)
  - [11.1. Example #1 - Patient \<-\> Disease Summary](#111-example-1---patient---disease-summary)
  - [11.2. Example #2 - Person \<-\> Car](#112-example-2---person---car)
  - [11.3. Example #3 - Thread \<-\> Answers](#113-example-3---thread---answers)
  - [11.4. Example #4 - City \<-\> Citizens](#114-example-4---city---citizens)
  - [11.5. Example #5 - Customers \<-\> Products (Orders)](#115-example-5---customers---products-orders)
  - [11.6. Example #6 - Books \<-\> Authors](#116-example-6---books---authors)
  - [11.7. Relations - Options](#117-relations---options)
- [12. String connection](#12-string-connection)
- [13. Commands](#13-commands)

# 1. NoSQL

- **NoSQL** is a **database paradigm** that encompasses several types of non-relational databases designed to provide:
  - Flexibility.
  - Scalability.
  - High performance.
- Unlike relational databases, NoSQL databases do not require data to be stored in **fixed tables** with predefined schemas.
- Instead, they use different data models depending on the application's needs.
- The four main NoSQL database paradigms are:
  - **Document databases** (e.g., MongoDB)
  - **Key-value databases** (e.g., Redis)
  - **Wide-column databases** (e.g., Cassandra)
  - **Graph databases** (e.g., Neo4j)

# 2. Whats is MongoDb?

- What does "Mongo" mean?
  **Humongous** - MongoDB is designed to store and manage very large amounts of data.
  - MongoDB is an **open-source, document-oriented NoSQL database** designed to store and manage large amounts of data efficiently.
  - Unlike traditional relational databases (such as MySQL or PostgreSQL), MongoDB stores data as **documents** instead of rows in tables.

## 2.1. How it works

- A MongoDB server can host multiple databases.
- Each database contains **collections**, and each collection stores **documents**.
  ![MongoDB Structure](/images/mongodb-structure.png)

## 2.2. JSON (BSON) Data Format

- Every record in MongoDB is actually a **document**.
  - Documents are stored in MongoDB in JSON like Binary JSON (BSON) format.
- **BSON** documents are objects that contain an ordered list of the elements they store.
  - Each element consists of a domain name and a certain type of value.
- **JSON data format**
  ```json
  {
    "name": "Jefté",
    "age": 33,
    "address": {
      "city": "Brazil"
    },
    "hobbies": [
      {
        "name": "Lego"
      },
      {
        "name": "Games"
      }
    ]
  }
  ```
- BSON Data Structure
  ![BSON Data Structure](/images/bson-data-structure.png)

## 2.3. Relationships

- Unlike relational databases, MongoDB minimizes the use of relationships between collections.
- Instead of splitting related data across multiple tables and joining them later, MongoDB often stores related data together in the same document using **embedded documents**.

# 3. MongoDB Ecosystem

![MongoDB Ecosystem](/images/mongodb-ecosystem.png)

## 3.1. Working with MongoDB

![Working with MongoDB](/images/working-mongodb.png)

## 3.2. A Closer Look

![Working with MongoDB](/images/working-mongodb-close-look.png)

## 3.3. Using MongoDB Drivers

## 3.4. NoSQL Characteristics

![NoSQL Characteristics](/images/nosql-characteristics.png)

## 3.5. SQL vs NoSQL

| SQL                                                                         | NoSQL                                                       |
| --------------------------------------------------------------------------- | ----------------------------------------------------------- |
| Data uses Schemas                                                           | Schema-less                                                 |
| Relations!                                                                  | No (or very few) Relations                                  |
| Data is distributed across multiple tables                                  | Data is typically merged / nested in a few collections      |
| Horizontal scaling is difficult / impossible; Vertical scaling is possible. | Both horizontal and vertical scaling is possible            |
| Limitations for lots of (thousands) read and write queries per second.      | Great performance for mass (simple) read and write requests |

## 3.6. Summary

- Alternative to SQL databases.
- No strict schemas, fewer relations.
- You can of course use schemas and reference-based relations but you got more flexibility.
- Often, relations are also created by embedding other documents/ data.

# 4. CRUD

## 4.1. Databases, Collections, Documents

![Databases, Collections, Documents](/images/databases-collections-documents.png)

## 4.2. JSON

![JSON Structure](/images/json-structure.png)

## 4.3. CRUD Operations

![CRUD Operations](/images/crud-operations.png)

### 4.3.1. Examples

- **Create**
  - `db.products.insertOne({"name" : "shoes", "price": 20.3})`
  - `db.products.insertOne({"name" : "gloves", _id: "my-custom-id"})`
  - `db.products.insertMany([{"name" : "gloves"}, {"name" : "shoes"}])`
- **Read**
  - `db.products.find()`
  - `db.products.find({"name" : "gloves"})`
  - `db.products.find({"price" : {$gt: 10}})` # gt = Greater than
  - `db.products.find({}, {_id: 0, "name": 1})` # 0 - To exclude
- **Update**
  - `db.products.updateOne({"name" : "bag"}, {$set: {"name" : "gloves"}})`
  - `db.products.updateOne({}, {$set: {"name" : "shirt"}})`
  - `db.products.updateMany({}, {$set: {"marker" : "toDelete"}})`
  - `db.products.replaceOne({_id: ObjectId('6a7209b7cf1fb8d2fd794e20')}, {"name" : "gloves"})`
- **Delete**
  - `db.products.deleteOne({})`
  - `db.products.deleteOne({"name" : "shoes"})`
  - `db.products.deleteMany({"marker" : "toDelete"})`
  - **Remove**
    - `db.products.remove({})`

# 5. Unique IDs

- Wb MUST have an `_id`.
- MongoDB creates an `ObjectId()` for you.
- You can set any other Value.
  - `db.products.insertOne({"name" : "gloves", _id: "my-custom-id"})`

# 6. Embedded Documents

![Embedded Documents](/images/embedded-documents.png)

# 7. Projection

![Projection](/images/projection.png)

# 8. Schema-less Or Not?

- Isn't MongoDB all about having NO data Schemas?
  - MongoDB enforces no schemas! Documents don't have to use the same schema inside of one collection.
    - But that does not mean that you can't use some kind of schema.

## 8.1. To Schema Or Not To Schema

![To Schema Or Not To Schema](/images/to-schema-or-not-to-schema.png)

# 9. Data Types

- `Text` - "Jefté"
- `Boolean` - true
- **Numbers**
  - `Integer (int32)` - 55
  - `NumberLong (int64)` - 10000000000
  - `NumberDecimal` - 12.99
- `ObjectId` - ObjectId("sfasd")
- **Dates**
  - `ISODate` - ISODate("2018-09-09")
  - `Timestamp` - Timestamp(11421532)
- `Embedded Document` - { "a": { ... } }
- `Array` - { "b": [ ... ] }

# 10. Data Schemas & Data Modelling

- Which Data does my App need or generate?
  - User Information, Product Information, Orders, ...
    - Defines the Fields you'll need (and how they relate).
- Where do I need my Data?
  - Welcome Page, Products List Page, Orders Page.
    - Defines your required collections + field groupings.
- Which kind of Data or Information do I want to display?
  - Welcome Page: Product Names; Products Page: ...
    - Defines which queries you'll need
- How often do I fetch my data?
  - For every page reload.
    - Defines whether you should optimize for easy fetching.
- How often do I write or change my data?
  - Orders => Often.
  - Product Data => Rarely.
    - Defines whether you should optimize for easy writing.
- **Fetching a lot?**
  - **Goal:** Store Data in the Format you need in your Frontend! Don't run complex transformation queries!
- **Writing a lot?**
  - **Goal:** Store Data such that you avoid duplicates and redundancy!

# 11. Relations

![Relations](/images/relations-options-1.png)

## 11.1. Example #1 - Patient <-> Disease Summary

![One-to-one](/images/one-to-one-patient-summary.png)

- **Using embedded**
  - "One patient has one disease summary, a disease summary belongs to one patient.".
    - `db.patients.insertOne({name: "Jefté", age: 35, diseaseSummary: {diseases: ["cold", "broken leg"]}})`

## 11.2. Example #2 - Person <-> Car

![One-to-one](/images/one-to-one-person-car.png)

- **Using reference**
  - "One person has one car, a car belongs to one person.".
    - `db.persons.insertOne({name: "Jefté", age: 35, salary: 3000})`
    - `db.cars.insertOne({model: "BMW", price: 40000, owner: ObjectId("5b98d4654d01c52e1637a99b")})`

## 11.3. Example #3 - Thread <-> Answers

![One-to-Many](/images/one-to-many-thread-answers.png)

- **Using embedded**
  - "One thread has many answers, one answer belongs to one question thread.".
  - `db.questionThreads.insertOne({creator: "Jefté", question: "How does that work?", answers: [{text: "Like that."}, {text: "Thanks!"}]})`

## 11.4. Example #4 - City <-> Citizens

![One-to-Many](/images/one-to-many-city-citizens.png)

- **Using reference**
  - "One city has many citizens, one citizen belongs to one city.".
    - `db.cities.insertOne({name: "New York City", coordinates: {lat: 21, lng: 55}})`
    - `db.citizens.insertMany([{name: "Jefté Goes", cityId: ObjectId("5b98d6b44d01c52e1637a99f")}, {name: "Brenno Salvador", cityId: ObjectId("5b98d6b44d01c52e1637a99f")}])`

## 11.5. Example #5 - Customers <-> Products (Orders)

![Many-to-Many](/images/many-to-many-customers-products.png)

- **Using embedded**
  - "One customer has many products (via orders), a product belongs to many customers.".
    - `db.customers.insertOne({name: "Jefté", age: 35})`
    - `db.customers.updateOne({}, {$set: {orders: [{title: "A Book", price: 12.99, quantity: 2}]}})`

## 11.6. Example #6 - Books <-> Authors

![Many-to-Many](/images/many-to-many-books-authors.png)

- **Using reference**
  - "One book has many authors, an author belongs to many books.".
  - `db.books.insertOne({name: "My favorite Book", authors: [{name: "Capitães da Areia"}, {name: "Vidas Secas"}]})`
  - `db.authors.insertMany([{name: "Jorge Amado", age: 78, address: {street: "Bahia"}}, {name: "Graciliano Ramos", age: 55, address: {stree: "Rio de Janeiro"}}])`
  - `db.books.updateOne({}, {$set: {authors: [ObjectId("5b98d9e44d01c52e1637a9a6"), ObjectId("5b98d9e44d01c52e1637a9a7")]}})`

## 11.7. Relations - Options

| Nested / Embedded Documents                                                                    | References                                                                                      |
| ---------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| Group data together logically                                                                  | Split data across collections                                                                   |
| Great for data that belongs together and is not really overlapping with other data             | Great for related but shared data as well as for data which is used in relations and standalone |
| Avoid super-deep nesting (100+ levels) or extremely long arrays (16mb size limit per document) | Allows you to overcome nesting and size limits (by creating new documents)                      |

# 12. String connection

- `mongodb://localhost:27017` or `mongodb://mongoadmin:Master123456@localhost:27017/<database_name>?authSource=admin`

# 13. Commands

- To get a Connection String.
  - `db.getMongo()`
- Enter into a mongo shell.
  - `mongosh`
  - Connect with username.
    - `mongosh --username <username>`
- Show all databases.
  - `show databases`
  - `show dbs`
- Show all collections.
  - `show collections`
- Create a new database.
  - `use <database_name>`
- Create new collection.
  - `db.createCollection("<collection_name>")`
- Insert ONE object into collection.
  - `db.<collection_name>.insertOne({<object>>})` # Ex: db.books.insertOne({name: "Clean Code", author: "Uncle Bob"})
  - **Result**
    ```json
        [
            {
                _id: ObjectId('65ef5a432a78dcfaea37258b'),
                name: 'Clean Code',
                author: 'Uncle Bob'
            }
        ]
    ```
- Insert MANY objects once time into collection
  - `db.books.insertMany([{<object>>}])` # Ex: db.books.insertMany([{name: "Clean Code", author: "Uncle Bob"}, {name: "Clean Architecture", author: "Uncle Bob"}])
  - **Result**
    ```json
        [
            {
                _id: ObjectId('65ef5b502a78dcfaea372590'),
                name: 'Clean Code',
                author: 'Uncle Bob'
            },
            {
                _id: ObjectId('65ef5b502a78dcfaea372591'),
                name: 'Clean Architecture',
                author: 'Uncle Bob'
            }
        ]
    ```
- Remove the collection
  - `db.<collection_name>.drop()`
- Find all objects of collection.
  - `db.<collection_name>.find()` # Ex: db.books.find()
- Remove all itens of collection.
  - db.`<collection_name>`.remove({})
- Delete database.
  1. `use <database_name>`
  2. `db.dropDatabase()`
