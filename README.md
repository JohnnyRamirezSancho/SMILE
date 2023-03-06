# Project SMILE
## MAIN PROYECT
A dental clinic requests a REST API so that its future mobile application, as well as the frontend of its Web App (currently under construction with the VUE.js framework), can consume the data stored in a MySQL database, which It is already available in the hosting they have contracted.
Requirements:
- They need to list, add, modify and delete patients.
- Each patient should have a profile.
- The api must provide access to said profile, as well as create it, modify it and, if a patient unsubscribes, it must be deleted.
- It must be possible to access a patient's data through their ID.
- Finally, the api must provide the treatments carried out on each patient.
Required and mandatory data regarding the patient:
- name
- surnames
- age
- telephone contact
- Home address
- city of residence
## PROYECT PARTS
### Design of the DDBB
<a href="https://yquetecuentas.com/f5/smile/smile-estructure-ddbb.png" target="_blank"><img src="https://yquetecuentas.com/f5/smile/smile-estructure-ddbb.png" alt="DDBB" width="200"></a>   
Attending to the minimum required, we develop the structure of the DDBB (tables and their relationships between them).
### Development of the logical part
Taking into account the minimum requirements, and starting from the structure of the DDBB created, we proceeded to develop the logic of our REST API. For this, and according to the MVC methodology, we develop the different models, controllers and services, as well as the connections and relations to the aforementioned DDBB.
##  LANGUAGES, FRAMEWORKS, DEPENDENCIES AND TOOLS
### Languages:
- JAVA
- MySQL
### Frameworks and Dependencies:
- Spring boot
- Spring Boot DevTools
- Spring Web
- MySQL Driver
- Spring Data JPA
### Tools:
- Visual Studio Code
- GitHub
- XAMPP
- MySQL server
- MsSQL Workbench
- Postman
## Team:
- [@drdaza](https://github.com/drdaza)
- [@JohnnyRamirezSancho](https://github.com/JohnnyRamirezSancho)
