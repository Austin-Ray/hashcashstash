__author__ = "Pann, Samnang"

profile = ["user_id","last_name","first_name","email"]
credentials = ["user_id","username","password"]
stock_profile = ["user_id","stock_id"] ##Relationship between user and stock
currency = ["stock_id","date_time","name","symbol","rank","sod_price","current_price"]

user_id = [27043, 51051, 70839, 65928, 55187, 31543, 76285, 92192, 82338, 19337, 13512, 11466, 32473, 53704, 87505, 83886, 37641, 25997, 20163, 14687]

lastName = ["Schroeder", "Mccann", "Bolton", "Choi", "Wallace", "Cruz", "Gallegos", "Baird", "Acevedo", "Krueger", "Galvan", "Chavez", "Richardson", "Davenport", "French", "Hester", "Wong", "Rush", "Swanson", "Copeland"]

firstName = ["Ashly", "Clarence", "Jerimiah", "Lina", "Noah", "Addyson", "Daniel", "Enzo", "Thalia", "Jose", "Agustin", "Erika", "Jaidyn", "Andres", "Libby", "Anika", "Darrell", "Shayla", "Josh", "Emmalee"]

email = ["Ashly.Schroeder@test.com", "Clarence.Mccann@test.com", "Jerimiah.Bolton@test.com", "Lina.Choi@test.com", "Noah.Wallace@test.com", "Addyson.Cruz@test.com", "Daniel.Gallegos@test.com", "Enzo.Baird@test.com", "Thalia.Acevedo@test.com", "Jose.Krueger@test.com", "Agustin.Galvan@test.com", "Erika.Chavez@test.com", "Jaidyn.Richardson@test.com", "Andres.Davenport@test.com", "Libby.French@test.com", "Anika.Hester@test.com", "Darrell.Wong@test.com", "Shayla.Rush@test.com", "Josh.Swanson@test.com", "Emmalee.Copeland@test.com"]

username = ["Snarelure", "Skullbone", "Burnblaze", "Emberburn", "Emberfire", "Evilember", "Firespawn", "Flameblow", "SniperGod", "TalkBomber", "SniperWish", "RavySnake", "WebTool", "TurtleCat", "BlogWobbles", "LuckyDusty", "RumChicken", "StonedTime", "CouchChiller", "VisualMaster"]

password = ["p4ScNtGGL_", "nv_20Ij#j5", "iA9+zgD=df", "q3MO%H690Z", "cv1qK^_zEJ", "Sqkei2%vSp", "i%2QID?k2p", "uA^l3W=8SW", "iBem9Y6~TI", "ecc=n98Pfg", "eTeW*cN5lp", "hFits9*Xo6", "az=Wis80!M", "uUjgfu*v4i", "Y%W*Eh47r9", "BjS+dus$X6", "r97Ya%Pmey", "n&jjX@z1BU", "N5$A*tj3Yp", "Gk#PJRoVFW"]

stock_id = ["bitcoin","ethereum","ripple","bitcoin cash","litecoin","eos","cardano","stellar","neo","iota"]

stock_date = ["2018-01-01","2018-01-02","2018-01-03"]

stock_name = ["Bitcoin","Ethereum","Ripple","Bitcoin Cash","Litecoin","EOS", "Cardano","Stellar","NEO", "IOTA"]

stock_symbol = ["BTC","ETH","XRP","BCH","LTC","EOS","ADA","XLM","NEO","MIOTA"]

stock_rank = [1,2,3,4,5,6,7,8,9,10]
    
openingPrice = [93869, 60057, 65437, 85887, 9123, 6526, 49923, 27797, 8366,93869, 60057, 65437, 85887, 9123, 6526, 49923, 27797, 8366,93869, 60057, 65437, 85887, 9123, 6526, 49923, 2779, 652234]

closingPrice = [34907, 60542, 22546, 40320, 96387, 27267, 82497, 47890, 93029,34907, 60542, 22546, 40320, 96387, 27267, 82497, 47890, 93029,34907, 60542, 22546, 40320, 96387, 27267, 82497, 47890, 93029]

#percentChange = [-590, 4, -429, -456, 872, 207, 325, 200, 846,-590, 4, -429, -456, 872, 207, 325, 200, 846,-590, 4, -429, -456, 872, 207, 325, 200, 846]

#phoneNum = [9625845629, 5113823971, 7085202276, 9768553659, 3227999859, 1805529823, 9850786984, 8245922080, 3091476021, 9183388741, 7093796099, 2840946032, 4042317514, 5352385797, 6380251487, 2691739135, 4029257590, 8482174056, 8433801684, 2085980168]

#cash = [18572, 419, 38395, 27836, 12623, 72012, 66984, 82034, 55983, 17717, 72200, 31076, 91786, 68014, 43620, 2434, 99828, 67541, 79139, 14447]

#address = ["9377 Bohemia Lane", "9043 Crescent St.", "78 Silver Spear St.", "136 Brickyard Dr.", "7812 Wayne Lane", "9407 Trusel Ave.", "253 Circle Street", "7670 E. Liberty Court", "8228 Surrey Street", "9990 East Riverview Road", "445 Dunbar St.", "49 Race Drive", "662 Airport St.", "946 Orchard Street", "9338 Mayflower St.", "6 Brickyard Street", "7163 Tunnel Street", "865 Taylor Ave.", "159 Bridge St.", "75 New St."]

if __name__ == "__main__":
    import random as rand
    brokers = 7
    clients = 13
"""
Used to create the fake data for the lists above.
"""
#    for num in range(len(openingPrice)):
#        print str((closingPrice[num]-openingPrice[num]) / 100)+",",

#    file = open("password.txt","r")

#    for name in file:
#        print '"'+name.rstrip().lstrip()+'",',
#    file.close() 

#    for num in range(13):
#        print str(rand.randint(0,1000))+",",

#    for i in range(len(lastName)):
#        print '"'+firstName[i]+'.'+lastName[i]+'@test.com",',
#########################################################

"""
Output file
"""
file = open("sampleData.sql","w")


"""
EXAMPLE:
for i in range(len(user_id)):
    file.write("INSERT INTO people ("+people[0]+","+people[1]+","+people[2]+") VALUES ("+str(user_id[i])+",\""+lastName[i]+"\",\""+firstName[i]+"\");\n")
"""

"""
Populates credentials table
"""
for i in range(len(username)):
    file.write("insert into credentials values ("+str(user_id[i])+",\""+username[i]+"\",\""+password[i]+"\");\n")

"""
Populates profile table
"""
for j in range(len(user_id)):
    file.write('insert into profile values ('+str(user_id[j])+',"'+lastName[j]+'","'+firstName[j]+'","'+email[j]+'");\n')

"""
Populates stock_profile
"""
for k in range(len(user_id)):
    num = rand.randint(0,len(stock_name))
    for l in range(num):
        randomNum = rand.randint(0,len(stock_name)-1)
        file.write('insert into stock_profile values ('+str(user_id[k])+',"'+stock_id[randomNum]+'");\n')

"""
Populates stock currency
"""
for m in range(len(stock_id)):
    for n in range(len(stock_date)):
        file.write('insert into currency values ("'+stock_id[m]+'","'+stock_date[n]+'","'+stock_name[m]+'","'+stock_symbol[m]+'",'+str(stock_rank[m])+','+str(openingPrice[m]+n)+','+str(closingPrice[m]+n)+');\n')
    

file.close()

