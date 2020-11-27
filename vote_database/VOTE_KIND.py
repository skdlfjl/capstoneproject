import pymysql

connection = pymysql.connect(host = 'localhost',user = 'jimin',password = 'jimin980908',charset = 'utf8',db = 'vote')
curs = connection.cursor()


# formatting 이 필요할듯,,,

sql = """insert into vote_kind (id,kind,description)
        values (3,"senior","elect senior representative")"""
curs.execute(sql)
# curs.execute(sql,("2,","junior","elect junior representative"))

connection.commit()

sql2 = "select * from vote_kind order by id"
curs.execute(sql2)

rows = curs.fetchall()
print(rows)

connection.close()
exit()