basepath=$(cd `dirname $0`; pwd)
echo $basepath

../mvnw install:install-file  -DgroupId=com.taobao -DartifactId=alidayu -Dversion=2.0.1 -Dpackaging=jar -Dfile=$basepath/taobao-sdk-java-2.0.1.jar
# install godai
../mvnw install:install-file  -DgroupId=io.goudai -DartifactId=gd-generator-api -Dversion=2.0.4 -Dpackaging=jar -Dfile=$basepath/gd-generator-api-2.0.4.jar
../mvnw install:install-file  -DgroupId=io.goudai -DartifactId=gd-generator-default -Dversion=2.0.4 -Dpackaging=jar -Dfile=$basepath/gd-generator-default-2.0.4.jar
# install alipay
../mvnw install:install-file -DgroupId=com.alipay -DartifactId=sdk-java -Dversion=20180309170622 -Dpackaging=jar -Dfile=$basepath/alipay-sdk-java20180309170622.jar
    ../mvnw install:install-file -DgroupId=com.taobao -DartifactId=taobao-sdk-java-auto_1535298409962 -Dversion=20180830 -Dpackaging=jar -Dfile=lib/taobao-sdk-java-auto_1535298409962-20180830.jar
