package org.admiral.util;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Ini implements Serializable {
    public static final String	ARCHIVO_PROPIEDADES_ADMIRAL = "Admiral.properties";
    private static Properties s_prop =new Properties();
    private static boolean	s_client = true;
    public static final String	ENV_PREFIX	= "env.";
    public static final String	ADM_HOME = "ADM_HOME";
    public static final String P_CONNECTION = "Connection";
    public static final String DEFAULT_CONNECTION = "";

    private static final String[] PROPERTIES = new String[]{P_CONNECTION};
    private static final String[] VALUES = new String[]{
            DEFAULT_CONNECTION
    };


    private static Logger log = Logger.getLogger("org.admiral.util.Ini");

    public static void setClient(boolean client){
        s_client =  client;
    }

    public static String getADMHome(){
        String env = System.getProperty(ENV_PREFIX + ADM_HOME);
        if(env == null){
            env = System.getProperty(ADM_HOME);
        }
        return env;
    }

    private static String getFileName(boolean tryUserHome){
        if(System.getProperty("PropertyFile") != null){
            return System.getProperty("PropertyFile");
        }
        String base = null;

        if(tryUserHome && s_client){
            base = System.getProperty("user.home");
        }

        // server mode
        if(!s_client || (base == null) || (base.length() == 0)){
            String home = getADMHome();
            if(home != null){
                base = home;
            }
        }

        if((base != null) && !base.endsWith(File.separator)){
            base += File.separator;
        }

        if(base == null){
            base = "";
        }

        return base +ARCHIVO_PROPIEDADES_ADMIRAL;
    }

    public static boolean loadProperties(String fileName){
        boolean loadOk = true;
        boolean firstTime = false;

        s_prop = new Properties();
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(fileName);
            s_prop.load(fis);
            fis.close();
        }
        catch(FileNotFoundException e){
            log.warning(fileName + " not found");
            loadOk = false;
        }
        catch(Exception e){
            log.log(Level.SEVERE, fileName + " - " + e.toString());
            loadOk = false;
        }
        catch(Throwable t){
            log.log(Level.SEVERE, fileName + " - ", t.toString());
            loadOk = false;
        }
    }

    public static void loadProperties(boolean reload){
        if(reload == false || (s_prop.size() == 0)){
            loadProperties(getFileName(s_client));
        }
    }
}
