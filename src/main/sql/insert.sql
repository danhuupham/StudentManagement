INSERT INTO Student (id, name, grade, birthday, address, notes)
VALUES ('STDNT23001', N'Phạm Hữu Đan 01', 12, '2002-07-27', N'Đồng Tháp', 'hjhj'),
       ('STDNT23002', N'Phạm Hữu Đan 02', 11, '2002-06-26', N'Đồng Tháp', NULL),
       ('STDNT23003', N'Phạm Hữu Đan 03', 10, '2002-05-25', N'Đồng Tháp', NULL),
       ('STDNT23004', N'Phạm Hữu Đan 04', 12, '2002-04-25', N'Đồng Tháp', NULL),
       ('STDNT23005', N'Phạm Hữu Đan 05', 11, '2002-03-25', N'Đồng Tháp', NULL);

INSERT INTO Course (id, name, lecturer, year, notes)
VALUES ('TOAN01', N'Giải tích', 'LCTRR001', '2022', NULL),
       ('TOAN02', N'Đại số', 'LCTRR001', '2022', NULL),
       ('TOAN03', N'Hình học', 'LCTRR001', '2022', NULL),
       ('VTLY01', N'Vật lý', 'LCTRR002', '2023', NULL),
       ('HHOC01', N'Hóa vô cơ', 'LCTRR003', '2023', NULL),
       ('HHOC02', N'Hóa hữu cơ', 'LCTRR003', '2023', NULL),
       ('SHOC01', N'Sinh học', 'LCTRR004', '2023', NULL);

INSERT INTO StudentCourse (studentId, courseId, score)
VALUES ('STDNT23001', 'TOAN01', 10),
       ('STDNT23001', 'TOAN02', 9),
       ('STDNT23001', 'TOAN03', 8),
       ('STDNT23002', 'TOAN01', 9.5),
       ('STDNT23002', 'TOAN02', 6),
       ('STDNT23002', 'TOAN03', 7),
       ('STDNT23003', 'TOAN01', 6.5),
       ('STDNT23003', 'TOAN02', 7),
       ('STDNT23003', 'TOAN03', 8),
       ('STDNT23004', 'TOAN01', 9.5),
       ('STDNT23004', 'TOAN02', 8),
       ('STDNT23004', 'TOAN03', 9),
       ('STDNT23005', 'TOAN01', 6.5),
       ('STDNT23005', 'TOAN02', 7.5),
       ('STDNT23005', 'TOAN03', 8),
       ('STDNT23001', 'VTLY01', NULL),
       ('STDNT23001', 'HHOC01', NULL),
       ('STDNT23001', 'HHOC02', NULL),
       ('STDNT23001', 'SHOC01', NULL),
       ('STDNT23002', 'VTLY01', NULL),
       ('STDNT23002', 'HHOC01', NULL),
       ('STDNT23002', 'HHOC02', NULL),
       ('STDNT23002', 'SHOC01', NULL),
       ('STDNT23003', 'VTLY01', NULL),
       ('STDNT23003', 'HHOC01', NULL),
       ('STDNT23003', 'HHOC02', NULL),
       ('STDNT23003', 'SHOC01', NULL),
       ('STDNT23004', 'VTLY01', NULL),
       ('STDNT23004', 'HHOC01', NULL),
       ('STDNT23004', 'HHOC02', NULL),
       ('STDNT23004', 'SHOC01', NULL),
       ('STDNT23005', 'VTLY01', NULL),
       ('STDNT23005', 'HHOC01', NULL),
       ('STDNT23005', 'HHOC02', NULL),
       ('STDNT23005', 'SHOC01', NULL);