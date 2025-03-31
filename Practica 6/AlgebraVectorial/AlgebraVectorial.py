import math

class AlgebraVectorial:
    def __init__(self, x=0, y=0, z=0):
        self.x = x
        self.y = y
        self.z = z

    # Método para sumar dos vectores
    def sumar(self, v):
        return AlgebraVectorial(self.x + v.x, self.y + v.y, self.z + v.z)

    # Método para restar dos vectores
    def restar(self, v):
        return AlgebraVectorial(self.x - v.x, self.y - v.y, self.z - v.z)

    # Método para calcular la norma (longitud) del vector
    def norma(self):
        return math.sqrt(self.x ** 2 + self.y ** 2 + self.z ** 2)

    # Método para calcular el producto escalar entre dos vectores
    def producto_escalar(self, v):
        return self.x * v.x + self.y * v.y + self.z * v.z

    # Método para calcular el producto vectorial entre dos vectores
    def producto_vectorial(self, v):
        return AlgebraVectorial(
            self.y * v.z - self.z * v.y,
            self.z * v.x - self.x * v.z,
            self.x * v.y - self.y * v.x
        )

    # Método para calcular la proyección de un vector sobre otro
    def proyeccion_sobre(self, v):
        factor = self.producto_escalar(v) / (v.norma() ** 2)
        return AlgebraVectorial(v.x * factor, v.y * factor, v.z * factor)

    # Método para calcular la componente de un vector en la dirección de otro
    def componente_en(self, v):
        return self.producto_escalar(v) / v.norma()

    # Método para verificar si dos vectores son perpendiculares
    def es_perpendicular(self, v):
        norma_suma = self.sumar(v).norma()
        norma_resta = self.restar(v).norma()
        return abs(norma_suma - norma_resta) < 1e-9  # Comparación con margen de error

    # Método para verificar si dos vectores son paralelos
    def es_paralelo(self, v):
        producto_cruzado = self.producto_vectorial(v)
        return producto_cruzado.x == 0 and producto_cruzado.y == 0 and producto_cruzado.z == 0

    # Método para multiplicar el vector por un escalar
    def multiplicar(self, escalar):
        return AlgebraVectorial(escalar * self.x, escalar * self.y, escalar * self.z)

    # Método para imprimir el vector con formato
    def imprimir(self):
        # Formato con dos decimales
        print(f"({self.x:.2f}, {self.y:.2f}, {self.z:.2f})")

if __name__ == "__main__":
    # Entrada de los vectores
    print("Introduzca el vector a: ")
    a1, b1, c1 = map(float, input().split())
    vec_a = AlgebraVectorial(a1, b1, c1)

    print("Introduzca el vector b: ")
    a2, b2, c2 = map(float, input().split())
    vec_b = AlgebraVectorial(a2, b2, c2)

    # Sumar vectores
    resultado_suma = vec_a.sumar(vec_b)
    print("a+b:")
    resultado_suma.imprimir()

    # Restar vectores
    resultado_resta = vec_a.restar(vec_b)
    print("a-b:")
    resultado_resta.imprimir()

    # Producto escalar
    producto_punto = vec_a.producto_escalar(vec_b)
    print(f"Producto escalar (a·b): {producto_punto:.1f}")

    # Perpendicularidad
    print("Perpendicularidad:")
    if vec_a.es_perpendicular(vec_b):
        print("a y b son ortogonales (perpendiculares)")
    else:
        print("a y b no son ortogonales")

    # Paralelismo
    print("Paralelismo:")
    if vec_a.es_paralelo(vec_b):
        print("a y b son paralelos")
    else:
        print("a y b no son paralelos")

    # Proyección de a sobre b
    print("Proyección de a sobre b:")
    proyeccion = vec_a.proyeccion_sobre(vec_b)
    proyeccion.imprimir()

    # Componente de a en la dirección de b
    print("Componente de a en la dirección de b:")
    componente = vec_a.componente_en(vec_b)
    print(f"{componente:.2f}")
