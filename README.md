
# Compilar y ejecutar el proyecto

Para copilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio *Desafio_Uno* ejecutar el siguiente comando *maven*

```bash
mvn package
```

Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar .\api-fechas-0.0.1-SNAPSHOT.jar
```
*Nota*:
Debe estar disponible el puerto *9091* en el PC donde se ejecute esta API

# Visualizar Documentación y consumir la API

La documentación swagger del API (una vez que se levanta el API) queda disponible en

http://127.0.0.1:9091/swagger-ui.html

Para consumir el servicio se debe invocar la siguiente URL

```bash
curl -X GET --header 'Accept: application/json' 'http://127.0.0.1:9091/apiFecha/generarFechasFaltantes/'
```

*Nota*:
Para que pueda funcionar se debe desplegar tambien el api "Generador_Datos_Desafio_Uno" para ello seguir las instrucciones que estan en este repositorio https://github.com/previred/Generador_Datos_Desafio_Uno
Al hacer un llamado al api se crea un archivo con la respuesta llamado "outputfile.json" dentro de la carpeta del proyecto "Desafio_Uno"