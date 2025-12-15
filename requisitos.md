# Objetivos del Sistema

El software solicitado por el Centro Excursionista Carlemany (CEC) tiene como propósito principal
gestionar de manera eficiente la información relacionada con montañas, expediciones y expedicionarios.
Los objetivos específicos del sistema son los siguientes:

## Objetivo General

Desarrollar una aplicación en Java, basada en interacción por texto, que permita administrar y consultar
los datos operativos de las actividades del CEC durante la ejecución del programa, sin necesidad de
persistencia en disco.

## Objetivos Específicos

- **O1.** Gestionar un catálogo de montañas disponible para su uso en futuras expediciones.
- **O2.** Registrar y consultar expedicionarios, clasificándolos según su rol (alpinistas o médicos).
- **O3.** Permitir registrar expediciones, asociarlas a montañas y gestionar los participantes.
- **O4.** Registrar para cada alpinista si logró la cima en una expedición específica.
- **O5.** Facilitar la consulta de información relevante sobre expediciones, participantes y cimas alcanzadas.
- **O6.** Mantener la integridad de los datos en tiempo de ejecución, evitando inconsistencias.
- **O7.** Proveer una interfaz textual simple, clara y accesible para los usuarios no técnicos del centro.
- **O8.** Garantizar que el sistema funcione adecuadamente en máquinas con recursos limitados del CEC.
- **O9.** Cumplir con las restricciones técnicas impuestas por el centro (uso de Java y no instalar software adicional).

---

# Identificación de Stakeholders

### 2.1 Lista de Stakeholders

| Stakeholder                      | Rol o Interés                                                                       | Responsabilidades                                                                                                                                                                           | Interacción con el Sistema                                                      |
|----------------------------------|-------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------|
| **Dirección del CEC**            | Garantizar el correcto funcionamiento del centro y toma de decisiones estratégicas. | Establecer requisitos principales y validar objetivos del proyecto.                                                                                                                         | Revisión de informes y funcionalidades desarrolladas.                           |
| **Personal administrativo**      | Gestión documental y logística interna.                                             | Registrar expediciones, añadir participantes, actualizar información operativa, registrar expedicionarios, gestionar catálogos, realizar consultas de información histórica (en ejecución). | Uso diario del sistema para tareas administrativas.                             |
| **Expedicionarios (alpinistas)** | Participantes en expediciones.                                                      | Proveer datos personales y de participación.                                                                                                                                                | Su información es visualizada y gestionada, pero no interactúan con el sistema. |
| **Expedicionarios (médicos)**    | Acompañan expediciones para garantizar la seguridad.                                | Proveer datos personales y profesionales.                                                                                                                                                   | Su información es visualizada y gestionada, sin uso directo.                    |
| **Equipo de desarrollo**         | Encargados de construir, probar y entregar el software.                             | Analizar, diseñar, implementar y probar el sistema.                                                                                                                                         | Interacción técnica durante el desarrollo, no durante la operación.             |
| **Equipo de TI del CEC**         | Mantenimiento básico del software en las máquinas del centro.                       | Ejecutar el programa, reportar fallos y necesidades de mejora.                                                                                                                              | Operación y soporte técnico básico.                                             |

---

# Requisitos Funcionales (RF)

> Nota: Para cada requisito marco:
> A = Abstracto, NA = No ambiguo, T = Trazable, V = Validable. (Sí/No)

### RF-01 – Gestión de montañas

| Id    | Descripción                                                                                          | A  | NA | T  | V  |
|-------|------------------------------------------------------------------------------------------------------|----|----|----|----|
| RF-01 | El sistema permitirá registrar nuevas montañas como entidades independientes.                        | Sí | Sí | Sí | Sí |
| RF-02 | El sistema permitirá actualizar los datos de una montaña ya existente, a partir de su identificador. | Sí | Sí | Sí | Sí |
| RF-03 | El sistema permitirá buscar una montaña por identificador.                                           | Sí | Sí | Sí | Sí |

---

### RF-02 – Gestión del catálogo de montañas

| Id    | Descripción                                                                                      | A  | NA | T  | V  |
|-------|--------------------------------------------------------------------------------------------------|----|----|----|----|
| RF-04 | El sistema permitirá añadir y quitar montañas del catálogo.                                      | Sí | Sí | Sí | Sí |
| RF-05 | El sistema permitirá consultar el listado completo de montañas disponibles en el catálogo.       | Sí | Sí | Sí | Sí |
| RF-06 | El sistema permitirá añadir los alpinistas que alcanzaron la cima.                               | Sí | Sí | Sí | Sí |
| RF-07 | El sistema permitirá consultar los alpinistas que han logrado la cima de una montaña específica. | Sí | Sí | Sí | Sí |

---

### RF-03 – Gestión de expedicionarios (alpinistas / médicos)

| Id    | Descripción                                                                                         | A  | NA | T  | V  |
|-------|-----------------------------------------------------------------------------------------------------|----|----|----|----|
| RF-08 | El sistema permitirá registrar expedicionarios con un identificador y su rol (alpinista o médico).  | Sí | No | Sí | No |
| RF-09 | El sistema permitirá consultar la lista de expedicionarios registrados.                             | Sí | Sí | Sí | Sí |
| RF-10 | El sistema permitirá consultar la ficha completa de un expedicionario a partir de su identificador. | Sí | Sí | Sí | Sí |

