import datetime

print("Enter Start Time Parking:")
startHM = input()
print("Enter End Time Parking:")
finalHM = input()



x1 = datetime.datetime.strptime(startHM, '%H.%M')
x2 = datetime.datetime.strptime(finalHM, '%H.%M')

c = x2-x1 
print(c)

minutes = c.total_seconds() / 60
print('Total difference in minutes: ', minutes)

check4 = 240
cost = 40

if minutes > check4 :
    while minutes > 240 :
        cost = cost + 50
        minutes = minutes - 60

print("total minutes : ",minutes)   
print("total cost : ",cost) 