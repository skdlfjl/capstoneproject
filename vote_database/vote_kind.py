import pymysql

connection = pymysql.connect(host = 'localhost',user = 'jimin',password = 'jimin980908',charset = 'utf8',db = 'vote')
curs = connection.cursor()

sql = """insert into vote_kind(kind,description)
        values (%s,%s)"""
curs.execute(sql,("senior representative","elect senior representative"))
curs.execute(sql,("junior representative","elect junior representative"))

connection.commit()

sql2 = "select * from vote_kind order by id"
curs.execute(sql2)

rows = curs.fetchall()
print(rows)

connection.close()
exit()