---

### RF-04 – Gestión de expediciones

| Id    | Descripción                                                                                        | A  | NA | T  | V  |
|-------|----------------------------------------------------------------------------------------------------|----|----|----|----|
| RF-11 | El sistema permitirá registrar una expedición asociándola a una montaña disponible en el catálogo. | Sí | Sí | Sí | Sí |
| RF-12 | El sistema permitirá registrar la fecha de una expedición.                                         | Sí | No | Sí | No |
| RF-13 | El sistema permitirá añadir expedicionarios participantes en una expedición.                       | Sí | Sí | Sí | Sí |
| RF-14 | El sistema permitirá registrar si se alcanzó la cima en una expedición.                            | Sí | Sí | Sí | Sí |
| RF-15 | El sistema asegurará que al menos un médico asista a la expedición.                                | Sí | Sí | Sí | Sí |

---

### RF-05 – Consultas sobre participaciones y cimas

| Id    | Descripción                                                                                               | A  | NA | T  | V  |
|-------|-----------------------------------------------------------------------------------------------------------|----|----|----|----|
| RF-16 | El sistema permitirá consultar, para un expedicionario, todas las expediciones en las que ha participado. | Sí | Sí | Sí | Sí |
| RF-17 | El sistema permitirá consultar, para cada expedición, si se alcanzó la cima.                              | Sí | Sí | Sí | Sí |
| RF-18 | El sistema permitirá consultar el listado de participantes de una expedición concreta.                    | Sí | Sí | Sí | Sí |

---

### RF-06 – Interfaz de Usuario

| Id    | Descripción                                                      | A  | NA | T  | V  |
|-------|------------------------------------------------------------------|----|----|----|----|
| RF-19 | El sistema ofrecerá un menú de interacción basado en texto.      | Sí | Sí | Sí | Sí |
| RF-20 | La navegabilidad del menú será númerica.                         | Sí | Sí | Sí | Sí |
| RF-21 | El sistema requerirá de una contraseña para acceder al software. | Sí | Sí | Sí | Sí |

---

## 2. Requisitos de Calidad (RQ)

### RQ-01 – Usabilidad

| Id    | Descripción                                                                  | A  | NA | T  | V  |
|-------|------------------------------------------------------------------------------|----|----|----|----|
| RQ-01 | La interfaz debe ser fácilmente utilizable mediante texto únicamente.        | Sí | No | Sí | No |
| RQ-02 | Las operaciones principales deben poder completarse de forma clara y guiada. | Sí | No | Sí | No |

---

### RQ-02 – Fiabilidad lógicas

> Dado que no hay almacenamiento permanente, los requisitos se centran únicamente en garantizar consistencia durante la
> ejecución.

| Id    | Descripción                                                                                         | A  | NA | T  | V  |
|-------|-----------------------------------------------------------------------------------------------------|----|----|----|----|
| RQ-03 | El sistema deberá evitar duplicados en identificadores de montañas, expedicionarios y expediciones. | Sí | Sí | Sí | Sí |

---

### RQ-03 – Rendimiento

| Id    | Descripción                                                                  | A  | NA | T  | V  |
|-------|------------------------------------------------------------------------------|----|----|----|----|
| RQ-04 | El sistema debe funcionar eficientemente en máquinas con recursos limitados. | Sí | No | Sí | No |

---

### RQ-04 – Mantenibilidad

| Id    | Descripción                                                                  | A  | NA | T  | V  |
|-------|------------------------------------------------------------------------------|----|----|----|----|
| RQ-05 | El código deberá estar estructurado en módulos separados (modelo, interfaz). | Sí | Sí | Sí | Sí |

---

## 3. Restricciones (RC)

### RC-01 – Tecnológicas

| Id    | Descripción                                                                         | A  | NA | T  | V  |
|-------|-------------------------------------------------------------------------------------|----|----|----|----|
| RC-01 | El sistema debe implementarse en Java.                                              | Sí | Sí | Sí | Sí |
| RC-02 | El sistema debe ejecutarse en el entorno Java existente en las máquinas del Centro. | Sí | No | Sí | No |

---

### RC-02 – Dependencias

| Id    | Descripción                                                                               | A  | NA | T  | V  |
|-------|-------------------------------------------------------------------------------------------|----|----|----|----|
| RC-03 | No se podrá instalar ningún software adicional más allá del propio programa desarrollado. | Sí | No | Sí | No |
| RC-04 | El sistema no deberá requerir bases de datos externas ni servicios de terceros.           | Sí | Sí | Sí | Sí |
| RC-05 | El sistema no deberá utilizar ninguna librería externa.                                   | Sí | Sí | Sí | Sí |

---

## 4. Preguntas pendientes

1. (RESUELTO) ¿Eliminar montañas significa borrado total o desactivación? -> Solo se permite quitar del catálogo,
   ninguna entidad se elimina.
2. (RESUELTO) ¿Un expedicionario puede tener ambos roles: alpinista y médico? - No, o son alpinistas o son médicos
3. ¿Qué datos mínimos debe tener una expedición además de la fecha?
   Id: String;nombre: String;fechaInicio: Date;fechaFin: Date;destino; Montana; Inscripciones: list<Inscripción>

5. (RESUELTO) ¿Las montañas pueden existir sin estar añadidas a un catálogo? -> Sí, son entidades independientes.

---
