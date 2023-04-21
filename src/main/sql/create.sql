USE master;
GO

DROP DATABASE IF EXISTS StudentManagement;
GO

CREATE DATABASE StudentManagement;
GO

USE StudentManagement;
GO

DROP TABLE IF EXISTS Student;
CREATE TABLE Student
(
    id       VARCHAR(10)   NOT NULL,
    name     NVARCHAR(255) NOT NULL,
    grade    INT           NOT NULL,
    birthday DATE          NOT NULL,
    address  NVARCHAR(255) NOT NULL,
    notes    NVARCHAR(255),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Course;
CREATE TABLE Course
(
    id       VARCHAR(10)   NOT NULL,
    name     NVARCHAR(255) NOT NULL,
    lecturer VARCHAR(10)   NOT NULL,
    year     INT           NOT NULL,
    notes    NVARCHAR(255),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS StudentCourse;
CREATE TABLE StudentCourse
(
    studentId VARCHAR(10) NOT NULL,
    courseId  VARCHAR(10) NOT NULL,
    score     float,
    PRIMARY KEY (studentId, courseId)
);