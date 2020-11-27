import pymysql

connection = pymysql.connect(host = 'localhost',user = 'jimin',password = 'jimin980908',charset = 'utf8',db = 'vote')
curs = connection.cursor()

sql = """insert into result(id,name,kind,num)
        values (4,"이지희","elect senior ",1)"""
curs.execute(sql)
# curs.execute(sql,("이지희","elect senior ","2"))

connection.commit()

sql2 = "select * from result order by id"
curs.execute(sql2)

rows = curs.fetchall()
print(rows)

connection.close()
exit()