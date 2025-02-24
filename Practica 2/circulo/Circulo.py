import turtle

class Punto:
    def __init__(self, x, y): 
        self.x, self.y = x, y

class Circulo:
    def __init__(self, centro, radio): 
        self.centro, self.radio = centro, radio

    def __str__(self): 
        return f"Círculo con centro en el punto ({self.centro.x},{self.centro.y}) y de radio {self.radio}"
    
    def dibujaCirculo(self):
        t = turtle.Turtle()
        t.color("blue")
        t.speed(10)
        t.penup()
        t.goto(self.centro.x, self.centro.y - self.radio)  
        t.pendown()
        t.circle(self.radio)
        turtle.done()

centro = Punto(0, 0)
circulo = Circulo(centro, 100)
print(circulo)
circulo.dibujaCirculo()
