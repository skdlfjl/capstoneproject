import pymysql

# vote 라는 데이터베이스 생성

connection = pymysql.connect(
    host = 'localhost',
    user = 'jimin',
    password = 'jimin980908',
    charset = 'utf8'
)

sql = "CREATE DATABASE vote"

cursor = connection.cursor()
cursor.execute(sql)

connection.commit()
connection.close()
