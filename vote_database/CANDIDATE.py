import pymysql

import pymysql

connection = pymysql.connect(host = 'localhost',user = 'jimin',password = 'jimin980908',charset = 'utf8',db = 'vote')
curs = connection.cursor()


# plege 오타 수정
sql = """insert into candidate(id,kind,num,cad_name,plege)
        values (2,"senior",2,"유지민","세상을 아름답겡!!")"""
curs.execute(sql)
# curs.execute(sql,("이지희","elect senior ","2"))

connection.commit()

sql2 = "select * from candidate order by id"
curs.execute(sql2)

rows = curs.fetchall()
print(rows)

connection.close()
exit()