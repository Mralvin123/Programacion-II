import math

def get_discriminante(a, b, c):
    return b ** 2 - 4 * a * c

def calcular_raiz(a, b, discriminante, positiva):
    return (-b + (math.sqrt(discriminante) if positiva else -math.sqrt(discriminante))) / (2 * a)

def resolver_ecuacion(a, b, c):
    discriminante = get_discriminante(a, b, c)

    if discriminante > 0:
        raiz1 = calcular_raiz(a, b, discriminante, True)
        raiz2 = calcular_raiz(a, b, discriminante, False)
        print(f"La ecuación tiene dos raíces {raiz1:.6f} y {raiz2:.6f}")
    elif discriminante == 0:
        raiz = calcular_raiz(a, b, discriminante, True)
        print(f"La ecuación tiene una raíz {raiz:.6f}")
    else:
        print("La ecuación no tiene raíces reales.")

def main():
    a, b, c = map(float, input("Ingrese a, b, c: ").split())
    resolver_ecuacion(a, b, c)

if __name__ == "__main__":
    main()
