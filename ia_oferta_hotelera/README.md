
Agregar modulo MySQL:
- Instalar MySQL
- Descargar el conector JDBC de MySQL (https://dev.mysql.com/downloads/connector/j/5.1.html)
- Entrar en la consola de configuración de WildFly
- Ir a Deployments -> Add
- Seleccionar "Upload a new deployment"
- Seleccionar el jar del connector JDBC de MySQL
- Finish
- Reiniciar WildFly

Configurar el Datasource:
- Configuration -> Subsystems -> Datasources -> Non-XA -> Add
- MySQL Datasource
- Name: PWDS
- JNDI Name: java:/PWDS
- Seleccionar el driver de MySQL en Detected Driver
- Connection URL: jdbc:mysql://localhost:3306/NOMBRE_BASE_DE_DATOS
- Ingresar Username y Password de MySQL
- Test Connection para verificar que todo esta bien -> Done

Configurar queues JMS:
- Configuration -> Subsystems -> Messaging (HornetQ) -> View -> default -> Destinations
- Queues -> Add
	* Name: OfertasHotel
	* JNDI Name: java:/jms/queue/ofertasHotel; java:jboss/exported/jms/queue/ofertasHotel
	* Durable: true
- Queues -> Add
	* Name: OfertasPaquete
	* JNDI Name: java:/jms/queue/ofertasPaquete; java:jboss/exported/jms/queue/ofertasPaquete
	* Durable: true
