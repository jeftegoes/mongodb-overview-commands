# MongoDB overview and commands <!-- omit in toc -->

## Contents <!-- omit in toc -->

- [1. Whats is MongoDb?](#1-whats-is-mongodb)
  - [1.1. How it works](#11-how-it-works)
  - [1.2. JSON (BSON) Data Format](#12-json-bson-data-format)
  - [1.3. BSON Data Structure](#13-bson-data-structure)
  - [1.4. Relations](#14-relations)
- [2. MongoDB Ecosystem](#2-mongodb-ecosystem)
  - [2.1. Working with MongoDB](#21-working-with-mongodb)
  - [2.2. A Closer Look](#22-a-closer-look)
  - [2.3. Using MongoDB Drivers](#23-using-mongodb-drivers)
  - [2.4. NoSQL Characteristics](#24-nosql-characteristics)
  - [2.5. SQL vs NoSQL](#25-sql-vs-nosql)
  - [2.6. Summary](#26-summary)
- [3. Document \& CRUD Basics](#3-document--crud-basics)
- [4. String connection](#4-string-connection)
- [5. Commands](#5-commands)

# 1. Whats is MongoDb?

- What does "Mongo" mean?
  **Humongous** - MongoDB is designed to store and manage very large amounts of data.
- MongoDB is an open-source, document-oriented NoSQL database designed for ease of development and horizontal scaling.
- There are many NoSQL databases on the market today, including Cassandra, Bigtable, and Amazon DynamoDB (AWS).

## 1.1. How it works

![MongoDB Structure](/Images/MongoDBStructure.png)

## 1.2. JSON (BSON) Data Format

- Every record in MongoDB is actually a **document**.
  - Documents are stored in MongoDB in JSON like Binary JSON (BSON) format.
- **BSON** documents are objects that contain an ordered list of the elements they store.
  - Each element consists of a domain name and a certain type of value.
  - JSON (BSON) data format:
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
- **Document based NoSql database**
  - It keeps the data structurally in Json format and in documents.
  - Queries can be written in any field or by range.
  - If we compare the structures in MongoDB with the structures in their relational databases, it uses Collection instead of Tables and uses Documents instead of rows.

## 1.3. BSON Data Structure

![BSON Data Structure](/Images/BSONDataStructure.png)

## 1.4. Relations

Relations
No/ Few Relations!
Relational Data needs to be merged manually!
Kind of…

# 2. MongoDB Ecosystem

![MongoDB Ecosystem](/Images/MongoDBEcosystem.png)

## 2.1. Working with MongoDB

![Working with MongoDB](/Images/WorkingMongoDB.png)

## 2.2. A Closer Look

![Working with MongoDB](/Images/WorkingMongoDBCloseLook.png)

## 2.3. Using MongoDB Drivers

## 2.4. NoSQL Characteristics

![NoSQL Characteristics](/Images/NoSQLCharacteristics.png)

## 2.5. SQL vs NoSQL

| SQL                                                                         | NoSQL                                                       |
| --------------------------------------------------------------------------- | ----------------------------------------------------------- |
| Data uses Schemas                                                           | Schema-less                                                 |
| Relations!                                                                  | No (or very few) Relations                                  |
| Data is distributed across multiple tables                                  | Data is typically merged / nested in a few collections      |
| Horizontal scaling is difficult / impossible; Vertical scaling is possible. | Both horizontal and vertical scaling is possible            |
| Limitations for lots of (thousands) read and write queries per second.      | Great performance for mass (simple) read and write requests |

## 2.6. Summary

- Alternative to SQL databases.
- No strict schemas, fewer relations.
- You can of course use schemas and reference-based relations but you got more flexibility.
- Often, relations are also created by embedding other documents/ data.

# 3. Document & CRUD Basics

# 4. String connection

- `mongodb://localhost:27017` or `mongodb://mongoadmin:Master123456@localhost:27017/<database_name>?authSource=admin`

# 5. Commands

- To get a Connection String.
  - `db.getMongo()`
- Enter into a mongo shell
  - `mongo` or `mongosh`
  - Connect with username
    - `mongosh --username <username>`
- Show all databases
  - `show databases`
  - `show dbs`
- Show all collections
  - `show collections`
- Create a new database
  - `use <database_name>`
- Create new collection
  - `db.createCollection("<collection_name>")`
- Insert ONE object into collection
  - `db.<collection_name>.insertOne({<object>>})` # Ex: db.books.insertOne({name: "Clean Code", author: "Uncle Bob"})
  - Result:
    ```
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
  - Result:
    ```
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
- Find all objects of collection
  - `db.<collection_name>.find()` # Ex: db.books.find()
- Remove all itens of collection
  - db.`<collection_name>`.remove({})
- Delete database
  1. `use <database_name>`
  2. `db.dropDatabase()`
