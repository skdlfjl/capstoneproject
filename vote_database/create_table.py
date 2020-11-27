import pymysql

#mysql에서 만든 DB 서버와 연동

connection = pymysql.connect(
    host = 'localhost',
    user = 'jimin',
    password = 'jimin980908',
    charset = 'utf8',
    db  = 'vote'
)

cursor = connection.cursor()


sql1 = """
CREATE TABLE IF NOT EXISTS vote_kind(
ID INT NOT NULL AUTO_INCREMENT,
KIND VARCHAR(30) NOT NULL,
DESCRIPTION VARCHAR(50),
PRIMARY KEY(ID)
)ENGINE= InnoDB;
"""

sql2 = """
CREATE TABLE IF NOT EXISTS candidate(
ID INT NOT NULL AUTO_INCREMENT,
KIND VARCHAR(30) NOT NULL,
NUM INT NOT NULL,
CAD_NAME VARCHAR(20) NOT NULL,
PLEDGE VARCHAR(50), 
PRIMARY KEY(ID),
FOREIGN KEY(ID) REFERENCES vote_kind(ID)
)ENGINE=InnoDB;
"""

sql3 = """
CREATE TABLE IF NOT EXISTS voter (
ID INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(20) NOT NULL,
STUDENT_ID CHAR(8) NOT NULL,
PRIMARY KEY(ID),
FOREIGN KEY(ID) REFERENCES vote_kind(ID))ENGINE = InnoDB;

"""

sql4 = """
CREATE TABLE IF NOT EXISTS result(
ID INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(20) NOT NULL,
KIND VARCHAR(30) NOT NULL,
NUM INT NOT NULL,
FOREIGN KEY(ID) REFERENCES vote_kind(ID),
FOREIGN KEY(NAME) REFERENCES voter(NAME)
)ENGINE = InnoDB;
 """



sql5 = """
CREATE TABLE IF NOT EXISTS token (
ID INT NOT NULL AUTO_INCREMENT,
TOKEN CHAR(4) NOT NULL,
PRIMARY KEY(TOKEN),
FOREIGN KEY(ID) REFERENCES vote_kind(ID)
) ENGINE=InnoDB;
"""

cursor.execute(sql1)
cursor.execute(sql2)
cursor.execute(sql3)
cursor.execute(sql4)
cursor.execute(sql5)

connection.commit()
connection.close()
