class Cola:
    def __init__(self, n: int):
        self.__n = n
        self.__arreglo = [0] * n
        self.__inicio = 0
        self.__fin = -1
        self.__size = 0

    def insert(self, e: int):
        if self.is_full():
            print(f"Cola llena! No se pudo agregar {e}")
            return
        self.__fin = (self.__fin + 1) % self.__n
        self.__arreglo[self.__fin] = e
        self.__size += 1
        print(f"Elemento añadido: {e}, Cola actual: {self.__arreglo[self.__inicio:self.__fin + 1]}")

    def remove(self) -> int:
        if self.is_empty():
            print("Cola vacía! No se puede eliminar.")
            return -1
        elemento = self.__arreglo[self.__inicio]
        self.__inicio = (self.__inicio + 1) % self.__n
        self.__size -= 1
        print(f"Elemento eliminado: {elemento}, Cola actual: {self.__arreglo[self.__inicio:self.__fin + 1]}")
        return elemento

    def peek(self) -> int:
        if self.is_empty():
            print("Cola vacía! No hay elementos en la cima.")
            return -1
        return self.__arreglo[self.__inicio]

    def is_empty(self) -> bool:
        return self.__size == 0

    def is_full(self) -> bool:
        return self.__size == self.__n

    def size(self) -> int:
        return self.__size


if __name__ == "__main__":
    cola = Cola(5)
    for num in [10, 20, 30, 40, 50, 60]:
        cola.insert(num)

    print(f"Elemento eliminado: {cola.remove()}")
    print(f"Elemento en la cima: {cola.peek()}")
