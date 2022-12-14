DROP TABLE IF EXISTS medicalRecords;

CREATE TABLE medicalRecords (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  disease VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO medicalRecords (id,name,disease) VALUES (1, "Sato","感冒");
INSERT INTO medicalRecords (id,name,disease) VALUES (2, "Suzuki","糖尿病");
INSERT INTO medicalRecords (id,name,disease) VALUES (3, "Takahashi","高血圧");
INSERT INTO medicalRecords (id,name,disease) VALUES (4, "Tanaka","高脂血症");
INSERT INTO medicalRecords (id,name,disease) VALUES (5, "Ito","感冒");
INSERT INTO medicalRecords (id,name,disease) VALUES (6, "Watanabe","感冒");
INSERT INTO medicalRecords (id,name,disease) VALUES (7, "Yamamoto","高脂血症");
INSERT INTO medicalRecords (id,name,disease) VALUES (8, "Nakamura","高血圧");
INSERT INTO medicalRecords (id,name,disease) VALUES (9, "Kobayashi","感冒");
INSERT INTO medicalRecords (id,name,disease) VALUES (10, "Kato","高血圧");

