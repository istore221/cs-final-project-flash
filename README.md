# Project Allocation to Students

## Introduction

This project focuses on allocating a final year projects to university students. Fianl year project specifications are offered to students
who must each choose a different project, though some project specifiactions will be more popular than others and attract interest from
students. Since not every student can get the project they want, they're asked to provide an ordered list of preferred projects from first
to last. In such a situation, this project helps to allocate project to students in a way that assigns their most preferable preferrence.
Here we use two algorithms namely **Genetic Algorithm** and **Simulated Annealing**.

## Technologies Used
- Java JDK 8
- Apache Tomcat 7.0.56

## External Libraries Included

#### Java
- commons-fileupload-1.3.2.
- commons-io-2.5.
- commons-io-2.5-javadoc.
- json-simple-1.1.1.

#### Web
###### CSS
- bootstrap.min.css

###### JavaScript
- jquery.min.js
- bootstrap.min.js
- bootstrap-filestyle.min.js
```
These libraries are included in this git repositary and you're not required to download it manually.
```

## Suorce Control
Git

## Installation
1. Download the .zip file of this repositary.
2. Create a folder in your tomcat `webapps` folder and copy the content of the zip file into your folder .

## Run
Enter the local URL of the project. There're two .jsp pages included namely index.jsp and result.jsp, you should use the index.jsp and the
result.jsp is used to receive ajax requests to do certain jobs.
- First you need to upload a .tsv (Tab Separated Value) file.
- Click on the `Choose File` button and select your .tsv file (this repositary already have an example file in the Data folder).
- Upload the selected file by specifying the number of preferrences a student must have.
- After on a successful upload, the radio buttons will be enabled for you to select the algorithm you want to use.

###### Simulated Annealing
This algorithm rquuires a single parameter `Number Of Times Algorithm Should Run ` to run. This means the iterations to get the 
best answer. The higher the iteration, the more the accuracy of the solution and time takes to run.
