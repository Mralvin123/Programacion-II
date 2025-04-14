import math  
def get_discriminante(a, b, c):
    # Fórmula del discriminante: b² - 4ac
    return b ** 2 - 4 * a * c  

# Función para calcular una raíz de la ecuación cuadrática
def calcular_raiz(a, b, discriminante, positiva):
    # Si es verdadero, usamos la suma en la fórmula, si es negativo, usamos la resta
    return (-b + (math.sqrt(discriminante) if positiva else -math.sqrt(discriminante))) / (2 * a)

def resolver_ecuacion(a, b, c):
    discriminante = get_discriminante(a, b, c)

    if discriminante > 0:
        # Si el discriminante es positivo, hay dos soluciones reales
        raiz1 = calcular_raiz(a, b, discriminante, True)  # para positivo
        raiz2 = calcular_raiz(a, b, discriminante, False)  # para negativo
        print(f"La ecuación tiene dos raíces {raiz1:.6f} y {raiz2:.6f}")
    elif discriminante == 0:
        # Si el discriminante es 0, hay una única raíz real
        raiz = calcular_raiz(a, b, discriminante, True)  # Solo se calcula una raíz
        print(f"La ecuación tiene una raíz {raiz:.6f}")
    else:
        # Si el discriminante es negativo, no existen raíces reales
        print("La ecuación no tiene raíces reales.")

def main():
    a, b, c = map(float, input("Ingrese a, b, c: ").split())

    resolver_ecuacion(a, b, c)

# Punto de entrada del programa
if __name__ == "__main__":
    main()  
