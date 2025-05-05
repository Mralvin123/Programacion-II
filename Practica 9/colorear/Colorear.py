from abc import ABC, abstractmethod
import random
import math
# a) 
class Coloreado(ABC):
    @abstractmethod
    def comoColorear(self) -> str:
        pass
# b) 
class Figura(ABC):
    def __init__(self, color="sin color"):
        self.color = color
    def setColor(self, color):
        self.color = color
    def getColor(self):
        return self.color
    def __str__(self):
        return f"Color: {self.color}"
    @abstractmethod
    def area(self):
        pass
    @abstractmethod
    def perimetro(self):
        pass
# c) 
class Cuadrado(Figura, Coloreado):
    def __init__(self, lado, color="sin color"):
        super().__init__(color)
        self.lado = lado

    def area(self):
        return self.lado ** 2

    def perimetro(self):
        return 4 * self.lado

    def comoColorear(self):
        return "Colorear los cuatro lados"

# d) 
class Circulo(Figura):
    def __init__(self, radio, color="sin color"):
        super().__init__(color)
        self.radio = radio

    def area(self):
        return math.pi * self.radio ** 2

    def perimetro(self):
        return 2 * math.pi * self.radio
# f-g)
figuras = []
colors = ["rojo", "verde", "azul", "amarillo", "morado", "naranja"]
tipo = random.randint(1, 2) 
for _ in range(5):
    color = random.choice(colors)
    medida = random.randint(1, 10)
    if tipo == 1:
        figura = Cuadrado(medida, color)
    else:
        figura = Circulo(medida, color)
    figuras.append(figura)

print(f"Detalles de las figuras {"Cuadradas" if tipo == 1 else "Circulares"}:")
for figura in figuras:
    print(f"{"Lado" if tipo == 1 else "Radio"}: {figura.lado if tipo == 1 else figura.radio}")
    print(f"Color: {figura.getColor()}")
    print(f"Área: {figura.area():.2f}")
    print(f"Perímetro: {figura.perimetro():.2f}")
    if tipo == 1:
        print(f"Como colorear: {figura.comoColorear()}")
    print("*"*40)
