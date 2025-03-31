import math

# Función para calcular el promedio de una lista de números
def promedio(numeros):
    # Se suman todos los valores en la lista y se dividen entre la cantidad de elementos
    return sum(numeros) / len(numeros)

# Función para calcular la desviación estándar de un conjunto de números
def desviacion(numeros, promedio):
    # Se calcula la diferencia de cada número con el promedio, se eleva al cuadrado y se suma
    return math.sqrt(sum((num - promedio) ** 2 for num in numeros) / (len(numeros) - 1))

def main():
    # ingrese 10 numeros
    numeros = list(map(float, input().split()))
    
    # verifica si son 10 o no
    if len(numeros) != 10:
        print("Debe ingresar exactamente 10 números.")
        return
    
    # Se calcula el promedio y la desviación estándar
    prom = promedio(numeros)
    desv = desviacion(numeros, prom)

    # Se muestran los resultados con el formato adecuado
    print(f"El promedio es {prom:.2f}")
    print(f"La desviación estándar es {desv:.6f}")

# Punto de entrada del programa
if __name__ == "__main__":
    main()
