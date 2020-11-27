import pymysql

connection = pymysql.connect(host = 'localhost',user = 'jimin',password = 'jimin980908',charset = 'utf8',db = 'vote')
curs = connection.cursor()

sql = """insert into candidatghybue(kind,num,cad_name,pledge)
        values (%s,%s,%s,%s)"""
curs.execute(sql,("representive",1,"jimin","clean my classroom!"))
curs.execute(sql,("representive",2,"jihee","1st grade in our university!"))

connection.commit()

sql2 = "select * from candidate order by id"
curs.execute(sql)

rows = curs.fetchall()
print(rows)

connection.close()
exit()
