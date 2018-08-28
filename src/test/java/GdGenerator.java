import io.gd.generator.Config;
import io.gd.generator.Generator;
import io.gd.generator.handler.*;

import java.nio.file.Paths;

/**
 * @author chenyongqdu@foxmail.com
 */
public class GdGenerator {


    public static void main(String[] args) throws Exception {
        Config config = new Config();
        config.setGenLogFile(Paths.get(System.getProperty("user.home") , "cateye.log").toString());
//        config.setUrl("jdbc:mysql://127.0.0.1:3306/spkitty");
        config.setUrl("jdbc:mysql://211.157.159.69:3306/spkitty");
        config.setEntityPackage("com.flyoil.cateye.entity.local");
        config.setMybatisMapperPackage("com.flyoil.cateye.dao");

        //D:\\Work\\Workspace\\xx-parent
        //Users/freeman/IdeaProjects/xxx-parent
       String projectPath = System.getProperties().get("user.dir") +"";
 //       String projectPath = "/Users/chenyong/gitrepo/xx-project/spkitty";

        System.out.println("projectPath: " + projectPath);
        //xxx-service-impl\\src\\main\\java\\com\\xx\\mapper & windows
        //xxx-service-impl/src/main/java/com/xx/mapper & mac or linux
        config.setMybatisMapperPath(projectPath + "/src/main/java/com/flyoil/cateye/dao");

        //\\xx-service-impl\\src\\main\\resources\\com\\xx\\mapping & windows
        //\\xx-service-impl/src/main/resources/com/xx/mapping & mac or linux
        config.setMybatisXmlPath(projectPath + "/src/main/resources/mapper");
        config.setUsername("root");
//        config.setPassword("123456");
        config.setPassword("5c15faccacf44346b725c39d79e02b73");

        // is use lombok default : true
        config.setUseLombok(true);
        //com.xx.model.query
        config.setQueryModelPackage("com.flyoil.cateye.model.query");
        //\\xx-service\\src\\main\\java\\com\\xx\\model\\query & windows
        //\\xx-service/src/main/java/com/xx/model/query & mac or linux
        config.setQueryModelPath(projectPath + "/src/main/java/com/flyoil/cateye/model/query");

        Generator.generate(config,
                new VoHandler("com.flyoil.cateye.vo", projectPath + "/src/main/java/com/flyoil/cateye/vo", true),
                new QueryModelHandler(),
                new MybatisMapperHandler(),
                new MybatisXmlHandler(false),
                new MysqlHandler(false)
        );
    }


}
