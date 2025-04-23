# language: es
@ConsultaPosts
Característica: Consultar posts en Gorest

  Escenario: Consultar post por ID válido
    Dado configuro el parámetro "id" con valor 204861
    Cuando realizo una solicitud GET a /posts
    Entonces el código de respuesta debe ser 200
    Y la respuesta debe contener el campo "id" con valor 204861
    Y validar el esquema JSON de respuesta

  Escenario: Consultar posts por user_id
    Dado configuro el parámetro "user_id" con valor 7848321
    Cuando realizo una solicitud GET a /posts
    Entonces el código de respuesta debe ser 200
    Y todos los posts deben tener "user_id" igual a 7848321

  Escenario: Buscar posts por fragmento de título
    Dado configuro el parámetro "title" con valor "Crebro fugiat"
    Cuando realizo una solicitud GET a /posts
    Entonces el código de respuesta debe ser 200
    Y todos los "title" deben contener "Crebro fugiat"

  Escenario: Buscar posts por fragmento de cuerpo
    Dado configuro el parámetro "body" con valor "Conor coniecto"
    Cuando realizo una solicitud GET a /posts
    Entonces el código de respuesta debe ser 200
    Y todos los "body" deben contener "Conor coniecto"