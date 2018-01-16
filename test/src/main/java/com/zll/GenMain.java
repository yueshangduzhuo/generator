package com.zll;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenMain {
    public static void main(String[] args) {
        boolean overwrite = true;
        //读取文件
        File configFile = new File(GenMain.class.getResource("/generatorConfig.xml").getFile());
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        //true:覆盖生成
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        ProgressCallback progressCallback = new VerboseProgressCallback();
        try {
            config = cp.parseConfiguration(configFile);
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(progressCallback);
            System.err.println("代码成功生成!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
