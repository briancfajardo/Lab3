# Lab3
## AeroDescuentos
### Integrantes: Camilo Fajardo, Andrea Durán

1. Los casos en los que se debería arrojar una excepción de tipo ExcepcionParametrosInvalidos son:

    - Tarifa menor o igual a 0
    - Días de antelación negativos
    - Edad menor o igual a 0, o mayor a 120 años


2. Tabla de clases de equivalencia

    | Número | Clases de equivalencia| Resultado correcto / incorrecto|
    |--------|-------|----|
    | 1 | Tarifa menor o igual a 0 | Incorrecto/ @throws ExcepcionParametrosInvalidos |
    |2| Días de antelación  negativos| Incorrecto/ @throws ExcepcionParametrosInvalidos |
    |3| Edad menor o igual a 0, o mayor a 120 años| Incorrecto/ @throws ExcepcionParametrosInvalidos |
    |4| Días de antelación mayor a 20| Correcto / 15% de descuento|
    |5| Edad menor a 18 | Correcto / 5% de descuento|
    |6| Edad mayor a 65 | Correcto / 8% de descuento|
    |7| Días de antelación menor a 20 y edad mayor a 18 y edad menor a 65 | Correcto sin descuento|
    |8| Días de antelación mayor a 20 y edad menor a 18 | Correcto / 20% de descuento|
    |9 | Días de antelación mayor a 20 y edad mayor a 65| Correcto / 23% de descuento|

    
3. Casos de prueba

    1. Tarifa menor o igual a 0:
        - Entrada: tarifaBase = - $ 580.000, diasAntelacion = 45, edad = 30
        - Salida: ExcepcionParametrosInvalidos / Tarifa negativa
    2. Días de antelación  negativos
        - Entrada: tarifaBase =  $ 580.000, diasAntelacion = -45, edad = 30
        - Salida: ExcepcionParametrosInvalidos / Días de antelación negativos
    3. Edad menor o igual a 0, o mayor a 120 años
        - Entrada: tarifaBase =  $ 580.000, diasAntelacion = 45, edad = 0
        - Salida: ExcepcionParametrosInvalidos / Edad invalida
    4. Días de antelación mayor a 20
        - Entrada: tarifaBase =  $ 580.000, diasAntelacion = 45, edad = 30
        - Salida: $493.000 / Con 15% de descuento
    5. Edad menor a 18
        - Entrada: tarifaBase =  $ 580.000, diasAntelacion = 10, edad = 15
        - Salida: $551.000 / Con 5% de descuento
    6. Edad mayor a 65
        - Entrada: tarifaBase =  $ 580.000, diasAntelacion = 10, edad = 70
        - Salida: $533.600 / Con 8% de descuento
    7. Días de antelación menor a 20 y edad mayor a 18 y edad menor a 65
        - Entrada: tarifaBase =  $ 580.000, diasAntelacion = 45, edad = 20
        - Salida: $580.000 / Sin descuento
    8. Días de antelación mayor a 20 y edad menor a 18
        - Entrada: tarifaBase =  $ 580.000, diasAntelacion = 45, edad = 15
        - Salida: $464.000 / Con 20% de descuento
    9.  Días de antelación mayor a 20 y edad mayor a 65
        - Entrada: tarifaBase =  $ 580.000, diasAntelacion = 45, edad = 80
        - Salida: $446.600 / Con 23% de descuento

4. Condiciones límite

|Variable | Límite inferior | Límite superior | Número de clase de equivalencia |
|-----|---|-----|----|
|Tarifa| -&#8734; | 0 | 1 |
| Días Antelación | -&#8734 | -1 | 2 |
| Edad | -&#8734; | 0 | 3 |
| Edad | 121 | &#8734; | 3 |
| Días Antelación | 21 | -&#8734 | 4, 8 y 9 |
| Edad | 1 | 17 | 5 y 8|
| Edad | 66 | 120 | 6 7 9 |
| Días Antelación | 0 | 19 | 7 |
| Edad | 18 | 65 | 7 |


5. Casos de prueba para condiciones límite

    1. Edad 
