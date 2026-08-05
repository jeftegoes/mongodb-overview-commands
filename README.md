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
- [5. String connection](#5-string-connection)
- [6. Commands](#6-commands)

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
  ![MongoDB Structure](/images/MongoDBStructure.png)

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
  ![BSON Data Structure](/images/BSONDataStructure.png)

## 2.3. Relationships

- Unlike relational databases, MongoDB minimizes the use of relationships between collections.
- Instead of splitting related data across multiple tables and joining them later, MongoDB often stores related data together in the same document using **embedded documents**.

# 3. MongoDB Ecosystem

![MongoDB Ecosystem](/images/MongoDBEcosystem.png)

## 3.1. Working with MongoDB

![Working with MongoDB](/images/WorkingMongoDB.png)

## 3.2. A Closer Look

![Working with MongoDB](/images/WorkingMongoDBCloseLook.png)

## 3.3. Using MongoDB Drivers

## 3.4. NoSQL Characteristics

![NoSQL Characteristics](/images/NoSQLCharacteristics.png)

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

# 5. String connection

- `mongodb://localhost:27017` or `mongodb://mongoadmin:Master123456@localhost:27017/<database_name>?authSource=admin`

# 6. Commands

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
