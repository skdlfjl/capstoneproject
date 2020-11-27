import pymysql

import pymysql

connection = pymysql.connect(host = 'localhost',user = 'jimin',password = 'jimin980908',charset = 'utf8',db = 'vote')
curs = connection.cursor()

sql = """insert into voter(id,name,student_id)
        values (1,"유지민","20171458")"""
curs.execute(sql)
# curs.execute(sql,("이지희","elect senior ","2"))

connection.commit()

sql2 = "select * from voter order by id"
curs.execute(sql2)

rows = curs.fetchall()
print(rows)

connection.close()
exit()