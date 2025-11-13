package framework.utils;


import com.google.gson.Gson;
import framework.models.Env;
import framework.models.EnvData;
import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class SettingsTestData {
    private final String PATH_OF_THE_PROJECT = System.getProperty("user.dir");


    public final String RESOURCE_FILE_PATH = PATH_OF_THE_PROJECT + "\\src\\main\\resources\\";
    private final String ENV_FILE_PATH = RESOURCE_FILE_PATH + "env.json";
    private final String PROD_ENV_FILE_PATH = RESOURCE_FILE_PATH + "prodenv.json";
    private final String USER_FILE_PATH = RESOURCE_FILE_PATH + "userData.json";
    private final String DATA_TABLE_FILE_PATH = RESOURCE_FILE_PATH + "dataTableData.json";
    private final String FILE_DATA_PATH = RESOURCE_FILE_PATH + "fileData.json";
    private final String ERROR_MSG = "File with environment settings not found or incorrect";
    private Gson gson = new Gson();


    private Env getEnvironment() {
        try {
            return gson.fromJson(new FileReader(ENV_FILE_PATH), Env.class);
        } catch (FileNotFoundException e) {
//            AqualityServices.getLogger().error(ERROR_MSG);
            System.out.println(e);
            throw new RuntimeException(ERROR_MSG);
        }
    }

    public EnvData getEnvData() {
        try {
            if (getEnvironment().getEnv().equals("prod")) {
                return gson.fromJson(new FileReader(PROD_ENV_FILE_PATH), EnvData.class);
            }
            System.out.println("Env is not set");
            throw new RuntimeException(ERROR_MSG);
        } catch (FileNotFoundException e) {
            System.out.println(e);
            throw new RuntimeException(ERROR_MSG);
        }
    }

//    public UserData getUserData() {
//        try {
//            return gson.fromJson(new FileReader(USER_FILE_PATH), UserData.class);
//        } catch (FileNotFoundException e) {
//            AqualityServices.getLogger().error(ERROR_MSG);
//            throw new RuntimeException(ERROR_MSG);
//        }
//    }
//
//    public DataTableData getDataTableData() {
//        try {
//            return gson.fromJson(new FileReader(DATA_TABLE_FILE_PATH), DataTableData.class);
//        } catch (FileNotFoundException e) {
//            AqualityServices.getLogger().error(ERROR_MSG);
//            throw new RuntimeException(ERROR_MSG);
//        }
//    }
//
//    public FileData getFileData() {
//        try {
//            return gson.fromJson(new FileReader(FILE_DATA_PATH), FileData.class);
//        } catch (FileNotFoundException e) {
//            AqualityServices.getLogger().error(ERROR_MSG);
//            throw new RuntimeException(ERROR_MSG);
//        }
//    }
}
