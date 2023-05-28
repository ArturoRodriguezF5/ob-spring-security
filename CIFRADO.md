## Cifrado

Es el proceso de codificar la informacion de su representacion original (text plano)
a texto cifrado, de manera que solamente pueda ser decifrado utilizando una clave.

Historia delñ cifrado:

1. Almacenar constraseñas en texto plano
2. Almacenar contraseñas cifradas con una funcion hash
3. Almacenar contraseñas cifradas con una funcion hash + salt
4. Almacenar contraseñas cifradas con una funcion adaptativa + factor de trabajo

La seguridad se gana haciendo que la validacion de contraseña sea costosa computacionalmente.

## Algoritmos en Spring Security

* BCrypt
* PBKDF2
* scrypt
* argon2