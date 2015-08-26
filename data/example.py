from lightning import Lightning
from numpy import random

lgn = Lightning()

connections = random.rand(50,50)
connections[connections<0.98] = 0

g1 = (random.rand(50) * 3).astype('int')
g2 = (random.rand(50) * 3).astype('int')
group = [g2, g1]

lgn.circle(connections, group=group)