import pymysql

connection = pymysql.connect(
    host = 'localhost',
    user = 'jimin',
    password = 'jimin980908',
    charset = 'utf8'
)

cursor = connection.cursor()


sql = "CREATE DATABASE vote_kind"


cursor.execute(sql)

connection.commit()
connection.close()
