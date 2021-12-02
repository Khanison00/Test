import re
a = '99 ม.2 ต.นาไร่หลวง อ.สองแคว จ.น่าน 55160 02-4573498'
b = '99 ม.2 นาไร่หลวง    สองแคว   น่าน 55160 02-4573498'
c = '99 ม.2 ตำบลนาไร่หลวงอำเภอสองแควจังหวัดน่าน55160 02-4573498'
print(a)
print(b)
print(c)
print(".............")


remove_characters = ["ม." ,"ต.", "ตำบล", "อ.", "อำเภอ", "จ.", "จังหวัด"]
for character in remove_characters:
  a = a.replace(character, " ")
  b = b.replace(character, " ")
  c = c.replace(character, " ")
  
print(a)
print(b)
print(c)
print(".............")

a =  re.sub(r"([0-9]+(\.[0-9]+)?)",r" \1", a)
print(a)
b =  re.sub(r"([0-9]+(\.[0-9]+)?)",r" \1", b)
print(b)
c =  re.sub(r"([0-9]+(\.[0-9]+)?)",r" \1", c)
print(c)

a = " ".join(a.split())
b = " ".join(b.split())
c = " ".join(c.split())



print(a)
print(b)
print(c)
print(".............")
a = a.split(" ")
print(a)
b = b.split(" ")
print(b)
c = c.split(" ")
print(c)

print(".............")

(a[6]) = (a[6])+(a[7])
a.pop(7)
print(a)
(b[6]) = (b[6])+(b[7])
b.pop(7)
print(b)
(c[6]) = (c[6])+(c[7])
c.pop(7)
print(c)

print(".............")


