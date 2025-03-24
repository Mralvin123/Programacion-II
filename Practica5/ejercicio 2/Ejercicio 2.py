import math

def promedio(numeros):
    return sum(numeros) / len(numeros)

def desviacion(numeros, promedio):
    return math.sqrt(sum((num - promedio) ** 2 for num in numeros) / (len(numeros) - 1))

def main():
    numeros = list(map(float, input().split()))
    
    if len(numeros) != 10:
        print()
        return
    
    prom = promedio(numeros)
    desv = desviacion(numeros, prom)

    print(f"El promedio es {prom:.2f}")
    print(f"La desviación estándar es {desv:.6f}")

if __name__ == "__main__":
    main()
