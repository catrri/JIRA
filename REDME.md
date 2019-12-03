Для запуска проекта необходимо установить:

1. Java 8
2. JDK - Java SE Development Kit 8.
3. IntelliJ IDEA Community Edition 2019.1.3
4. Google Chrome 78.0.3904.87



Подключение Allure:

1. Обновить pom.xml
Allure-testng dependency
     <dependency>
         <groupId>io.qameta.allure</groupId>
         <artifactId>allure-testng</artifactId>
         <version>2.12.0</version>
     </dependency>   

Добавить properties
         <properties>
             <aspectj.version>1.8.10</aspectj.version>
             <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
         </properties>  
   
Добавить plugins
     <build>
         <plugins>
             <plugin>
                 <groupId>org.apache.maven.plugins</groupId>
                 <artifactId>maven-compiler-plugin</artifactId>
                 <configuration>
                     <source>1.8</source>
                     <target>1.8</target>
                 </configuration>
             </plugin>
             <plugin>
                 <groupId>org.apache.maven.plugins</groupId>
                 <artifactId>maven-surefire-plugin</artifactId>
                 <version>2.20</version>
                 <configuration>
                     <suiteXmlFiles>
                         <suiteXmlFile>TestNG.xml</suiteXmlFile>
                     </suiteXmlFiles>
                     <argLine>
                         -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                     </argLine>
                 </configuration>
                 <dependencies>
                     <dependency>
                         <groupId>org.aspectj</groupId>
                         <artifactId>aspectjweaver</artifactId>
                         <version>${aspectj.version}</version>
                     </dependency>
                 </dependencies>
             </plugin>
         </plugins>
     </build>  
2. В тесты добавить @Feature
3. Установить Allure CLI. Прописать переменные Allure и Path в среде  https://docs.qameta.io/allure/#_installing_a_commandline 
4. Запустить тесты mvn clean test
5. Выполнить в корне проекта консольную команду "allure generate --clean"
