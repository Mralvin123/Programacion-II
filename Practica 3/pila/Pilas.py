class Pila:
    def __init__(self, n: int):  
        self.__n = n
        self.__arreglo = [0] * n
        self.__top = -1

    def push(self, e: int):
        if self.is_full():
            print(f"Pila llena! No se pudo agregar {e}")
            return
        self.__top += 1
        self.__arreglo[self.__top] = e
        print(f"Elemento añadido: {e}, Pila actual: {self.__arreglo[:self.__top + 1]}")  # Depuración

    def pop(self) -> int:
        if self.is_empty():
            print("Pila vacía! No se puede eliminar.")
            return -1
        elemento = self.__arreglo[self.__top]
        self.__top -= 1
        print(f"Elemento eliminado: {elemento}, Pila actual: {self.__arreglo[:self.__top + 1]}")  # Depuración
        return elemento

    def peek(self) -> int:
        if self.is_empty():
            print("Pila vacía! No hay elementos en la cima.")
            return -1
        return self.__arreglo[self.__top]

    def is_empty(self) -> bool:
        return self.__top == -1

    def is_full(self) -> bool:
        return self.__top >= self.__n - 1 

if __name__ == "__main__":
    pila = Pila(6) 
    for num in [10, 20, 30, 40, 50, 60, 70, 80]:
        pila.push(num)

    print(f"Elemento eliminado: {pila.pop()}")
    print(f"Elemento en la cima: {pila.peek()}")
