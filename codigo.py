class Persona:
    def __init__(self, nombre, id):
        self.nombre = nombre
        self.id = id

    def get_nombre(self):
        return self.nombre

    def get_id(self):
        return self.id


class Calificable:
    def calcular_promedio(self):
        raise NotImplementedError


class Pagable:
    def calcular_pago(self):
        raise NotImplementedError


class Estudiante(Persona, Calificable):
    def __init__(self, nombre, id):
        super().__init__(nombre, id)
        self.calificaciones = []

    def agregar_calificacion(self, calificacion):
        self.calificaciones.append(calificacion)

    def calcular_promedio(self):
        if not self.calificaciones:
            raise RuntimeError("No hay calificaciones registradas.")
        return sum(self.calificaciones) / len(self.calificaciones)


class ProfesorPorHoras(Persona, Pagable):
    def __init__(self, nombre, id, horas_trabajadas, pago_por_hora):
        super().__init__(nombre, id)
        self.horas_trabajadas = horas_trabajadas
        self.pago_por_hora = pago_por_hora

    def calcular_pago(self):
        return self.horas_trabajadas * self.pago_por_hora


class ProfesorTiempoCompleto(Persona, Pagable):
    def __init__(self, nombre, id, salario_mensual):
        super().__init__(nombre, id)
        self.salario_mensual = salario_mensual

    def calcular_pago(self):
        return self.salario_mensual


class Clase:
    def __init__(self, nombre_curso, profesor_asignado):
        self.nombre_curso = nombre_curso
        self.profesor_asignado = profesor_asignado


# Programa principal
estudiantes = []
profesores = []
cursos = []


def buscar_estudiante(id):
    for e in estudiantes:
        if e.get_id() == id:
            return e
    raise RuntimeError("Estudiante no encontrado.")


def registrar_estudiante():
    nombre = input("Nombre: ")
    id = int(input("ID: "))
    estudiantes.append(Estudiante(nombre, id))
    print("Estudiante registrado.")


def registrar_profesor_por_horas():
    nombre = input("Nombre: ")
    id = int(input("ID: "))
    horas = int(input("Horas trabajadas: "))
    pago_hora = float(input("Pago por hora: "))
    profesores.append(ProfesorPorHoras(nombre, id, horas, pago_hora))
    print("Profesor por horas registrado.")


def registrar_profesor_tiempo_completo():
    nombre = input("Nombre: ")
    id = int(input("ID: "))
    salario = float(input("Salario mensual: "))
    profesores.append(ProfesorTiempoCompleto(nombre, id, salario))
    print("Profesor tiempo completo registrado.")


def registrar_curso():
    nombre_curso = input("Nombre del curso: ")
    profesor = input("Profesor asignado: ")
    cursos.append(Clase(nombre_curso, profesor))
    print("Curso registrado.")


def agregar_calificacion():
    id = int(input("ID del estudiante: "))
    e = buscar_estudiante(id)
    calificacion = float(input("Calificación: "))
    e.agregar_calificacion(calificacion)
    print("Calificación agregada.")


def calcular_promedio():
    id = int(input("ID del estudiante: "))
    e = buscar_estudiante(id)
    print("Promedio:", e.calcular_promedio())


def calcular_pago():
    id = int(input("ID del profesor: "))
    for p in profesores:
        if p.get_id() == id and isinstance(p, Pagable):
            print("Pago:", p.calcular_pago())
            return
    raise RuntimeError("Profesor no encontrado o no implementa Pagable.")


def mostrar_estudiantes():
    if not estudiantes:
        print("No hay estudiantes registrados.")
    else:
        print("Estudiantes:")
        for e in estudiantes:
            print(f"ID: {e.get_id()} - Nombre: {e.get_nombre()}")


def mostrar_profesores():
    if not profesores:
        print("No hay profesores registrados.")
    else:
        print("Profesores:")
        for p in profesores:
            print(f"ID: {p.get_id()} - Nombre: {p.get_nombre()}")


def mostrar_cursos():
    if not cursos:
        print("No hay cursos registrados.")
    else:
        print("Cursos:")
        for c in cursos:
            print(f"Curso: {c.nombre_curso} - Profesor: {c.profesor_asignado}")


def main():
    while True:
        print("\n--- MENÚ DE GESTIÓN DE CURSOS ---")
        print("1. Registrar estudiante")
        print("2. Registrar profesor por horas")
        print("3. Registrar profesor tiempo completo")
        print("4. Registrar curso")
        print("5. Agregar calificación a estudiante")
        print("6. Calcular promedio de estudiante")
        print("7. Calcular salario de profesor")
        print("8. Salir")
        print("9. Mostrar estudiantes")
        print("10. Mostrar profesores")
        print("11. Mostrar cursos")
        try:
            opcion = int(input("Seleccione una opción: "))
            if opcion == 1:
                registrar_estudiante()
            elif opcion == 2:
                registrar_profesor_por_horas()
            elif opcion == 3:
                registrar_profesor_tiempo_completo()
            elif opcion == 4:
                registrar_curso()
            elif opcion == 5:
                agregar_calificacion()
            elif opcion == 6:
                calcular_promedio()
            elif opcion == 7:
                calcular_pago()
            elif opcion == 8:
                print("Saliendo...")
                break
            elif opcion == 9:
                mostrar_estudiantes()
            elif opcion == 10:
                mostrar_profesores()
            elif opcion == 11:
                mostrar_cursos()
            else:
                print("Opción inválida.")
        except Exception as e:
            print("Error:", e)


if __name__ == "__main__":
    main()