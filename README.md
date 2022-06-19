# LibraryManagementSystem

Library system is a very important tool to support researching. Use Spring framework to build a backend component for that system. Students can use Spring with or without SpringBoot, Hibernate or JPA, and SpringMVC RESTful API architecture. 

The system allows users to manage sub-libraries. Each sub-library contains a list of authors. Each author is associated with 1 or more books. For the sake of simplicity, each book belongs to only 1 author.

Information about a sub-library is id (integer), subject (string)
Information of an author is id (integer), and name (string), and academic credentials (string)
Information of a book is id (integer), name (string), and date of creation (date)

4.	Build entities class for sub-library, author, and book. Make sure the relationships between authors and books are one to many and bi-directional. The relationship between sub-library and author is one to many and uni-directional.

5.	Build a REST controller named LibraryController to perform add and update operations on sub-libraries. Also, a sub-library can be searched by subject and the search results will be ordered (descending or ascending)

6.	Build a REST controller named AuthorController to perform add, update, and delete operations on authors. Also, an author can be searched by name or academic credentials and the search results will be ordered (descending or ascending)

7.	Build a REST controller named BookController to perform add, update, and delete operations on books. Also, a book can be searched by name or the created date and the search results will be ordered (descending or ascending)



Students must define necessary request params or path variables in the controllers in order to provide above-mentioned features. 

Students must build necessary repositories and service classes to be called by these controllers. 

Test your system using Postman and show me the testing results in a doc.
![image](https://user-images.githubusercontent.com/62005847/174471365-11d86961-8207-4c5a-b72c-cf5df9faccdf.png)

