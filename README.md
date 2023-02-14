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
    
    Nota: En el caso de las excepciones, se da por sentado que si no botó las excepciones (validadas desde el inicio) por defecto se sabe que no cumplen las condiciones necesarias para que haya error. Por ejemplo: Si se ingresa al caso donde hay descuento por ser menor de edad, entonces la tarifa debe ser mayor a 0. Por tal motivo, no consideramos necesario escribirlo explícitamente.

    
3. Casos de prueba clases de equivalencia

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

| Número condición de frontera | Variable | Límite inferior | Límite superior | Número de clase de equivalencia |
|---|-----|---|-----|----|
| 1 | tarifaBase | -&#8734; | 0 | 1 |
| 2 | diasAntelacion | -&#8734; | -1 | 2 |
| 3 | edad | -&#8734; | 0 | 3 |
| 4 | edad | 121 | &#8734; | 3 |
| 5 | diasAntelacion | 21 | &#8734; | 4, 8 y 9 |
| 6 | edad | 1 | 17 | 5 y 8|
| 7 | edad | 66 | 120 | 6 7 9 |
| 8 | diasAntelacion | 0 | 20 | 7 |
| 9 | edad | 18 | 65 | 7 |
| 10 | tarifaBase | 1 | &#8734; | Cualquiera menos 1 |
  
Nota: Los infinitos los usamos porque no sabemos el rango que se implementará para esos parámetros.

5. Casos de prueba para condiciones límite

    1. -&#8734; < tarifaBase <= 0
        - Entrada: tarifaBase = -5, diasAntelacion = 5, edad = 30
        - Salida: ExcepcionParametrosInvalidos / Tarifa negativa 
    2. -&#8734; < diasAntelacion <= -1
        - Entrada: tarifaBase = $ 70.000, diasAntelacion = -5, edad = 30
        - Salida: ExcepcionParametrosInvalidos / Días de antelación negativos
    3.   < edad < &#8734;
        - Entrada: tarifaBase = $ 70.000, diasAntelacion = 5, edad = -30
        - Salida: ExcepcionParametrosInvalidos / Edad negativa 
    4.  121 <= edad < &#8734;
        - Entrada: tarifaBase = $ 70.000, diasAntelacion = 5, edad = 130
        - Salida: ExcepcionParametrosInvalidos / Edad negativa
    5.  21 <= diasAntelacion < &#8734;
        - Entrada: tarifaBase = $ 70.000, diasAntelacion = 100, edad = 30
        - Salida: $ 59.500 / 15% de descuento
    6.  1 <= edad <= 17
        - Entrada: tarifaBase = $ 70.000, diasAntelacion = 3, edad = 15
        - Salida: $ 66.500 / 5% de descuento
    7.  66 <= edad <= 120;
        - Entrada: tarifaBase = $ 70.000, diasAntelacion = 3, edad = 70
        - Salida: $ 64.400 / 8% de descuento
    8.  0 <= diasAntelacion <= 20;
        - Entrada: tarifaBase = $ 70.000, diasAntelacion = 3, edad = 30
        - Salida: $ 70.000 / Sin descuento
    9.  18 <= edad <= 65;
        - Entrada: tarifaBase = $ 70.000, diasAntelacion = 3, edad = 30
        - Salida: $ 70.000 / Sin descuento
    10.  1 <= tarifaBase < &#8734;
        - Entrada: tarifaBase = $ 70.000, diasAntelacion = 50, edad = 17
        - Salida: $ 56.000 / 20% de descuento
    
