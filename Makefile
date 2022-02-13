all:
	../../bin/catalina.sh stop
	javac --release 16 -cp ../../lib/servlet-api.jar:WEB-INF/lib/sqlite-jdbc-3.36.0.3.jar:WEB-INF/lib/ST-4.3.1.jar:WEB-INF/lib/antlr.jar:WEB-INF/lib/jsoup-1.14.3.jar WEB-INF/src/*/*.java -d WEB-INF/classes
	../../bin/catalina.sh run
