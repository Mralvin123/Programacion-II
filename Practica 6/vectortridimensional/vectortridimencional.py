import math

class vectortridimencional:
    def __init__(self, x=0, y=0, z=0):
        self.x = x
        self.y = y
        self.z = z

    # Método para sumar dos vectores
    def sumar(self, v):
        return vectortridimencional(self.x + v.x, self.y + v.y, self.z + v.z)

    # Método para restar dos vectores
    def restar(self, v):
        return vectortridimencional(self.x - v.x, self.y - v.y, self.z - v.z)

    # Método para calcular la norma longitud del vector
    def norma(self):
        return math.sqrt(self.x ** 2 + self.y ** 2 + self.z ** 2)

    # Método para calcular el producto escalar entre dos vectores
    def producto_escalar(self, v):
        return self.x * v.x + self.y * v.y + self.z * v.z

    # Método para calcular el producto vectorial entre dos vectores
    def producto_vectorial(self, v):
        return vectortridimencional(
            self.y * v.z - self.z * v.y,
            self.z * v.x - self.x * v.z,
            self.x * v.y - self.y * v.x
        )

    # Método para calcular la proyección de un vector sobre otro
    def proyeccion_sobre(self, v):
        factor = self.producto_escalar(v) / (v.norma() ** 2)
        return vectortridimencional(v.x * factor, v.y * factor, v.z * factor)

    # Método para calcular la componente de un vector en la dirección de otro
    def componente_en(self, v):
        return self.producto_escalar(v) / v.norma()

    # Método para verificar si dos vectores son perpendiculares
    def es_perpendicular(self, v):
        norma_suma = self.sumar(v).norma()
        norma_resta = self.restar(v).norma()
        return abs(norma_suma - norma_resta) < 1e-9  

    # Método para verificar si dos vectores son paralelos
    def es_paralelo(self, v):
        producto_cruzado = self.producto_vectorial(v)
        return producto_cruzado.x == 0 and producto_cruzado.y == 0 and producto_cruzado.z == 0

    # Método para multiplicar el vector por un escalar
    def multiplicar(self, escalar):
        return vectortridimencional(escalar * self.x, escalar * self.y, escalar * self.z)

    def imprimir(self):
        print(f"({self.x:.1f}, {self.y:.1f}, {self.z:.1f})")

if __name__ == "__main__":
    # Entrada de los vectores
    a1, b1, c1 = map(float, input("Ingrese el vector a : ").split())
    vec_a = vectortridimencional(a1, b1, c1)

    a2, b2, c2 = map(float, input("Ingrese el vector b : ").split())
    vec_b = vectortridimencional(a2, b2, c2)

    escalar = float(input("Ingrese el escalar: "))

    # Operaciones y resultados
    resultado_suma = vec_a.sumar(vec_b)
    print(f"a + b = ", end="")
    resultado_suma.imprimir()

    resultado_multiplicacion = vec_a.multiplicar(escalar)
    print(f"a * {escalar} = ", end="")
    resultado_multiplicacion.imprimir()

    norma_a = vec_a.norma()
    print(f"|a| = {norma_a}")

    resultado_normalizado = vec_a.sumar(vec_b)
    print(f"a normalizado = ", end="")
    resultado_normalizado.imprimir()

    producto_escalar = vec_a.producto_escalar(vec_b)
    print(f"a · b = {producto_escalar:.1f}")

    resultado_producto_vectorial = vec_a.producto_vectorial(vec_b)
    print(f"a × b = ", end="")
    resultado_producto_vectorial.imprimir()
