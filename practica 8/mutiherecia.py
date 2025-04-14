class A:
    def __init__(self, x, z):
        self._x = x
        self._z_a = z  

    def getX(self):
        return self._x

    def getZ_A(self):
        return self._z_a

    def setX(self, x):
        self._x = x

    def setZ_A(self, z):
        self._z_a = z

    def incrementaXZ(self):
        self._x += 1
        self._z_a += 1

    def incrementaZ_A(self):
        self._z_a += 1

class B:
    def __init__(self, y, z):
        self._y = y
        self._z_b = z  

    def getY(self):
        return self._y

    def getZ_B(self):
        return self._z_b

    def setY(self, y):
        self._y = y

    def setZ_B(self, z):
        self._z_b = z

    def incrementaYZ(self):
        self._y += 1
        self._z_b += 1

    def incrementaZ_B(self):
        self._z_b += 1

class D(A, B):
    def __init__(self, x, y, z):
        A.__init__(self, x, z)
        B.__init__(self, y, z)

    def incrementaXYZ(self):
        self._x += 1
        self._y += 1
        self._z_a += 1
        self._z_b += 1

    def mostrar(self):
        print("x =", self.getX())
        print("y =", self.getY())
        print("z desde A =", self.getZ_A())
        print("z desde B =", self.getZ_B())

if __name__ == "__main__":
    obj = D(1, 2, 3)
    obj.incrementaXYZ()
    obj.mostrar()
