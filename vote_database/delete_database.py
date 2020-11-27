import pymysql

connection = pymysql.connect(host = 'localhost',user = 'jimin',password = 'jimin980908',charset = 'utf8',db = 'vote')

curs = connection.cursor()

sql = "DROP DATABASE vote"

curs.execute(sql)