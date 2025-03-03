import turtle

class Punto:
    def __init__(self, x, y):  
        self.x, self.y = x, y

class Linea:
    def __init__(self, p1, p2): 
        self.p1, self.p2 = p1, p2

    def __str__(self):  
        return f"Línea entre los puntos ({self.p1.x}, {self.p1.y}) y ({self.p2.x}, {self.p2.y})"

    def dibujaLinea(self):
        t = turtle.Turtle()
        t.speed(3)
        t.penup()
        t.goto(self.p1.x, self.p1.y)
        t.pendown()
        t.goto(self.p2.x, self.p2.y)
        turtle.done()

punto_a = Punto(0, 0)   
punto_b = Punto(50, 50)
linea = Linea(punto_a, punto_b)
print(linea)
linea.dibujaLinea()
