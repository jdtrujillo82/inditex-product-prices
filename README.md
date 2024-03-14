1. Descargar el proyecto de GIT desde eclipse (con la versión jre de java 17)
 
		*Import proyect - Proyect from Git - clone uri (https://github.com/jdtrujillo82/inditex-product-prices)

2. Botón derecho sobre el proyecto "Run AS" - "Maven install" (esto ejecuta también los test). Realizarlo con la jre de java 17

3. Botón derecho sobre el proyecto "Maven" - "Update Project"

4. Botón derecho sobre el proyecto "Run AS" - "Spring Boot App". Realizarlo con la jre de java 17

5. Para probarlo usar el endpoint http://localhost:8080/inditex/productPrices con los parámetros obligatorios dateTime, productId y brandId

		*Por ejemplo: http://localhost:8080/inditex/productPrices?dateTime=2020-06-14T00:00:00Z&productId=35455&brandId=1