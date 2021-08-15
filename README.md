# home-account
Practica contabilidad domestica

Librerias utilizadas:

- lombok
- mapstruct

**Preparar eclipse**

Configurar lombok:

Tenemos que bajarnos un fichero jar de configuración de esta web:

https://projectlombok.org/download

Tenemos que ejecutar el jar que nos hemos descargado y tenemos que ejecutarlo.  Nos mostrará una lista con las versiones de eclipse que ha encontrado en nuestro equipo. Si nuestro eclipse no aparece, entonces tenemos que buscarlo manualmente con la opción "Specify location…".

Una vez tenemos localizado nuestra versión de eclipse tenemos que pulsar en "Install / update"


Configurar mpastruct

Para poder trabajar con mapStruct necesitamos instalarnos un plugin "m2e-apt plugin". Este plugin lo podemos instalar desde la market place. 

 ![image](https://user-images.githubusercontent.com/54493791/129456912-7f6413fe-756d-47db-9858-277863fae240.png)

Después de reiniciar eclipse tenemos que comprobar que se ha instalado correctamente. Dentro de Eclipse Marketplace tenemos que a la pestaña de installed y ver que nos aparece como instalado:

 ![image](https://user-images.githubusercontent.com/54493791/129456932-0abf3897-4700-4025-b368-a264dacdb065.png)
 
 Configurar el proyecto:
 
 Tenemos que ir a las propiedades del proyecto, en "Java Compiler / Annotation procesing" y activar los checks tal y como se muestra en la imagen.
 
 ![image](https://user-images.githubusercontent.com/54493791/129456989-4ba4b566-c198-4f1e-9448-120a73155b10.png)

Ahora tenemos que ir a "Maven / Annotation Processing" y tenemos que dejar la configuración tal y como se muestra a continuación:

![image](https://user-images.githubusercontent.com/54493791/129457041-e4a7fd8c-83b9-484a-859e-c50bf770bdb1.png)

Tenemos que tener instalado el servidor de MySql y modificar el fichero application.properties para establecer los parametros de la conexión.



