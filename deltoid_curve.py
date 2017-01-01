# x = 2a.cos(phi) + a.cos(2.phi)
# y = 2a.sin(phi) - a.sin(2.phi)
#
# 34.021319, -118.289209
#
# for x in range


#
# import math
# phi=0
# count=1
# while phi<=6.2832:
#     x=2*.0011*math.cos(phi)+0.0011*math.cos(2*phi)
#     y=2*.0011*math.sin(phi)-0.0011*math.sin(2*phi)
#     x+=(-118.289209)
#     y+=34.021319
#     print("%.6f,%.6f,20" % (x,y))
#     phi+=0.523625
#     count+=1


import math
phi=0
count=1
while phi<=6.2832:
    x=2*.0011*math.cos(phi)+0.0011*math.cos(2*phi)
    y=2*.0011*math.sin(phi)-0.0011*math.sin(2*phi)
    x+=(-118.2891363)
    y+=34.0216028
    print("%.6f,%.6f,20" % (x,y))
    phi+=0.523625/2
    count+=1

    # 34.0216028, -118.2891363