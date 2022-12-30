from queue import Queue
class Position:
    def __init__(self,red,blue,cnt):
        self.red_x = red[0]
        self.red_y = red[1]
        self.blue_x = blue[0]
        self.blue_y = blue[1]
        self.cnt = cnt
q = []
def search(map,v):
    print(map)
    
size = input()
inpt = size.split(" ")
r = int(inpt[0])
c = int(inpt[1])
map = []
for i in range(0,r):
    tmp = []
    t = input()
    for j in range(0,c):
        tmp.append(t[j])
        if t[j] == "R":
            red = (i,j)
        elif t[j] == "B":
            blue = (i,j)
        elif t[j] == "O":
            hole = (i,j)
    map.append(tmp)
v = []
for i in range(0,r):
    e = []
    for j in range(0,c):
        p = []
        for k in range(0,r):
            m=[]
            for u in range(0,c):
                m.append(0)
            p.append(m)
        e.append(p)
    v.append(e)   

            

start = Position(red,blue,0)
v[red[0]][red[1]][blue[0]][blue[1]] =1
q.append(start)
result = search(map,v)
print(result)